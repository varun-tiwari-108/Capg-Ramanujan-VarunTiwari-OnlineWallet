package com.capgemini.entities;

public class Login {
	
	int userId;
	String pass;
	
	public Login()
	{
		super();
	}

	public Login(int userId, String pass) {
		super();
		this.userId = userId;
		this.pass = pass;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	

}
