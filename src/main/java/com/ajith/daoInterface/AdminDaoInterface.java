package com.ajith.daoInterface;

import java.sql.SQLException;

import com.ajith.model.AdminClass;

public interface AdminDaoInterface {
	

	
	public AdminClass validateAdmin(String emailId, String password ) throws ClassNotFoundException, SQLException;

}
