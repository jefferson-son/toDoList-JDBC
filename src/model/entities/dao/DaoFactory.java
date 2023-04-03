package model.entities.dao;

import model.entities.dao.impl.TaskDaoJDBC;
import model.entities.dao.impl.UserDaoJDBC;

public class DaoFactory {

	public static UserDao createUserDao() {
		return new UserDaoJDBC();
	}
	
	public static TaskDao createTaskDao() {
		return new TaskDaoJDBC();
	}
}
