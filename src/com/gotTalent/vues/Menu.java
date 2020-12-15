package com.gotTalent.vues;

import java.sql.SQLException;
import java.util.Scanner;

import com.gotTalent.controller.AdminController;
import com.gotTalent.controller.ParticipationController;
import com.gotTalent.controller.UserController;

public class Menu {

		public void menuList() throws ClassNotFoundException, SQLException{
				
				Scanner input = new Scanner(System.in);
				UserController user = new UserController();
				AdminController admin = new AdminController();
				ParticipationController participation = new ParticipationController();
				
			while(true){
				
				System.out.println("Main Menu");
			    System.out.println("1. I'm an User");
			    System.out.println("2. I'm an Admin");
			    
			    
			    int choice = input.nextInt();
			    
			    switch(choice){
			        case 1:
			   
			        		int choice1 = userMenu();
			        		switch(choice1) {
			        		case 1 :
			        			user.addUser();
			        			break;
			        		case 2 : 
			        			user.updateUser();
			        			break;
			        		case 3 : 
			        			participation.addParticipation();
			        			break;
			        		case 4 : 
			        			break;
			        		}
			        		break;
			        	
			        
			        case 2: 
			        	boolean a = true;
			        	String adminEmail = "ahmed.mahmoud.admin@gmail.com";
			        	String adminPswrd = "0000";
			        
			        	System.out.println("Email :");
			        	String email = input.next();
			        	System.out.println("Password :");
			        	String pswrd = input.next();
			        	
			        	
			        	if(email.equals(adminEmail) && pswrd.equals(adminPswrd) ) {
			        		admin.adminConnected();
			        	while(a) {
			        	int choice2 = adminMenu();
		        		switch(choice2) {
		        		case 1 :
		        			admin.getUsers();
		        			break;
		        		case 2 : 
		        			System.out.println(user.findUserById().toString()); 
		        			break;
		        		case 3 : 
		        			System.out.println("Case 3 Medicament");
		        			break;
		        		case 4 : 
		        			System.out.println("Case 4 Medicament");
		        			break;
		        		case 5 : 
		        			System.out.println("Case 5 Medicament");
		        			break;
		        		case 6 : 
		        			admin.adminDisconnected();
		        			a=false;
		        			break;
		        		}
		        		
			        	}
			        	}
			        	else {
			        		System.out.println("Wrong Cridentials !"); 
			        		}
			        	
			        	
     	
			        }
			       
			    }
			    
			
			}
			
			public static int userMenu() {

				//int listSelec;
				Scanner liSele = new Scanner(System.in);

				System.out.println("Choose an action:");
				System.out.println("*****************************\n");
				System.out.println("1 - Register");
				System.out.println("2 - Update your information");
				System.out.println("3 - Participate to Youcode Got Talent");
				System.out.println("4 - Back");

				//listSelec = liSele.nextInt();
				return liSele.nextInt();

			}
			public static int adminMenu() {
				
				
				Scanner liSele = new Scanner(System.in);
				
				System.out.println("Choose an action:");
				System.out.println("*****************************\n");
				System.out.println("1 - Find all users");
				System.out.println("2 - Find user by his id");
				System.out.println("3 - Find all participations");
				System.out.println("4 - Find Participation by email");
				System.out.println("5 - Validate Participation ");
				System.out.println("6 - Log out");

				return liSele.nextInt();
				
			}

			
}
	
	

