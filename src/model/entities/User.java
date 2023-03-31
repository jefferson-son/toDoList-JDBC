package model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import model.entities.enums.Status;

public class User {

	Scanner sc = new Scanner(System.in);
	Random idGenerator = new Random();

	private Integer id = idGenerator.nextInt(1000);
	private String name;
	private String email;
	private String password;

	private List<Task> tasks = new ArrayList<>();

	public User() {
	}

	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Task> getTasks() {  
		return tasks;
	}
	
	

	public void viewTasks() {
		
		if(tasks.isEmpty()) {
			System.out.println("==== TAREFAS ====");
			System.out.println("** Sem tarefas cadastradas **");
			System.out.println();
		}
		else {
			System.out.println("==== TAREFAS ====");
			System.out.println("[1] Todas as Tarefas");
			System.out.println("[2] Tarefas TODO");
			System.out.println("[3] Tarefas DOING");
			System.out.println("[4] Tarefas DONE");
			System.out.print("Digite sua opção: ");
			int optionTask = sc.nextInt();
			sc.nextLine();
			
			switch (optionTask) {
				case 1: {
					for(int i = 0; i < getTasks().size(); i++) {
						System.out.println("Tarefa [" + i + "]: ");
						System.out.println("\t " + getTasks().get(i));
					}
					System.out.println();
					break;
				}
				case 2: {
					for(int i = 0; i < getTasks().size(); i++) {
						if(getTasks().get(i).getStatus() == Status.valueOf("TODO")) {
							System.out.println("Tarefa [" + i + "]: ");
							System.out.println("\t " + getTasks().get(i));
						}
					}
					System.out.println();
					break;
				}
				case 3: {
					for(int i = 0; i < getTasks().size(); i++) {
						if(getTasks().get(i).getStatus() == Status.valueOf("DOING")) {
							System.out.println("Tarefa [" + i + "]: ");
							System.out.println("\t " + getTasks().get(i));
						}
					}
					System.out.println();
					break;
				}
				case 4: {
					for(int i = 0; i < getTasks().size(); i++) {
						if(getTasks().get(i).getStatus() == Status.valueOf("DONE")) {
							System.out.println("Tarefa [" + i + "]: ");
							System.out.println("\t " + getTasks().get(i));
						}
					}
					System.out.println();
					break;
				}
			}
		
		}
	}
	
	
	public void addTask() {
		System.out.println("==== ADICIONAR TAREFA ====");
		System.out.print("Título: ");
		String title = sc.nextLine();
		System.out.print("Conteúdo: ");
		String content = sc.nextLine();
		System.out.print("Status [TODO / DOING / DONE]: ");
		String status = sc.nextLine();

		Task task = new Task(title, content, Status.valueOf(status));
		tasks.add(task);
		System.out.println();
	}

	public void updateTask() {
		System.out.print("Digite o código da tarefa que deseja atualizar: ");
		int taskUpdate = sc.nextInt();
		
		boolean findTask = false;
		
		for(int i = 0; i < getTasks().size(); i++) {
			if(getTasks().get(i).getId() == taskUpdate) {
				
				System.out.println("\t Tarefa a ser atualizada: " + getTasks().get(i));
				
				Task tks = getTasks().get(i);
				
				System.out.println("[1] Atualizar titulo");
				System.out.println("[2] Atualizar conteúdo");
				System.out.println("[3] Atualizar status");
				System.out.print("Digite a opção:");
				int update = sc.nextInt();
				sc.nextLine();

				switch (update) {
					case 1: {
						System.out.print("Digite o novo título: ");
						String nameUpdate = sc.nextLine();
						tks.setTitle(nameUpdate);
						System.out.println();
						break;
					}
					case 2: {
						System.out.print("Digite o novo conteúdo: ");
						String newContent = sc.nextLine();
						tks.setContent(newContent);
						System.out.println();
						break;
					}
					case 3: {
						System.out.print("Digite o novo status [TODO / DOING / DONE]: ");
						String newStatus = sc.nextLine();
						tks.setStatus(Status.valueOf(newStatus));
						System.out.println();
						break;
					}
				}
			findTask = true;
			break;	
			}
		}
		
		if(findTask == false) {
			System.out.println("Tarefa não encontrada!");
		}
	}

	public void removeTask() {
		System.out.print("Digite o código da tarefa que deseja excluir: ");
		int taskRemove = sc.nextInt();
		
		boolean findTask = false;
		
		for(int i = 0; i < getTasks().size(); i++) {
			if(getTasks().get(i).getId() == taskRemove) {
				System.out.println("Tarefa se ser exluída: " + getTasks().get(i));
				System.out.println("Confirmar exclusão [s/n]: ");
				char confirmation = sc.next().charAt(0);
				if(confirmation == 's') {
					tasks.remove(i);
				}
			}
			findTask = true;
		}
		if(findTask == false) {
			System.out.println("Tarefa não encontrada!");
		}
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email);
	}

	@Override
	public String toString() {
		return "Usuário: " + name + "\t Email: " + email + "\t Senha: " + password;
	}

}
