package com.gotTalent.app;

import java.sql.SQLException;
import java.util.ArrayList;

import com.getTalent.controller.AdminController;
import com.getTalent.controller.UserController;
import com.gotTalent.models.User;

public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		AdminController a = new AdminController();
		
		
		a.getUsers();
		
		
		

	}

}
