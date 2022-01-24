package com.ajith.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {
	
	public static Connection getDBConnect()
	{
Connection con=null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			con=DriverManager.getConnection(url,"system","oracle");
			}
		catch (ClassNotFoundException e) 
		{
			
			e.getMessage();
			System.out.println("Driver Jar doesn't there");
			
		} catch (SQLException e) {
			
			e.getMessage();
			System.out.println("url or uasername or password may wrong");
		}
		return con;
	}
	
	public static void closePreparedStatement(PreparedStatement pstmt, Connection con) {
		// Null Check - to avoid Null Pointer Exception
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeStatement(Statement stmt, Connection con) {
		// Null Check - to avoid Null Pointer Exception
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
