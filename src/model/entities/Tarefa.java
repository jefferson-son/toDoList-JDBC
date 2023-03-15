package model.entities;

import java.util.Random;

import model.entities.enums.Status;

public class Tarefa {

	Random geradorId = new Random();

	private Integer id = geradorId.nextInt(1000);
	private String titulo;
	private String conteudo;
	private Status status;

	public Tarefa(String titulo, String conteudo, Status status) {
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
