package com.ajith.exception;

public class UserDefineException extends Exception{

	public String invalidPassword() {
		
		return "Invalid Username and Password";
	}
	
	public String reregister() {
		
		return "This Email Id Already Registered!";
	}
	
	public String addPackage() {
		return "This Product Already Added";
	}
	
	public String addhotel() {
		return "This hotel Already Added";
	}
}
