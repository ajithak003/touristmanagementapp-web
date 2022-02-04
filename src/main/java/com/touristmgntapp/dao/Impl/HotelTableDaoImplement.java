package com.touristmgntapp.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.touristmgntapp.dao.HotelDaoInterface;
import com.touristmgntapp.model.HotelClass;
import com.touristmgntapp.util.ConnectionUtil;

public class HotelTableDaoImplement implements HotelDaoInterface {

	static String commit = "commit";
	static String active = "active";

	@Override
	public boolean insertHotel(HotelClass hotel) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int pstmtvalue = 0;

		String insert = "insert into hotel_details (location, hotel_name, room_type_mid_range_price, room_type_premium_price,image) values(?,?,?,?,?)";

		try {
			con = ConnectionUtil.getDBConnect();

			pstmt = con.prepareStatement(insert);

			pstmt.setString(1, hotel.getLocation());
			pstmt.setString(2, hotel.getHotelName());
			pstmt.setDouble(3, hotel.getMidRangePrice());
			pstmt.setDouble(4, hotel.getPremiumPrice());
			pstmt.setString(5, hotel.getImage());

			pstmtvalue = pstmt.executeUpdate();

			pstmt.executeQuery(commit);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(pstmt, con);
		}
		return pstmtvalue > 0;

	}

	@Override
	public boolean updateHotel(HotelClass hotel) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int pstmtvalue = 0;
		String update = "update hotel_details set location=?,hotel_name=?,room_type_mid_range_price=?,room_type_premium_price=?,status=?, image=? where hotel_id=?";

		try {
			con = ConnectionUtil.getDBConnect();

			pstmt = con.prepareStatement(update);

			pstmt.setString(1, hotel.getLocation());
			pstmt.setString(2, hotel.getHotelName());
			pstmt.setDouble(3, hotel.getMidRangePrice());
			pstmt.setDouble(4, hotel.getPremiumPrice());
			pstmt.setString(5, hotel.getStatus());
			pstmt.setString(6, hotel.getImage());
			pstmt.setInt(7, hotel.getHotelId());
			pstmtvalue = pstmt.executeUpdate();

			pstmt.executeQuery(commit);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(pstmt, con);
		}
		return pstmtvalue > 0;
	}

	@Override
	public boolean deleteHotel(int hotelId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int del = 0;
		String query = "update hotel_details set status=? where hotel_id=?";

		try {

			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "inactive");
			pstmt.setInt(2, hotelId);

			del = pstmt.executeUpdate();
			pstmt.executeUpdate(commit);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(pstmt, con);
		}
		return del > 0;
	}

	@Override
	public List<HotelClass> getAllHotel() {
		List<HotelClass> hotelDetails = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select hotel_id, location, hotel_name, room_type_mid_range_price, room_type_premium_price,status,image from hotel_details order by hotel_id desc";
		
		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);

			 rs = pstmt.executeQuery();

			while (rs.next()) {

				HotelClass hotel = new HotelClass(rs.getInt("hotel_id"), rs.getString("location"),
						rs.getString("hotel_name"), rs.getDouble("room_type_mid_range_price"),
						rs.getDouble("room_type_premium_price"),rs.getString("status"), rs.getString("image"));
				hotelDetails.add(hotel);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(pstmt, con, rs);
		}

		return hotelDetails;
	}

	@Override
	public List<HotelClass> getHotelByNo(String location) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		HotelClass hotel = null;

		List<HotelClass> hotels = new ArrayList<>();

		String query = "select hotel_id, location, hotel_name, room_type_mid_range_price, room_type_premium_price,status, image from hotel_details "
				+ "where location=? order by status desc";

		try {
			con = ConnectionUtil.getDBConnect();

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, location);

			 rs = pstmt.executeQuery();

			while (rs.next()) {
				hotel = new HotelClass(rs.getInt("hotel_id"), rs.getString("location"), rs.getString("hotel_name"),
						rs.getDouble("room_type_mid_range_price"), rs.getDouble("room_type_premium_price"),rs.getString("status"),
						rs.getString("image"));
				hotels.add(hotel);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(pstmt, con, rs);
		}

		return hotels;

	}

	@Override
	public HotelClass getSingleHotel(int hotelId) {
		String query = "select hotel_id, location, hotel_name, room_type_mid_range_price, room_type_premium_price,status, image"
				+ " from hotel_details where hotel_id=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		HotelClass hotel = null;
		ResultSet rs= null;

		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, hotelId);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				hotel = new HotelClass(rs.getInt("hotel_id"), rs.getString("location"), rs.getString("hotel_name"),
						rs.getDouble("room_type_mid_range_price"), rs.getDouble("room_type_premium_price"),rs.getString("status"),
						rs.getString("image"));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(pstmt, con, rs);
		}

		return hotel;
	}

}
