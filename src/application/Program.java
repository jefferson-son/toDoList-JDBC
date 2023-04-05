package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.Task;
import model.entities.User;
import model.entities.dao.DaoFactory;
import model.entities.dao.TaskDao;
import model.entities.dao.UserDao;
import model.entities.enums.Status;
import model.utilities.Validation;

public class Program {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// Start program
		home();
	}
	
	// Home page
	public static void home() {
		
		boolean run = true;
		
		while(run) {
			System.out.println("=======================");
			System.out.println("|       TodoList      |");
			System.out.println("=======================");
			System.out.println("[1] Fazer cadastro");
			System.out.println("[2] Fazer login");
			System.out.println("[3] Sair");
			
			switch (Validation.InputValidation(": ")) {
				case 1:
					System.out.println("==== CADASTRO ====");
					System.out.print("Digite seu nome: ");
					String name = sc.nextLine();
					System.out.print("Digite seu email: ");
					String email = sc.nextLine();
					System.out.print("Digite sua senha: ");
					String password = sc.nextLine();
					
					User user = new User(null, name, email, password);
					if(user.getName() == "" || user.getEmail() == "" || user.getPassword() == "") {
						System.out.println("\tTodos os campos devem ser preenchidos!");
					}
					else {
						UserDao newUser = DaoFactory.createUserDao();
						if (newUser != null) {
							boolean insert = newUser.insertUser(user);
							if(insert) {
								System.out.println("\tUsuário Cdastrado com sucesso!");
							}
						}
					}
					
					break;
					
				case 2:
					System.out.println("==== LOGIN ====");
					System.out.print("Digite seu email: ");
					String emailLog = sc.nextLine();
					System.out.print("Digite sua senha: ");
					String passwordLog = sc.nextLine();
					
					User userLog = new User(null, null, emailLog, passwordLog);
					UserDao find = DaoFactory.createUserDao();
					
					if (find.findByEmail(userLog) == null) {
						System.out.println("\tEmail ou senha não conferem!");
					}
					else {
						User userLoged = find.findByEmail(userLog);
						if(userLoged.equals(find.findByEmail(userLog))) {
							dashBoardTasks(userLoged);
						}
					}
					break;

				case 3:
					run = false;
					break;
			}
		}
	}
	
	// Dashboard tasks page
	public static void dashBoardTasks(User userLoged) {
		
		boolean run = true;
		
		while(run) {
			System.out.println("======================");
			System.out.println("|  DashBoard Tarefas |");
			System.out.println("======================");
			System.out.println("[1] Listar tarefas");
			System.out.println("[2] Adicionar tarefa");
			System.out.println("[3] Atualizar tarefa");
			System.out.println("[4] Remover tarefa");
			System.out.println("[5] Sair");
			
			switch (Validation.InputValidation(":")) {
				case 1:
					tasksList(userLoged);
					break;
				case 2:
					System.out.println("==== ADICIONAR TAREFA ====");
					System.out.print("Digite o título: ");
					String title = sc.nextLine();
					sc.nextLine();
					System.out.print("Digite o conteúdo: ");
					String content = sc.nextLine();
					System.out.print("Digite o status (TODO/DOING/DONE): ");
					Status status = Status.valueOf(sc.nextLine());
					
					Task newTask = new Task(null, title, content, status, userLoged.getId());
					TaskDao taskDao = DaoFactory.createTaskDao();
					if(taskDao.insertTask(newTask)) {
						System.out.println("\tTarefa adicionada com sucesso!");
					}
					else {
						System.out.println("\tErro ao tentar criar tarefa! Tente novamente.");
					}
					
					break;
				case 3:
					taskToUpdate(userLoged);
					break;
				case 4:
					System.out.println("==== REMOVER TAREFA ====");
					
					Task findTaskById = new Task(Validation.InputValidation(" da tarefa: "), null, null, null, null);
					TaskDao task = DaoFactory.createTaskDao();
					
					Task delete = null;
					findTaskById = task.findById(findTaskById);
					
					while(findTaskById == null) {
						System.out.println("\tTarefa não encontrada! Tente novamente.");
						findTaskById = new Task(Validation.InputValidation(" da tarefa: "), null, null, null, null);
						findTaskById = task.findById(findTaskById);
					}
					
				
					System.out.print("\tTarefa a ser deletada: ");
					System.out.println(findTaskById);
					delete = findTaskById;
					System.out.println();
					
				
					System.out.print("Deseja realmente excluir essa tarefa [s/n]: ");
					char choice = sc.next().charAt(0);
					if (choice == 's') {
						task.deletTask(delete);
						System.out.println("\tTarefa deletada com sucesso!");
					}
					
					break;
				case 5:
					run = false;
					break;
			}
		}
	}
	
	public static void taskToUpdate(User userLoged) {
		boolean run = true;
		
		while (run) {
			System.out.println("==== TAREFA A SER ATUALIZADA ====");
			
			Task findTaskById = new Task(Validation.InputValidation(" da tarefa: "), null, null, null, null);
			TaskDao task = DaoFactory.createTaskDao();
			
			findTaskById = task.findById(findTaskById);
			if(findTaskById != null) {
				System.out.println(findTaskById);
				System.out.println();
				
				updateTask(userLoged, findTaskById);
				run = false;
			}
			else {
				System.out.println("\tTarefa não encontrada! Tente novamente.");
			}
		}
	}
	
	public static void updateTask(User userLoged, Task task) {
		boolean run = true;
		
		while(run) {
			System.out.println("==== ATUALIZAR TAREFA ====");
			System.out.println("[1] Atualizar título");
			System.out.println("[2] Atualizar conteúdo");
			System.out.println("[3] Atualizar status");
			System.out.println("[4] Sair");
			
			switch(Validation.InputValidation(": ")) {
				
				case 1:
					System.out.println("==== ATUALIZAR TÍTULO ====");
					System.out.print("Digite o novo título: ");
					String newTitle = sc.nextLine();
					task.setTitle(newTitle);
					TaskDao updateTitle = DaoFactory.createTaskDao();
					boolean titleUpdated = updateTitle.updateTaskTitle(task);
					
					if(titleUpdated) {
						System.out.println("\tTítulo atualizado com sucesso!");
						System.out.println(task);
					}
					break;
					
				case 2:
					
					System.out.println("==== ATUALIZAR CONTEÚDO ====");
					System.out.print("Digite o novo conteúdo: ");
					String newContent = sc.nextLine();
					task.setContent(newContent);
					TaskDao updateContent = DaoFactory.createTaskDao();
					boolean contentUpdated = updateContent.updateTaskTitle(task);
					
					if(contentUpdated) {
						System.out.println("\tConteúdo atualizado com sucesso!");
						System.out.println(task);
					}
					break;
					
				case 3:
					System.out.println("==== ATUALIZAR STATUS ====");
					Status newStatus = Status.valueOf(Validation.statusValidation());
					task.setStatus(newStatus);
					TaskDao updateStatus = DaoFactory.createTaskDao();
					
					boolean statusUpdated = updateStatus.updateTaskTitle(task);
					
					if(statusUpdated) {
						System.out.println("\tStatus atualizado com sucesso!");
						System.out.println(task);
					}
					break;
					
				case 4:
					run = false;
					break;
			}
		}
	}
	// List tasks page
	public static void tasksList(User userLoged) {
		
		boolean run = true;
		
		while(run) {
			System.out.println("======================");
			System.out.println("| Listar de Tarefas  |");
			System.out.println("======================");
			System.out.println("[1] Listar todas as tarefas");
			System.out.println("[2] Listar tarefa por código");
			System.out.println("[3] Listar tarefas (TODO)");
			System.out.println("[4] Listar tarefas (DOING)");
			System.out.println("[5] Listar tarefas (DONE)");
			System.out.println("[6] Sair");
			
			switch (Validation.InputValidation(": ")) {
				case 1:
					System.out.println("==== TAREFAS ====");
					List<Task> list = new ArrayList<>();
					TaskDao tasks = DaoFactory.createTaskDao();
					list = tasks.findAll(userLoged);
					if(list.isEmpty()) {
						System.out.println("\tAinda sem tarefas!");
					}
					
					list.forEach(System.out::println);
					
					break;
				case 2:
					System.out.println("==== TAREFA POR CÓDIGO ====");
					System.out.print("Digite o código: ");
					int code = sc.nextInt();
					
					Task findTaskById = new Task(code, null, null, null, null);
					TaskDao task = DaoFactory.createTaskDao();
					
					findTaskById = task.findById(findTaskById);
					if(findTaskById != null) {
						System.out.println(findTaskById);
					}
					else {
						System.out.println("\tTarefa não encontrada!");
					}
					break;
				case 3:
					System.out.println("==== TAREFAS TODO====");
					List<Task> listTodo = new ArrayList<>();
					TaskDao tasksTodo = DaoFactory.createTaskDao();
					listTodo = tasksTodo.findTodo(userLoged);
					if(listTodo.isEmpty()) {
						System.out.println("\tAinda sem tarefas!");
					}
					
					listTodo.forEach(System.out::println);
					break;
				case 4:
					System.out.println("==== TAREFAS DOING====");
					List<Task> listDoing = new ArrayList<>();
					TaskDao tasksDoing = DaoFactory.createTaskDao();
					listDoing = tasksDoing.findDoing(userLoged);
					if(listDoing.isEmpty()) {
						System.out.println("\tAinda sem tarefas!");
					}
					
					listDoing.forEach(System.out::println);
					break;
				case 5:
					System.out.println("==== TAREFAS DOING====");
					List<Task> listDone = new ArrayList<>();
					TaskDao tasksDone = DaoFactory.createTaskDao();
					listDone = tasksDone.findDone(userLoged);
					if(listDone.isEmpty()) {
						System.out.println("\tAinda sem tarefas!");
					}
					
					listDone.forEach(System.out::println);
					break;
				case 6:
					run = false;
					break;
			}
			
		}
	}

}
