package model.entities;

import java.io.Serializable;
import java.util.Objects;

import model.entities.enums.Status;

public class Task implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String title;
	private String content;
	private Integer status;
	private Integer user_id;

	public Task() {
	}

	public Task(Integer id, String title, String content, Status status, Integer user_id) {
		this.id = id;
		this.title = title;
		this.content = content;
		setStatus(status);
		this.user_id = user_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return Status.valueOf(status);
	}

	public void setStatus(Status status) {
		if (status != null) {
			this.status = status.getCode();
		}
		
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, id, status, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(content, other.content) && Objects.equals(id, other.id) && status == other.status
				&& Objects.equals(title, other.title);
	}

}
