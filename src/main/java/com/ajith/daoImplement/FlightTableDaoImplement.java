package com.ajith.daoImplement;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ajith.connection.ConnectionUtil;
import com.ajith.daoInterface.FlightDaoInterface;
import com.ajith.model.FlightClass;

public class FlightTableDaoImplement implements FlightDaoInterface {

	static String commit = "commit";

	@Override
	public boolean insertFlight(FlightClass flight) {

		Connection con = null;
		PreparedStatement pstmt = null;
		int pstmtvalue = 0;

		String insert = "insert into flights_details (flight_name,depature,destination,depature_date_time,arrival_date_time,business_class_fare,economic_class_fare,status,business_class_seat_status,economic_class_seat_status)"
				+ " values(?,?,?,?,?,?,?,?,?,?)";

		try {
			con = ConnectionUtil.getDBConnect();

			pstmt = con.prepareStatement(insert);

			pstmt.setString(1, flight.getFlightName());
			pstmt.setString(2, flight.getDepature());
			pstmt.setString(3, flight.getDestination());
			Timestamp depatureDateTime = Timestamp.valueOf(flight.getDepatureDateTime());
			pstmt.setTimestamp(4, depatureDateTime);
			Timestamp arrivalDateTime = Timestamp.valueOf(flight.getArrivalDateTime());
			pstmt.setTimestamp(5, arrivalDateTime);
			pstmt.setDouble(6, flight.getBusinessClassFare());
			pstmt.setDouble(7, flight.getEconomicClassFare());
			pstmt.setString(8, flight.getStatus());
			pstmt.setInt(9, flight.getBusinessClassSeat());
			pstmt.setInt(10, flight.getEconomicClassSeat());

			pstmtvalue = pstmt.executeUpdate();

			pstmt.executeQuery(commit);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
		}
		return pstmtvalue > 0;

	}

	@Override
	public boolean updateFlight(FlightClass flight) throws ClassNotFoundException, SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		int pstmtvalue = 0;

		String insert = "update flights_details set flight_name=?,depature=?,destination=?,depature_date_time=?,arrival_date_time=?,business_class_fare=?,economic_class_fare=?,status=?,business_class_seat_status=?,economic_class_seat_status=?"
				+ " where flight_no=?";

		try {
			con = ConnectionUtil.getDBConnect();

			pstmt = con.prepareStatement(insert);

			pstmt.setString(1, flight.getFlightName());
			pstmt.setString(2, flight.getDepature());
			pstmt.setString(3, flight.getDestination());
			Timestamp depatureDateTime = Timestamp.valueOf(flight.getDepatureDateTime());
			pstmt.setTimestamp(4, depatureDateTime);
			Timestamp arrivalDateTime = Timestamp.valueOf(flight.getArrivalDateTime());
			pstmt.setTimestamp(5, arrivalDateTime);
			pstmt.setDouble(6, flight.getBusinessClassFare());
			pstmt.setDouble(7, flight.getEconomicClassFare());
			pstmt.setString(8, flight.getStatus());
			pstmt.setInt(9, flight.getBusinessClassSeat());
			pstmt.setInt(10, flight.getEconomicClassSeat());
			pstmt.setInt(11, flight.getFlightNo());

			pstmtvalue = pstmt.executeUpdate();

			pstmt.executeQuery(commit);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
		}
		return pstmtvalue > 0;

	}

	@Override
	public boolean deleteFlight(int flightNo) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int del = 0;
		String query = "update flights_details set status =? where flight_no=?";

		try {

			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "inactive");
			pstmt.setInt(2, flightNo);

			del = pstmt.executeUpdate();
			pstmt.executeUpdate(commit);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
		}
		return del > 0;
	}

	@Override
	public List<FlightClass> getAllFlight() throws ClassNotFoundException, SQLException {

		List<FlightClass> flightDetails = new ArrayList<>();
		Connection con = null;
		String query = "select flight_no,flight_name,depature,destination,depature_date_time,arrival_date_time,business_class_fare,economic_class_fare,status,business_class_seat_status,economic_class_seat_status from flights_details where status=?";

		PreparedStatement pstmt = null;

		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "available");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				FlightClass flight = new FlightClass(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getTimestamp(5).toLocalDateTime(), rs.getTimestamp(6).toLocalDateTime(), rs.getDouble(7),
						rs.getDouble(8), rs.getString(9), rs.getInt(10), rs.getInt(11));
				flightDetails.add(flight);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closeStatement(pstmt, con);
		}

		return flightDetails;

	}

	@Override
	public List<FlightClass> getFlightByNo(String location, LocalDate startDate) {
		Connection con = null;
		PreparedStatement pstmt = null;

		FlightClass flight = null;

		List<FlightClass> flights = new ArrayList<FlightClass>();

		String query = "select flight_no,flight_name,depature,destination,depature_date_time,arrival_date_time,business_class_fare,economic_class_fare,"
				+ "status,business_class_seat_status,economic_class_seat_status from flights_details "
				+ "where destination=? and to_char(depature_date_time,'dd-mm-yyyy')=? and status=?";

		try {
			con = ConnectionUtil.getDBConnect();

			pstmt = con.prepareStatement(query);

			pstmt.setString(1, location);
			pstmt.setDate(2, java.sql.Date.valueOf(startDate));
			pstmt.setString(3, "available");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				flight = new FlightClass(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getTimestamp(5).toLocalDateTime(), rs.getTimestamp(6).toLocalDateTime(), rs.getDouble(7),
						rs.getDouble(8), rs.getString(9), rs.getInt(10), rs.getInt(11));
				flights.add(flight);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closeStatement(pstmt, con);
		}

		return flights;
	}

	@Override
	public FlightClass getSingleFlight(int flightNo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		FlightClass flight = null;

		String query = "select flight_no,flight_name,depature,destination,depature_date_time,arrival_date_time,business_class_fare,economic_class_fare,"
				+ " status,business_class_seat_status,economic_class_seat_status from flights_details where flight_no=?";

		try {
			con = ConnectionUtil.getDBConnect();

			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, flightNo);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				flight = new FlightClass(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getTimestamp(5).toLocalDateTime(), rs.getTimestamp(6).toLocalDateTime(), rs.getDouble(7),
						rs.getDouble(8), rs.getString(9), rs.getInt(10), rs.getInt(11));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closeStatement(pstmt, con);
		}

		return flight;

	}
}
