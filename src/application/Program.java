package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.User;

public class Program {

	public static Scanner sc = new Scanner(System.in);
	public static List<User> usersList = new ArrayList<>();

	public static void main(String[] args) {

		
		index();
	}

	// Página Index da aplicação
	public static void index() {
		boolean run = true;

		while (run == true) {
			System.out.println("=======================");
			System.out.println("|     My TodoList     |");
			System.out.println("=======================");
			System.out.println("[1] Fazer cadastro");
			System.out.println("[2] Fazer login");
			System.out.println("[3] Sair");
			System.out.print("Digite sua opção: ");
			int option = sc.nextInt();
			sc.nextLine();
			System.out.println();

			switch (option) {
				case 1: {
					System.out.println("==== CADASTRO ====");
					System.out.print("Digite seu nome: ");
					String name = sc.nextLine();
					System.out.print("Digite seu email: ");
					String email = sc.nextLine();
					System.out.print("Digite sua senha: ");
					String password = sc.nextLine();
	
					User user = new User(name, email, password);
					usersList.add(user);
					System.out.println();
					break;
				}
	
				case 2: {
					
					boolean authenticated = false;
					
					while(authenticated == false) {
						System.out.println("==== LOGIN ====");
						System.out.print("Digite seu email: ");
						String email = sc.nextLine();
						System.out.print("Digite sua senha: ");
						String password = sc.nextLine();
		
						for (User u : usersList) {
							if (email.equals(u.getEmail()) && password.equals(u.getPassword())) {
								authenticated = true;
								System.out.println();
								// HomePage após logado
								logged(u);
								break;
							}
						}
						if (!authenticated) {
							System.out.println("Usuário ou senha inválido!");
							System.out.println();
						}
		
					}
				}
	
				case 3: {
					run = false;
					break;
				}

			}

		}

		sc.close();
	}

	// Home page com usuário autenticado
	public static void logged(User user) {

		boolean home = true;

		while (home == true) {

			System.out.println("======================");
			System.out.println("|        Home        |");
			System.out.println("======================");

			System.out.println("[1] Listar tarefas");
			System.out.println("[2] Adicionar tarefa");
			System.out.println("[3] Atualizar tarefa");
			System.out.println("[4] Remover tarefa");
			System.out.println("[5] Sair");
			System.out.print("Digite sua opção: ");
			int option = sc.nextInt();
			sc.nextLine();
			System.out.println();

			// Listagem de todas as tarefas com opção de filtro pelo status
			switch (option) {
				case 1: {
					user.viewTasks();
					break;
				}
				case 2: {
					user.addTask();
					break;
				}
				case 3: {
					user.updateTask();
					break;
				}
				case 4: {
					user.removeTask();
					break;
				}
				case 5: {
					home = false;
					break;
				}
			}
		}
		
		index();

		sc.close();
	}

}
