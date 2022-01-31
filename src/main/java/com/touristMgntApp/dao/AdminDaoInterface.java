package com.touristMgntApp.dao;

import java.sql.SQLException;

import com.touristMgntApp.models.AdminClass;

public interface AdminDaoInterface {
	

	
	public AdminClass validateAdmin(String emailId, String password ) throws ClassNotFoundException, SQLException;

}
