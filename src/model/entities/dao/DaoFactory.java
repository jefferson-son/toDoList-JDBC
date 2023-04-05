package model.entities.dao;

import db.DB;
import model.entities.dao.impl.TaskDaoJDBC;
import model.entities.dao.impl.UserDaoJDBC;

public class DaoFactory {

	public static UserDao createUserDao() {
		return new UserDaoJDBC(DB.getConnection());
	}
	
	public static TaskDao createTaskDao() {
		return new TaskDaoJDBC(DB.getConnection());
	}
}
