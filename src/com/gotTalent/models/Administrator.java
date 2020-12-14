package com.gotTalent.models;

public class Administrator extends User {
	
	private String password;

	public Administrator(String password) {
		super();
		this.password = password;
	}
	
	public Administrator() {}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Administrator [password=" + password + ", toString()=" + super.toString() + "]";
	}

	
	
	
	
	

}
