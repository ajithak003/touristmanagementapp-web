package com.ajith.daoImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.ajith.connection.ConnectionUtil;
import com.ajith.daoInterface.BookingDaoInterface;
import com.ajith.model.BookingClass;
import com.ajith.model.FlightClass;
import com.ajith.model.HotelClass;
import com.ajith.model.UserClass;

public class BookingTableDaoImplement implements BookingDaoInterface {

	@Override
	public boolean insertbooking(BookingClass booking, int end,int businessClassSeats,int economicClassSeats) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		int pstmtvalue = 0;

		String commit = "commit";
		String insert = "insert into booking_details (user_id, package_id, flight_no, hotel_id,number_of_person,start_date,end_date,total_price,flight_class,"
				+ "      hotel_room_type,days_in_night,package_name,no_of_room) values(?,?,?,?,?,?,?+?,?,?,?,?,?,?)";
		String flight = "update flights_details set business_class_seat_status=?,economic_class_seat_status=? where flight_no=?";
		try {
			con = ConnectionUtil.getDBConnect();
			
			pstmt = con.prepareStatement(insert);
			pstmt2 = con.prepareStatement(flight);
           
			pstmt.setInt(1,booking.getUserId() );
			pstmt.setInt(2,booking.getPackageIid());
			pstmt.setInt(3,booking.getFlightNo());
			pstmt.setInt(4, booking.getHotelId());
			pstmt.setInt(5, booking.getNoOfPerson());
			pstmt.setDate(6, java.sql.Date.valueOf(booking.getStartDate()));
			pstmt.setDate(7, java.sql.Date.valueOf(booking.getStartDate()));
			pstmt.setInt(8,end);
			pstmt.setDouble(9, booking.getTotalPrice());
			pstmt.setString(10, booking.getFlightClass());
			pstmt.setString(11, booking.getHotelRoomType());
			pstmt.setString(12, booking.getDaysPlan());
			pstmt.setString(13, booking.getPackageName());
			pstmt.setDouble(14, booking.getNoOfRoom());
			
			pstmt2.setInt(1, businessClassSeats);
			pstmt2.setInt(2, economicClassSeats);
			pstmt2.setInt(3, booking.getFlightNo());
			
			
//			System.out.println(insert);
			pstmtvalue = pstmt.executeUpdate();
			pstmt2.executeUpdate();
			
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
	public List<BookingClass> getAllbooking(UserClass user) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<BookingClass> bookingDetails = new ArrayList<BookingClass>();
		Connection con = null;
		
		String query = "select booking_id,user_id, package_id, flight_no, hotel_id,number_of_person,start_date,end_date,total_price,status,booking_date,"
+ "flight_class,hotel_room_type,days_in_night,package_name,payment_details,no_of_room from booking_details where user_id=? order by start_date desc";
	
		PreparedStatement pstmt = null;
		BookingClass booking = null;
		
		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, user.getId());
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			   
			 booking = new BookingClass(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6), rs.getDate(7).toLocalDate(),
					 rs.getDate(8).toLocalDate(),rs.getDouble(9),rs.getString(10),rs.getTimestamp(11).toLocalDateTime(),rs.getString(12),
					 rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getDouble(17));
			 bookingDetails.add(booking);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			ConnectionUtil.closeStatement(pstmt, con);
		}

		return bookingDetails;
	}

	@Override
	public BookingClass getbookingById(int user_id, LocalDate startDate) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		BookingClass booking=null;
		String query = "select booking_id,user_id, package_id, flight_no, hotel_id,number_of_person,start_date,end_date,total_price,status,booking_date,"
				+ "flight_class,hotel_room_type,days_in_night,package_name,payment_details,no_of_room from booking_details where to_char(start_date,'yyyy-mm-dd')=? and user_id=?";
		
		try {
			
			con = ConnectionUtil.getDBConnect();
			
			 pstmt =con.prepareStatement(query);
			 pstmt.setDate(1, java.sql.Date.valueOf(startDate));
			 pstmt.setInt(2, user_id);
			
			 ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				 booking = new BookingClass(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6), rs.getDate(7).toLocalDate(),
						 rs.getDate(8).toLocalDate(),rs.getDouble(9),rs.getString(10),rs.getTimestamp(11).toLocalDateTime(),rs.getString(12),
						 rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getDouble(17));		
		
				
		}
		}	catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closeStatement(pstmt, con);
		}
		return booking;
	}

	@Override
	public boolean updatebooking(int user_id, LocalDate startDate,double refundPrice,int businessSeats,int economicSeats,int flightNo, int bookinId)
			 {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmtUser = null;
		PreparedStatement pstmtflight =null;
		int pstmtvalue = 0;
		
		String query =  "update booking_details set status=?, payment_details=? where user_id=? and start_date=? and booking_id=?";
		String wallet = "update user_details set wallet=? where user_id=?";
		String flight = "update flights_details set business_class_seat_status=?,economic_class_seat_status=? where flight_no=?";

		String commit = "commit";
		try {
		
		con = ConnectionUtil.getDBConnect();
		
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, "cancel");
		pstmt.setString(2, "payment refunded");
		pstmt.setInt(3, user_id );
		pstmt.setDate(4, java.sql.Date.valueOf(startDate));
		pstmt.setInt(5, bookinId);
		
		pstmtUser =con.prepareStatement(wallet);
		pstmtUser.setDouble(1, refundPrice);
		pstmtUser.setInt(2, user_id);
		
		pstmtflight = con.prepareStatement(flight);
		pstmtflight.setInt(1, businessSeats);
		pstmtflight.setInt(2, economicSeats);
		pstmtflight.setInt(3, flightNo);
		
		pstmtvalue = pstmt.executeUpdate();
		pstmt.executeUpdate(commit);
		
		pstmtUser.executeUpdate();
		 pstmtUser.executeUpdate(commit);
		 
		pstmtflight.executeUpdate();
		pstmtflight.executeUpdate(commit);
       
		}	catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
		}
		return pstmtvalue>0;
	}

	@Override
	public boolean deletebooking(int userId, LocalDate startDate) {
		
		Connection con = null;
		PreparedStatement pstmt =null;
		
		
		int del=0;
		String query = "delete booking_details where user_id=? and to_char(start_date,'yyyy-mm-dd')=?";
		String commit = "commit";
		
		try {
			
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userId);
			pstmt.setDate(2, java.sql.Date.valueOf(startDate));
			
            del = pstmt.executeUpdate();
            pstmt.executeUpdate(commit);
		
           
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
		}
		return del>0;

		
	}


	public List<BookingClass> getAllUserBooking() {
		// TODO Auto-generated method stub
		List<BookingClass> bookingDetails = new ArrayList<BookingClass>();
		Connection con = null;
		
		String query = "select booking_id,user_id, package_id, flight_no, hotel_id,number_of_person,start_date,end_date,total_price,status,"
				+ "booking_date,flight_class,hotel_room_type,days_in_night,package_name,payment_details,no_of_room from booking_details";
	
		Statement stmt = null;
		BookingClass booking = null;
		
		try {
			con = ConnectionUtil.getDBConnect();
			stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		
		while (rs.next()) {
			   
			 booking = new BookingClass(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6), rs.getDate(7).toLocalDate(),
					 rs.getDate(8).toLocalDate(),rs.getDouble(9),rs.getString(10),rs.getTimestamp(11).toLocalDateTime(),rs.getString(12),
					 rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getDouble(17));
			 bookingDetails.add(booking);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			ConnectionUtil.closeStatement(stmt, con);
		}

		return bookingDetails;
	}
	
	public boolean dateChange(BookingClass booking ,double wallet,int end,int newFlightBusinessSeat, int newFlightEconomicSeat,int oldFlightBusinessSeat,int oldFlightEconomicSeat,int newFlightNo, int bookingId, double totalPrice) {
		
		System.out.println(wallet);
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmtUser = null;
		PreparedStatement pstmtoldflight = null;
		PreparedStatement pstmtnewflight = null;
		
		int pstmtvalue = 0;
		String query = "update booking_details set flight_no=?,start_date=?,end_date=?+?,total_price=? where booking_id=?";
		String updateWallet = "update user_details set wallet=? where user_id=?";
		String newFlight = "update flights_details set business_class_seat_status  =?, economic_class_seat_status=? where flight_no  =?";
		String oldFlight = "update flights_details set business_class_seat_status  =?, economic_class_seat_status=? where flight_no  =?";
		String commit = "commit";
		//System.out.println(query);
		//System.out.println(updateWallet); 
		//System.out.println(newFlight);
		//System.out.println(oldFlight);
		try {
		
		con = ConnectionUtil.getDBConnect();
		pstmt = con.prepareStatement(query);	
		//System.out.println(newFlightNo);
		pstmt.setInt(1, newFlightNo);
		//System.out.println(booking.getStartDate());
		pstmt.setDate(2, java.sql.Date.valueOf(booking.getStartDate()));
		//System.out.println(booking.getStartDate());
		pstmt.setDate(3, java.sql.Date.valueOf(booking.getStartDate()));
		//System.out.println(end);
		pstmt.setInt(4,end);
		//System.out.println( bookingId);
		pstmt.setDouble(5, totalPrice);
		//System.out.println(totalPrice);
		pstmt.setInt(6, bookingId);
		
		pstmtUser =con.prepareStatement(updateWallet);
		pstmtUser.setDouble(1, wallet);
		pstmtUser.setInt(2, booking.getUserId());
		
		pstmtnewflight = con.prepareStatement(newFlight);
		pstmtnewflight.setInt(1, newFlightBusinessSeat);
		pstmtnewflight.setInt(2, newFlightEconomicSeat);
		pstmtnewflight.setInt(3, newFlightNo);
		
		pstmtoldflight = con.prepareStatement(oldFlight);
		pstmtoldflight.setInt(1, oldFlightBusinessSeat);
		pstmtoldflight.setInt(2, oldFlightEconomicSeat);
		pstmtoldflight.setInt(3, booking.getUserId());
		
		
		
		pstmtvalue = pstmt.executeUpdate();
		 pstmt.executeUpdate(commit);
		 
		pstmtUser.executeUpdate();
		pstmtUser.executeUpdate(commit);
		
		pstmtoldflight.executeUpdate();
		pstmtoldflight.executeUpdate(commit);
		
		pstmtnewflight.executeUpdate();
		pstmtnewflight.executeUpdate(commit);
		
        //
		}	catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
		}
		return pstmtvalue>0;
		
	}
	
	public BookingClass getSingleBookingById(int bookingId) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		BookingClass booking=null;
		String query = "select booking_id,user_id, package_id, flight_no, hotel_id,number_of_person,start_date,end_date,total_price,status,"
				+ "booking_date,flight_class,hotel_room_type,days_in_night,package_name,payment_details,no_of_room from booking_details where booking_id=?";
		
		try {
			
			con = ConnectionUtil.getDBConnect();
			
			 pstmt =con.prepareStatement(query);
		     pstmt.setInt(1, bookingId);
			 
			 ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				 booking = new BookingClass(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6), rs.getDate(7).toLocalDate(),rs.getDate(8).toLocalDate(),
						 rs.getDouble(9),rs.getString(10),rs.getTimestamp(11).toLocalDateTime(),rs.getString(12),rs.getString(13),
						 rs.getString(14),rs.getString(15),rs.getString(16),rs.getDouble(17));		
		
				
		}
		}	catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closeStatement(pstmt, con);
		}
		return booking;
	}

	public boolean endDateCheck(BookingClass booking) {
		Connection con = null;
	    PreparedStatement pstmt =null;		
        String query = "select booking_id from booking_details where booking_id=? and SYSDATE>?";
        			
		boolean flag = false;
		
				
		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, booking.getBookingId());
			pstmt.setDate(2, java.sql.Date.valueOf(booking.getStartDate()));

		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			
			 flag =true;
			
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);;
		}
		
		
		return flag;
	}

	
}
