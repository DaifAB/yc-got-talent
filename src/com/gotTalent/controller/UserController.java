package com.gotTalent.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import com.gotTalent.config.Config;
import com.gotTalent.models.User;

public class UserController {
	

	Config config;
	Scanner scanner;
	Connection connection;
	
	
	public UserController() throws ClassNotFoundException, SQLException {
		
		config = new Config("jdbc:mysql://localhost/youcode_tallent","Sketch","abdel996");
		scanner = new Scanner(System.in);
		connection = config.connect();
	}
	
	public void addUser() throws SQLException, ClassNotFoundException {
		
		  Random rd = new Random();
	      long id = (long)(rd.nextDouble()*1000000000L);
		
	  	  System.out.println("Enter your first name:");
		  String fname = scanner.nextLine();
		  System.out.println("Enter your last name:");
		  String lname = scanner.nextLine();
		  System.out.println("Enter your email:");
		  String email = scanner.nextLine();
		  System.out.println("Enter your phone number:");
		  String phone = scanner.nextLine();
		  String sqlString = "INSERT into users (user_id ,first_name, last_name, email, phone) values(?,?,?,?,?)";
		  PreparedStatement statement = connection.prepareStatement(sqlString);
			statement.setLong(1, id);
			statement.setString(2, fname);
			statement.setString(3, lname);
			statement.setString(4, email);
			statement.setString(5, phone );
			statement.executeUpdate();
		 
		System.out.println("Your inscription is done successfully, This is your id : "+ id);
	}
	
	public  User findUserById() throws SQLException, ClassNotFoundException {
		
		System.out.println("Enter the id of the user you are looking for:");
		long id = scanner.nextLong();
		String sqlString = "SELECT * FROM users WHERE user_id = ?";
		PreparedStatement statement = connection.prepareStatement(sqlString);
		statement.setLong(1, id);
		User user  = new User();
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {
			user.setId(id);
			user.setFname(resultSet.getString("first_name"));
			user.setLname(resultSet.getString("last_name"));
			user.setEmail(resultSet.getString("email"));
			user.setPhone(resultSet.getString("phone"));
			
		}
		return user;
		
		
		
	}
	
	public void updateUser() throws ClassNotFoundException, SQLException {
		
		
		  System.out.println("Enter your id:");
		  String idstr = scanner.nextLine();
		  long id = Long.parseLong(idstr);
		  System.out.println("Enter your first name:");
		  String fname = scanner.nextLine();
		  System.out.println("Enter your last name:");
		  String lname = scanner.nextLine();
		  System.out.println("Enter your email:");
		  String email = scanner.nextLine();
		  System.out.println("Enter your phone number:");
		  String phone = scanner.nextLine();
		  String sqlString = "update  users SET  first_name=?, last_name=?, email=?, phone=? WHERE user_id=?";
		  java.sql.PreparedStatement statement = connection.prepareStatement(sqlString);
			statement.setString(1, fname);
			statement.setString(2, lname);
			statement.setString(3, email);
			statement.setString(4, phone );
			statement.setLong(5, id);
			statement.executeUpdate();
		 
		System.out.println("Your informations are successfully updated");
	
		
		
	}
	
	
	

}
