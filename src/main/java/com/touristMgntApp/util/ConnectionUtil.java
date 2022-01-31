package com.touristMgntApp.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.touristMgntApp.encrypt.EncryptPassword;

public class ConnectionUtil implements Serializable{
	
	public static Connection getDBConnect()
	{
Connection con=null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			con=DriverManager.getConnection(url,"system",EncryptPassword.decrypt());
			}
		catch (ClassNotFoundException e) 
		{
			
			e.getMessage();
			System.out.println("Driver Jar doesn't there");
			
		} catch (SQLException e) {
			
			e.getMessage();
			System.out.println("url or uasername or password may wrong");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closePreparedStatement(PreparedStatement pstmt, Connection con) {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void closeStatement(Statement stmt, Connection con) {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
