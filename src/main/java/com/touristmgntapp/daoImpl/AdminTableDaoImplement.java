package com.touristmgntapp.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.touristmgntapp.dao.AdminDaoInterface;
import com.touristmgntapp.models.AdminClass;
import com.touristmgntapp.models.UserClass;
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
				AdminClass=new AdminClass(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5));
				
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("adminStatement error");
		}finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
		}

		return AdminClass;
		
		
	}

	

	public UserClass getUserById(int userId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		UserClass userById=null;
		
			String query ="select user_id,name,email_id,mobile_no,password,wallet from user_details where user_id =?";
			System.out.println(query);

		try {
		 con = ConnectionUtil.getDBConnect();
		 pstmt = con.prepareStatement(query);
		 pstmt.setInt(1, userId);
		 
		 ResultSet rs = pstmt.executeQuery(query);
		
		 
		 if (rs.next()) {

			 userById=new UserClass(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getLong(6));
				
			}} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				ConnectionUtil.closePreparedStatement(pstmt, con);
			}
		 return userById;

	}

	

}
