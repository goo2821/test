package com.lee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.Object;
import com.lee.model.User;
import com.lee.util.DbUtil;

public class UserDao {

	private Connection connection;

	public UserDao() {
		this.connection = DbUtil.getConnection();
	}

	public void addUser(User user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into users(id,password,name,age,sex,email) values (?, ?, ?, ?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setString(1, user.getId());
			preparedStatement.setString(2,  user.getPassword());
			preparedStatement.setString(3, user.getName());
			preparedStatement.setInt(4, user.getAge());
			preparedStatement.setString(5,  user.getSex());
			preparedStatement.setString(6, user.getEmail());
			int num = preparedStatement.executeUpdate();
			
			System.out.println(num);
			preparedStatement.close();
			connection.close();
			
		} catch (SQLException e) {
		  System.out.println("sql 예외");
		} catch (Exception e) {
		  System.out.println("일반 예외");
		}
	}
	
	public void deleteUser(int userId) { // ��遺�遺� 洹몃�濡� �궗�슜�빐�룄 �릪
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from users where userid=?");
			// Parameters start with 1
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Object getAllUsers() {
	    Object users = null;
		try {
			Statement statement = connection.createStatement();
			users = statement.executeQuery("select * from users");
			System.out.println(users);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}
	
	public User getUserById(int userId) {
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from users where userid=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				user.setUserid(rs.getInt("userid"));
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getString("sex"));
				user.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
}
