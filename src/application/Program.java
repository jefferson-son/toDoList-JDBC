package application;

import model.entities.Usuario;

public class Program {

	public static void main(String[] args) {

		Usuario usuario = new Usuario("Jefferson", "jefferson@gmail.com", "123");

		System.out.println(usuario);
	}

}
