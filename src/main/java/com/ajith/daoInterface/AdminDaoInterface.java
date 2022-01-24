package com.ajith.daoInterface;

import java.sql.SQLException;
import java.util.List;

import com.ajith.model.AdminClass;

public interface AdminDaoInterface {
	

	
	public AdminClass validateAdmin(String emailId, String password ) throws ClassNotFoundException, SQLException;

}
