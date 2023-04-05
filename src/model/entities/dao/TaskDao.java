package model.entities.dao;

import java.util.List;

import model.entities.Task;
import model.entities.User;

public interface TaskDao {

	boolean insertTask(Task obj);
	boolean updateTaskTitle(Task obj);
	boolean updateTaskContent(Task obj);
	boolean updateTaskStatus(Task obj);
	boolean deletTask(Task obj);
	Task findById(Task obj);
	List<Task> findTodo(User obj);
	List<Task> findDoing(User obj);
	List<Task> findDone(User obj);
	List<Task> findAll(User obj);
}
