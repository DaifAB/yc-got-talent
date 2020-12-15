package com.getTalent.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import com.gotTalent.config.Config;
import com.gotTalent.models.User;

public class UserController extends User {
	

	Config config;
	Scanner scanner;
	
	public UserController(long id, String fname, String lname, String email ,String phone) throws SQLException {
		super(id, fname, lname, email, phone);
		
	}
	public UserController() throws ClassNotFoundException {
		
		config = new Config("jdbc:mysql://localhost/youcode_tallent","Sketch","abdel996");
		scanner = new Scanner(System.in);
	}
	
	public void addUser() throws SQLException, ClassNotFoundException {
		
		  Random rd = new Random();
	      long id = (long)(rd.nextDouble()*1000000000L);
		
	  	  System.out.println("Enter your first name:");
		  String fname = scanner.next();
		  System.out.println("Enter your last name:");
		  String lname = scanner.next();
		  System.out.println("Enter your email:");
		  String email = scanner.next();
		  System.out.println("Enter your phone number:");
		  String phone = scanner.next();
		  String sqlString = "INSERT into users (user_id ,first_name, last_name, email, phone) values(?,?,?,?,?)";
		  java.sql.PreparedStatement statement = config.connect().prepareStatement(sqlString);
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
		java.sql.PreparedStatement statement = config.connect().prepareStatement(sqlString);
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
		  long id = scanner.nextLong();
		  System.out.println("Enter your first name:");
		  String fname = scanner.next();
		  System.out.println("Enter your last name:");
		  String lname = scanner.next();
		  System.out.println("Enter your email:");
		  String email = scanner.next();
		  System.out.println("Enter your phone number:");
		  String phone = scanner.next();
		  String sqlString = "update  users SET  first_name=?, last_name=?, email=?, phone=? WHERE user_id=?";
		  java.sql.PreparedStatement statement = config.connect().prepareStatement(sqlString);
			statement.setString(1, fname);
			statement.setString(2, lname);
			statement.setString(3, email);
			statement.setString(4, phone );
			statement.setLong(5, id);
			statement.executeUpdate();
		 
		System.out.println("Your informations are successfully updated");
	
		
		
	}
	
	
	

}
