package model.entities;

import java.util.Random;

import model.entities.enums.Status;

public class Task {

	Random idGenerator = new Random();

	private Integer id = idGenerator.nextInt(1000);
	private String title;
	private String content;
	private Status status;
	
	public Task(Integer id, String title, String content, Status status) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	

}
