package com.ajith.daoImplement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.ajith.connection.ConnectionUtil;
import com.ajith.daoInterface.UserFeedbackDaoInterface;
import com.ajith.model.BookingClass;
import com.ajith.model.HotelClass;
import com.ajith.model.UserClass;
import com.ajith.model.UserFeedbackClass;

public class RatingDaoImplement implements UserFeedbackDaoInterface {

	@Override
	public boolean insertFeedback(UserFeedbackClass Feedback) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int pstmtvalue = 0;
		String commit = "commit";
		String query = "insert into users_feedback(user_id,booking_id,package_id,user_name,package_name,rating,describtion) values(?,?,?,?,?,?,?)";
		

		try {
			con = ConnectionUtil.getDBConnect();
			
			pstmt = con.prepareStatement(query);

//		String date1=dateFormatMDY.format(employees.getHire());
			pstmt.setInt(1, Feedback.getUserId());
			pstmt.setInt(2, Feedback.getBookingId());
			pstmt.setInt(3, Feedback.getPackageId());
			pstmt.setString(4, Feedback.getUserName());
			pstmt.setString(5, Feedback.getPackageName());
			pstmt.setFloat(6,Feedback.getRating() );
			pstmt.setString(7, Feedback.getDescribtion());
			
			
			//System.out.println(query);
			pstmtvalue = pstmt.executeUpdate();
			
			//System.out.println(user.getEmail());
			pstmt.executeQuery(commit);

			// System.out.println( stmt.executeUpdate()+" Row Instered");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
		}
		return pstmtvalue > 0;
		
	}

	@Override
	public List<UserFeedbackClass> getAllFeedback() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		UserFeedbackClass rating= null;
		
		List<UserFeedbackClass> ratings = new ArrayList<UserFeedbackClass>();

		String query = "select feedback_id,user_id,booking_id,package_id,user_name,package_name,rating,describtion from users_feedback";
		
		try {
			con = ConnectionUtil.getDBConnect();
			
			 pstmt =con.prepareStatement(query);
			
			
			 ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				rating = new UserFeedbackClass(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4), rs.getString(5), rs.getString(6),rs.getFloat(7), rs.getString(8));
				ratings.add(rating);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closeStatement(pstmt, con);
		}
		
		return ratings;
		
	}

	
	public boolean endDateCheck(BookingClass booking) {
		Connection con = null;
	    PreparedStatement pstmt =null;		
        String query = "select user_id from booking_details where booking_id=? and SYSDATE>=?";
        			
		boolean flag = false;
		
				
		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, booking.getBookingId());
			//pstmt.setDate(2, new java.sql.Date(Date.valueOf(booking.getEndDate()).getTime()));
			pstmt.setDate(2, java.sql.Date.valueOf(booking.getEndDate()));
			//System.out.println("nothing dfdj");
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			//System.out.println("nothing");
			int result = rs.getInt(1);
			 flag =true;
			
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);;
		}
		
		
		return flag;
	}
	
    
	public UserFeedbackClass getAllFeedbackratingS(String location) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		
		
		UserFeedbackClass rating = null;
		
		

		String query = "select package_name, avg(rating)as rating  from users_feedback where package_name='"+location+"' group by package_name";
		
		try {
			con = ConnectionUtil.getDBConnect();
			
			 stmt =con.createStatement();
			
			 ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				rating = new UserFeedbackClass(0,0,0,0,"", rs.getString(1),rs.getFloat(2),"");
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closeStatement(stmt, con);
		}
		return rating;
		
		
		
	}


}
