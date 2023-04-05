package model.entities.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbException;
import model.entities.Task;
import model.entities.User;
import model.entities.dao.TaskDao;
import model.entities.enums.Status;

public class TaskDaoJDBC implements TaskDao{

	private Connection conn;
	
	public TaskDaoJDBC (Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public boolean insertTask(Task obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("INSERT INTO tasks(title, content, status,user_id) VALUES(?,?,?,?)");
			
			st.setString(1, obj.getTitle());
			st.setString(2, obj.getContent());
			st.setInt(3, obj.getStatus().getCode());
			st.setInt(4, obj.getUser_id());
			
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
	public boolean updateTaskTitle(Task obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("UPDATE tasks set title = ? WHERE id = ?");
			
			st.setString(1, obj.getTitle());
			st.setInt(2, obj.getId());
			
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
	public boolean updateTaskContent(Task obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("UPDATE tasks set content = ? WHERE id = ?");
			
			st.setString(1, obj.getContent());
			st.setInt(2, obj.getId());
			
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
	public boolean updateTaskStatus(Task obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("UPDATE tasks set status = ? WHERE id = ?");
			
			st.setInt(1, obj.getStatus().getCode());
			st.setInt(2, obj.getId());
			
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
	public boolean deletTask(Task obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("DELETE FROM tasks WHERE id = ?");
			
			st.setInt(1, obj.getId());
			
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
	public Task findById(Task obj) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM tasks WHERE tasks.id = ?");
			
			st.setInt(1, obj.getId());
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("id"));
				task.setTitle(rs.getString("title"));
				task.setContent(rs.getString("content"));
				task.setStatus(Status.valueOf(rs.getInt("status")));
				task.setUser_id(rs.getInt("user_id"));
				
				return task;
			}
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Task> findTodo(User obj) {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Task> list = new ArrayList<>();
		try {
			st = conn.prepareStatement("SELECT * FROM tasks WHERE user_id = ? AND status = 1");
			
			st.setInt(1, obj.getId());
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("id"));
				task.setTitle(rs.getString("title"));
				task.setContent(rs.getString("content"));
				task.setStatus(Status.valueOf(rs.getInt("status")));
				task.setUser_id(rs.getInt("user_id"));
				list.add(task);
			}
			
			return list;
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public List<Task> findDoing(User obj) {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Task> list = new ArrayList<>();
		try {
			st = conn.prepareStatement("SELECT * FROM tasks WHERE user_id = ? AND status = 2");
			
			st.setInt(1, obj.getId());
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("id"));
				task.setTitle(rs.getString("title"));
				task.setContent(rs.getString("content"));
				task.setStatus(Status.valueOf(rs.getInt("status")));
				task.setUser_id(rs.getInt("user_id"));
				list.add(task);
			}
			
			return list;
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public List<Task> findDone(User obj) {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Task> list = new ArrayList<>();
		try {
			st = conn.prepareStatement("SELECT * FROM tasks WHERE user_id = ? AND status = 3");
			
			st.setInt(1, obj.getId());
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("id"));
				task.setTitle(rs.getString("title"));
				task.setContent(rs.getString("content"));
				task.setStatus(Status.valueOf(rs.getInt("status")));
				task.setUser_id(rs.getInt("user_id"));
				list.add(task);
			}
			
			return list;
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public List<Task> findAll(User obj) {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Task> list = new ArrayList<>();
		try {
			st = conn.prepareStatement("SELECT * FROM tasks WHERE user_id = ?");
			
			st.setInt(1, obj.getId());
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("id"));
				task.setTitle(rs.getString("title"));
				task.setContent(rs.getString("content"));
				task.setStatus(Status.valueOf(rs.getInt("status")));
				task.setUser_id(rs.getInt("user_id"));
				list.add(task);
			}
			
			return list;
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

}
