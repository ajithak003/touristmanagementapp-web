package com.touristmgntapp.dao;

import java.sql.SQLException;

import com.touristmgntapp.model.AdminClass;

public interface AdminDaoInterface {
	

	
	public AdminClass validateAdmin(String emailId, String password ) throws ClassNotFoundException, SQLException;

}
