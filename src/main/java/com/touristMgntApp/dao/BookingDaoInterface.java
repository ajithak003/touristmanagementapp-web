package com.touristMgntApp.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.touristMgntApp.models.BookingClass;
import com.touristMgntApp.models.UserClass;

public interface BookingDaoInterface {
	
	public boolean insertbooking(BookingClass booking, int end,int businessClassSeats,int economicClassSeats) throws ClassNotFoundException, SQLException;
    List<BookingClass> getAllbooking(UserClass user) throws ClassNotFoundException, SQLException;
	public BookingClass getbookingById( int user_id, LocalDate startDate) throws ClassNotFoundException, SQLException;
	public boolean updatebooking(int user_id, LocalDate startDate, double refundPrice,int businessSeats,int economicSeats,int flightNo,int bookingId) throws ClassNotFoundException, SQLException;
	public boolean deletebooking(int userId, LocalDate startDate) throws ClassNotFoundException, SQLException;
	public List<BookingClass> getAllUserBooking();
	public boolean dateChange(BookingClass booking ,double wallet,int end,int newFlightbSeat, int newFlighteSeat,int oldFlightbSeat,int oldFlighteSeat,int newFlightNo, int bookingId, double totalPrice);
	public BookingClass getSingleBookingById(int bookingId);
	public boolean endDateCheck(BookingClass booking);
}
