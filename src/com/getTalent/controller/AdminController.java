package com.getTalent.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.gotTalent.config.Config;
import com.gotTalent.models.Administrator;
import com.gotTalent.models.User;


public class AdminController extends Administrator {
	
	Config config;
	Scanner scanner;
	
	public AdminController(long id, String fname, String lname, String email ,String phone, String password) throws SQLException {
		super();
		
	}
	public AdminController() throws ClassNotFoundException {
		
		config = new Config("jdbc:mysql://localhost/youcode_tallent","Sketch","abdel996");
		scanner = new Scanner(System.in);
	}
	
	
public  ArrayList<User> getUsers() throws SQLException, ClassNotFoundException {
		
		
		ArrayList<User> usersList = new ArrayList<>();
		
		String sqlString = "SELECT * FROM users";
		java.sql.PreparedStatement statement = config.connect().prepareStatement(sqlString);
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
	
}
