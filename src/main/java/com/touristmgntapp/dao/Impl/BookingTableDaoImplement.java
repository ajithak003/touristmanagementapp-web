package com.touristmgntapp.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.touristmgntapp.dao.BookingDaoInterface;
import com.touristmgntapp.model.BookingClass;
import com.touristmgntapp.model.FlightClass;
import com.touristmgntapp.model.HotelClass;
import com.touristmgntapp.model.PackageModeClass;
import com.touristmgntapp.model.UserClass;
import com.touristmgntapp.util.ConnectionUtil;

public class BookingTableDaoImplement implements BookingDaoInterface {

	static String commit = "commit";

	@Override
	public boolean insertbooking(BookingClass booking, int end, int businessClassSeats, int economicClassSeats) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		int pstmtvalue = 0;

		String insert = "insert into booking_details (user_id, package_id, flight_no, hotel_id,number_of_person,start_date,end_date,total_price,flight_class,"
				+ "      hotel_room_type,days_in_night,package_name,no_of_room) values(?,?,?,?,?,?,?+?,?,?,?,?,?,?)";
		String flight = "update flights_details set business_class_seat_status=?,economic_class_seat_status=? where flight_no=?";
		try {
			con = ConnectionUtil.getDBConnect();

			pstmt = con.prepareStatement(insert);
			pstmt2 = con.prepareStatement(flight);

			pstmt.setInt(1, booking.getUser().getId());
			pstmt.setInt(2, booking.getPackages().getPackageId());
			pstmt.setInt(3, booking.getFlight().getFlightNo());
			pstmt.setInt(4, booking.getHotel().getHotelId());
			pstmt.setInt(5, booking.getNoOfPerson());
			pstmt.setDate(6, java.sql.Date.valueOf(booking.getStartDate()));
			pstmt.setDate(7, java.sql.Date.valueOf(booking.getStartDate()));
			pstmt.setInt(8, end);
			pstmt.setDouble(9, booking.getTotalPrice());
			pstmt.setString(10, booking.getFlightClass());
			pstmt.setString(11, booking.getHotelRoomType());
			pstmt.setString(12, booking.getDaysPlan());
			pstmt.setString(13, booking.getPackageName());
			pstmt.setDouble(14, booking.getNoOfRoom());

			pstmt2.setInt(1, businessClassSeats);
			pstmt2.setInt(2, economicClassSeats);
			pstmt2.setInt(3, booking.getFlight().getFlightNo());

			pstmtvalue = pstmt.executeUpdate();
			pstmt2.executeUpdate();

			pstmt.executeQuery(commit);
			pstmt2.executeQuery(commit);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(pstmt, con);
			ConnectionUtil.close(pstmt2, con);

		}
		return pstmtvalue > 0;

	}

	@Override
	public List<BookingClass> getAllbooking(UserClass users) throws ClassNotFoundException, SQLException {
		List<BookingClass> bookingDetails = new ArrayList<>();
		RatingDaoImplement ratingDao = new RatingDaoImplement();

		Connection con = null;
		ResultSet rs = null;

		String query = "select b.booking_id,flight.depature,flight.destination,hotel.hotel_name,b.start_date,b.end_date,b.total_price,b.status,b.days_in_night,b.package_name,u.user_id,p.package_id,flight.flight_no,hotel.hotel_id "
				+ "from booking_details b inner join user_details u on b.user_id = u.user_id inner join package_modes p on b.package_id=p.package_id inner join "
				+ "flights_details flight on b.flight_no=flight.flight_no inner join hotel_details hotel on b.hotel_id=hotel.hotel_id where u.user_id=? order by b.start_date desc";

		PreparedStatement pstmt = null;
		BookingClass booking = null;

		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, users.getId());

			rs = pstmt.executeQuery();

			while (rs.next()) {

				UserClass user = new UserClass();
				PackageModeClass packages = new PackageModeClass(rs.getString(10), 0.0, "", "", "");
				FlightClass flight = new FlightClass("", rs.getString("depature"), rs.getString("destination"), null,
						null, 0.0, 0.0, "", 0, 0);
				HotelClass hotel = new HotelClass(rs.getString("hotel_name"), "", 0.0, 0.0, "");
				boolean cancel = endDateCheck(rs.getDate("start_date").toLocalDate(), rs.getInt("booking_id"));
				boolean rating = ratingDao.endDateCheck(rs.getDate("end_date").toLocalDate(), rs.getInt("booking_id"));

				booking = new BookingClass(rs.getInt("booking_id"), user, packages, flight, hotel, 0,
						rs.getDate("start_date").toLocalDate(), null, rs.getDouble("total_price"),
						rs.getString("status"), null, "", "", rs.getString("days_in_night"),
						rs.getString("package_name"), "", 0.0, cancel, rating);

				bookingDetails.add(booking);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pstmt, con, rs);
		}

		return bookingDetails;
	}

	@Override
	public BookingClass getbookingById(int userId, LocalDate startDate) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BookingClass booking = null;

		UserTableDaoImplement userDao = new UserTableDaoImplement();
		PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();
		FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
		HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();

		String query = "select booking_id,user_id, package_id, flight_no, hotel_id,number_of_person,start_date,end_date,total_price,status,booking_date,"
				+ "flight_class,hotel_room_type,days_in_night,package_name,payment_details,no_of_room from booking_details where to_char(start_date,'yyyy-mm-dd')=? and user_id=?";

		try {

			con = ConnectionUtil.getDBConnect();

			pstmt = con.prepareStatement(query);
			pstmt.setDate(1, java.sql.Date.valueOf(startDate));
			pstmt.setInt(2, userId);

			 rs = pstmt.executeQuery();

			if (rs.next()) {

				UserClass user = userDao.getSingleUserById(rs.getInt("user_id"));
				PackageModeClass packages = packageDao.getPackageByNo(rs.getString(15));
				FlightClass flight = flightDao.getSingleFlight(rs.getInt("flight_no"));
				HotelClass hotel = hotelDao.getSingleHotel(rs.getInt("hotel_id"));

				booking = new BookingClass(rs.getInt("booking_id"), user, packages, flight, hotel,
						rs.getInt("number_of_person"), rs.getDate("start_date").toLocalDate(),
						rs.getDate("end_date").toLocalDate(), rs.getDouble("total_price"), rs.getString("status"),
						rs.getTimestamp("booking_date").toLocalDateTime(), rs.getString("flight_class"),
						rs.getString("hotel_room_type"), rs.getString("days_in_night"), rs.getString("package_name"),
						rs.getString("payment_details"), rs.getDouble("no_of_room"));

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			ConnectionUtil.close(pstmt, con, rs);
		}
		return booking;
	}

	@Override
	public boolean updatebooking(int userId, LocalDate startDate, double refundPrice, int businessSeats,
			int economicSeats, int flightNo, int bookinId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmtUser = null;
		PreparedStatement pstmtflight = null;
		int pstmtvalue = 0;

		String query = "update booking_details set status=?, payment_details=? where user_id=? and start_date=? and booking_id=?";
		String wallet = "update user_details set wallet=? where user_id=?";
		String flight = "update flights_details set business_class_seat_status=?,economic_class_seat_status=? where flight_no=?";

		try {

			con = ConnectionUtil.getDBConnect();

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "canceled");
			pstmt.setString(2, "Payment Refunded");
			pstmt.setInt(3, userId);
			pstmt.setDate(4, java.sql.Date.valueOf(startDate));
			pstmt.setInt(5, bookinId);

			pstmtUser = con.prepareStatement(wallet);
			pstmtUser.setDouble(1, refundPrice);
			pstmtUser.setInt(2, userId);

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

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(pstmt, con);
			ConnectionUtil.close(pstmtflight, con);
			ConnectionUtil.close(pstmtUser, con);
		}
		return pstmtvalue > 0;
	}

	@Override
	public boolean deletebooking(int userId, LocalDate startDate) {

		Connection con = null;
		PreparedStatement pstmt = null;

		int del = 0;
		String query = "delete booking_details where user_id=? and to_char(start_date,'yyyy-mm-dd')=?";

		try {

			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userId);
			pstmt.setDate(2, java.sql.Date.valueOf(startDate));

			del = pstmt.executeUpdate();
			pstmt.executeUpdate(commit);

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(pstmt, con);
		}
		return del > 0;
	}

	public List<BookingClass> getAllUserBooking() {

		List<BookingClass> bookingDetails = new ArrayList<>();

		UserTableDaoImplement userDao = new UserTableDaoImplement();
		PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();
		FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
		HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();

		Connection con = null;
		String query = "select booking_id,user_id, package_id, flight_no, hotel_id,number_of_person,start_date,end_date,total_price,status,"
				+ "booking_date,flight_class,hotel_room_type,days_in_night,package_name,payment_details,no_of_room from booking_details order by start_date desc";

		Statement stmt = null;
		ResultSet rs =null;
		BookingClass booking = null;

		try {
			con = ConnectionUtil.getDBConnect();
			stmt = con.createStatement();

			rs = stmt.executeQuery(query);

			while (rs.next()) {

				UserClass user = userDao.getSingleUserById(rs.getInt("user_id"));
				PackageModeClass packages = packageDao.getPackageByNo(rs.getString("package_name"));
				FlightClass flight = flightDao.getSingleFlight(rs.getInt("flight_no"));
				HotelClass hotel = hotelDao.getSingleHotel(rs.getInt("hotel_id"));

				booking = new BookingClass(rs.getInt("booking_id"), user, packages, flight, hotel,
						rs.getInt("number_of_person"), rs.getDate("start_date").toLocalDate(),
						rs.getDate("end_date").toLocalDate(), rs.getDouble("total_price"), rs.getString("status"),
						rs.getTimestamp("booking_date").toLocalDateTime(), rs.getString("flight_class"),
						rs.getString("hotel_room_type"), rs.getString("days_in_night"), rs.getString("package_name"),
						rs.getString("payment_details"), rs.getDouble("no_of_room"));

				bookingDetails.add(booking);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closeStatement(stmt, con, rs);
		}

		return bookingDetails;
	}

	/**
	 * 
	 */

	public boolean dateChange(BookingClass booking, double wallet, int end, int newFlightBusinessSeat,
			int newFlightEconomicSeat, int oldFlightBusinessSeat, int oldFlightEconomicSeat, int newFlightNo,
			int bookingId, double totalPrice) {

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

		try {

			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, newFlightNo);
			pstmt.setDate(2, java.sql.Date.valueOf(booking.getStartDate()));
			pstmt.setDate(3, java.sql.Date.valueOf(booking.getStartDate()));
			pstmt.setInt(4, end);
			pstmt.setDouble(5, totalPrice);
			pstmt.setInt(6, bookingId);

			pstmtUser = con.prepareStatement(updateWallet);
			pstmtUser.setDouble(1, wallet);
			pstmtUser.setInt(2, booking.getUser().getId());

			pstmtnewflight = con.prepareStatement(newFlight);
			pstmtnewflight.setInt(1, newFlightBusinessSeat);
			pstmtnewflight.setInt(2, newFlightEconomicSeat);
			pstmtnewflight.setInt(3, newFlightNo);

			pstmtoldflight = con.prepareStatement(oldFlight);
			pstmtoldflight.setInt(1, oldFlightBusinessSeat);
			pstmtoldflight.setInt(2, oldFlightEconomicSeat);
			pstmtoldflight.setInt(3, booking.getUser().getId());

			pstmtvalue = pstmt.executeUpdate();
			pstmt.executeUpdate(commit);

			pstmtUser.executeUpdate();
			pstmtUser.executeUpdate(commit);

			pstmtoldflight.executeUpdate();
			pstmtoldflight.executeUpdate(commit);

			pstmtnewflight.executeUpdate();
			pstmtnewflight.executeUpdate(commit);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(pstmt, con);
			ConnectionUtil.close(pstmtUser, con);
			ConnectionUtil.close(pstmtoldflight, con);
			ConnectionUtil.close(pstmtnewflight, con);

		}
		return pstmtvalue > 0;

	}

	public BookingClass getSingleBookingById(int bookingId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BookingClass booking = null;

		UserTableDaoImplement userDao = new UserTableDaoImplement();
		PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();
		FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
		HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();

		String query = "select booking_id,user_id, package_id, flight_no, hotel_id,number_of_person,start_date,end_date,total_price,status,"
				+ "booking_date,flight_class,hotel_room_type,days_in_night,package_name,payment_details,no_of_room from booking_details where booking_id=?";
		try {

			con = ConnectionUtil.getDBConnect();

			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bookingId);

			 rs = pstmt.executeQuery();

			if (rs.next()) {

				UserClass user = userDao.getSingleUserById(rs.getInt("user_id"));
				PackageModeClass packages = packageDao.getPackageByNo(rs.getString("package_name"));
				FlightClass flight = flightDao.getSingleFlight(rs.getInt("flight_no"));
				HotelClass hotel = hotelDao.getSingleHotel(rs.getInt("hotel_id"));

				booking = new BookingClass(rs.getInt("booking_id"), user, packages, flight, hotel,
						rs.getInt("number_of_person"), rs.getDate("start_date").toLocalDate(),
						rs.getDate("end_date").toLocalDate(), rs.getDouble("total_price"), rs.getString("status"),
						rs.getTimestamp("booking_date").toLocalDateTime(), rs.getString("flight_class"),
						rs.getString("hotel_room_type"), rs.getString("days_in_night"), rs.getString("package_name"),
						rs.getString("payment_details"), rs.getDouble("no_of_room"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(pstmt, con, rs);
		}
		return booking;
	}
	
	public int fetchMaxOfBookingId(int userId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int maxOfBookingId = 0;
		String query = "select max(BOOKING_ID) as booking_id from booking_Details where user_id = ?";
		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				maxOfBookingId = rs.getInt("booking_id");
			}
			
		}catch (Exception e) {
		}
		return maxOfBookingId;
	}

	public boolean endDateCheck(LocalDate startDate, int bookingId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "select booking_id from booking_details where booking_id=? and SYSDATE>?";

		boolean flag = false;

		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bookingId);
			pstmt.setDate(2, java.sql.Date.valueOf(startDate));

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {

				flag = true;

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			ConnectionUtil.close(pstmt, con);
			;
		}

		return flag;
	}

}