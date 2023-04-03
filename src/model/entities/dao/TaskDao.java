package model.entities.dao;

import java.util.List;

import model.entities.Task;

public interface TaskDao {

	void insertTask(Task obj);
	void updateTask(Task obj);
	void deletTask(Task obj);
	Task findById(Task obj);
	List<Task> findTodo(List<Task> obj);
	List<Task> findDoing(List<Task> obj);
	List<Task> findDone(List<Task> obj);
	List<Task> findAll(List<Task> obj);
}
