package model.utilities;

import java.util.Scanner;

public class Validation {
	public static Scanner sc = new Scanner(System.in);

	public static int InputValidation(String arrow) {

		int code = 0;
		boolean inputMatch = true;

		while (inputMatch) {
			System.out.print("Digite o código" + arrow);
			while (inputMatch) {
				try {
					code = Integer.parseInt(sc.next());
					break;
				} catch (NumberFormatException e) {
					System.out.println("\tEntrada inválida!");
					System.out.print("Digite o código novamante:");
				}
			}
			inputMatch = false;
		}
		sc.nextLine();
		return code;

	}

	public static String statusValidation() {

		String status = null;
		boolean statusValid = false;
		
		while (!statusValid) {

			System.out.print("Digite o novo status: ");
			status = sc.nextLine();
			if (status.equals("TODO") || status.equals("DOING") || status.equals("DONE")) {
				statusValid = true;
				return status;
			}
			System.out.println("\tStatus inválido!");
		}

		return status;
	}
}
