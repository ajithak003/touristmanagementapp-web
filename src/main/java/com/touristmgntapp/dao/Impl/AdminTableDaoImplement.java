package com.touristmgntapp.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.touristmgntapp.dao.AdminDaoInterface;
import com.touristmgntapp.model.AdminClass;
import com.touristmgntapp.model.UserClass;
import com.touristmgntapp.util.ConnectionUtil;

public class AdminTableDaoImplement implements AdminDaoInterface {

	
	@Override
	public AdminClass validateAdmin(String emailId, String password)  {
		String validateQuery = "select admin_id,name,email_id,mobile_no,password from admin_details where email_id=? and password=?";
		Connection con = ConnectionUtil.getDBConnect();
		AdminClass AdminClass=null;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(validateQuery);
			pstmt.setString(1, emailId);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				AdminClass=new AdminClass(rs.getInt("admin_id"),rs.getString("name"),rs.getString("email_id"),rs.getLong("mobile_no"),rs.getString("password"));
				
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}finally {
			ConnectionUtil.close(pstmt, con);
		}

		return AdminClass;
		
		
	}


	

}
