package model.entities.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DbException;
import model.entities.User;
import model.entities.dao.UserDao;

public class UserDaoJDBC implements UserDao {

	private Connection conn;

	public UserDaoJDBC (Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean insertUser(User obj) {
		
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO users(name, email, password) VALUES(?,?,?)");
			
			st.setString(1, obj.getName());
			st.setNString(2, obj.getEmail());
			st.setString(3, obj.getPassword());
			
			int arrowsAffected = st.executeUpdate();
			
			if(arrowsAffected > 0) {
				return true;
			}
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		return false;

	}

	@Override
	public void updateUser(User obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(User obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findByEmail(User obj) {
		
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("SELECT * FROM users WHERE users.email = ? AND users.password = ?");
			
			st.setString(1, obj.getEmail());
			st.setString(2, obj.getPassword());
		
			ResultSet rs = st.executeQuery();

			if(rs.next()) {
				
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				return u;
			}
			return null;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

}
