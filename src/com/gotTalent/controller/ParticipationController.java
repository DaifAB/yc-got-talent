package com.gotTalent.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

import com.gotTalent.config.Config;
import com.gotTalent.models.User;

public class ParticipationController {

	Config config;
	Scanner scanner;
	Connection connection;
	
	
	public ParticipationController() throws ClassNotFoundException, SQLException {
		
		config = new Config("jdbc:mysql://localhost/youcode_tallent","Sketch","abdel996");
		scanner = new Scanner(System.in);
		connection = config.connect();
	}
	
	public void addParticipation() throws SQLException {
		
		System.out.println("Enter your id:");
		String idStr = scanner.nextLine();
		long id = Long.parseLong(idStr);
		
		
		
		System.out.println("Choose your category:");

		String sqlString = "SELECT * FROM categories";
		PreparedStatement statement = connection.prepareStatement(sqlString);
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()) {
			System.out.println(resultSet.getLong("id_category")+". "+resultSet.getString("category_name"));
		}
		
		String categoryStr = scanner.nextLine();
		long category = Long.parseLong(categoryStr);
		
		System.out.println("Enter the description of your talent:");
		String desc = scanner.nextLine();
		
		System.out.println("Enter the start time of your show: (yyy-mmm-dd h:m:s)");
		String startTime = scanner.nextLine();
		Timestamp startTimestamp = Timestamp.valueOf(startTime);
		
		System.out.println("Enter the end time of your show: (yyy-mmm-dd h:m:s)");
		String endTime = scanner.nextLine();
		Timestamp endTimestamp = Timestamp.valueOf(endTime);
		
		System.out.println("Enter the path of your attached file:");
		String file = scanner.nextLine();
		
		boolean is_accepted = false;
		
		String query = "INSERT into participation (user_id ,id_category, description, show_start_time, show_end_time,attached_file,is_accepted) values(?,?,?,?,?,?,?)";
		  PreparedStatement statement1 = connection.prepareStatement(query);
			statement1.setLong(1, id);
			statement1.setLong(2, category);
			statement1.setString(3, desc);
			statement1.setTimestamp(4, startTimestamp);
			statement1.setTimestamp(5, endTimestamp );
			statement1.setString(6, file);
			statement1.setBoolean(7, is_accepted );
			
			statement1.executeUpdate();
		 
		System.out.println("Check your email for more information.");
				
	}
}
