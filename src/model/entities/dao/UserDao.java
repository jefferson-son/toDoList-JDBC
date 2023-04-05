package model.entities.dao;

import model.entities.User;

public interface UserDao {

	boolean insertUser(User obj);
	void updateUser(User obj);
	void deleteUser(User obj);
	User findByEmail(User obj);
	
}
