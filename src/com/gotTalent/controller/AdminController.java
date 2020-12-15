package com.gotTalent.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.gotTalent.config.Config;
import com.gotTalent.models.Administrator;
import com.gotTalent.models.User;


public class AdminController {
	
	Config config;
	Scanner scanner;
	Connection connection;
	
	
	public AdminController() throws ClassNotFoundException, SQLException {
		
		config = new Config("jdbc:mysql://localhost/youcode_tallent","Sketch","abdel996");
		scanner = new Scanner(System.in);
		connection = config.connect();
	}
	
	
	public  ArrayList<User> getUsers() throws SQLException, ClassNotFoundException {
		
		//declaring the array list
		ArrayList<User> usersList = new ArrayList<>();
		
		String sqlString = "SELECT * FROM users";
		PreparedStatement statement = connection.prepareStatement(sqlString);
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()) {

			User user  = new User(resultSet.getLong("user_id"),resultSet.getString("first_name"),resultSet.getString("last_name"),resultSet.getString("email"),resultSet.getString("phone"));
			usersList.add(user);
			
		}
		
		for(User list: usersList) {
	        System.out.println(list.toString());
	    }
		
		return usersList;
		
	}

	public void adminConnected() throws SQLException {
	
	
	
	String sqlString = "Update admin_session SET  is_connected=true WHERE id_admin=15970010";
	PreparedStatement statement = connection.prepareStatement(sqlString);
	statement.executeUpdate();
	System.out.println("Admin Logged in succesfully");
}

	public void adminDisconnected() throws SQLException {
	
	String sqlString = "Update admin_session SET  is_connected=false WHERE id_admin=15970010";
	PreparedStatement statement = connection.prepareStatement(sqlString);
	statement.executeUpdate();
	System.out.println("Admin Logged out succesfully");
}

	public boolean isLoggedin() throws SQLException {
	String sqlString = "SELECT * FROM admin_session";
	PreparedStatement statement = connection.prepareStatement(sqlString);
	ResultSet resultSet = statement.executeQuery();
	return resultSet.getBoolean("is_connected");
	
}c
	
	public  ArrayList<particiation> getParticiation(){
		
		ArrayList<particiation> particiationList = new ArrayList<>();
		
		
	}




	
}
