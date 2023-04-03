package model.entities.dao;

import model.entities.User;

public interface UserDao {

	void insertUser(User obj);
	void updateUser(User obj);
	void deleteUser(User obj);
	User findById(User obj);
	
}
