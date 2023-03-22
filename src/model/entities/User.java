package model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class User {

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

	@Override
	public String toString() {
		return "Usuário: " 
				+ name 
				+ "\t Email: "
				+ email
				+ "\t Senha: "
				+ password;
	}
	
	
}
