package com.touristmgntapp.daoImpl;

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

	static  String commit = "commit";
	static  String active ="active";
	@Override
	public boolean insertHotel(HotelClass hotel) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int pstmtvalue = 0;

		
		String insert = "insert into hotel_details (location, hotel_name, room_type_mid_range_price, room_type_premium_price,image) values(?,?,?,?,?)";
		
		try {
			con = ConnectionUtil.getDBConnect();
			
			pstmt = con.prepareStatement(insert);
           
			pstmt.setString(1,hotel.getLocation() );
			pstmt.setString(2,hotel.getHotelName());
			pstmt.setDouble(3,hotel.getMidRangePrice());
			pstmt.setDouble(4, hotel.getPremiumPrice());
			pstmt.setString(5, hotel.getImage());
			
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
	public boolean updateHotel(HotelClass hotel)
		 {
		Connection con = null;
		PreparedStatement pstmt = null;
		int pstmtvalue = 0;
		String update = "update hotel_details set location=?,hotel_name=?,room_type_mid_range_price=?,room_type_premium_price=?, image=? where hotel_id=?";
		
		try {
			con = ConnectionUtil.getDBConnect();
			
			pstmt = con.prepareStatement(update);
           
			pstmt.setString(1,hotel.getLocation() );
			pstmt.setString(2,hotel.getHotelName());
			pstmt.setDouble(3,hotel.getMidRangePrice());
			pstmt.setDouble(4, hotel.getPremiumPrice());
			pstmt.setString(5, hotel.getImage());
			pstmt.setInt(6, hotel.getHotelId());
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
	public boolean deleteHotel(int hotelId)  {
		Connection con = null;
		PreparedStatement pstmt =null;
		int del=0;
		String query = "update hotel_details set status=? where hotel_id=?";
		
		try {
			
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
           
            pstmt.setString(1, "inactive");
            pstmt.setInt(2,hotelId);
			
            del = pstmt.executeUpdate();
            pstmt.executeUpdate(commit);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
		}
		return del>0;
	}
	
	@Override
	public List<HotelClass> getAllHotel()  {
		List<HotelClass> hotelDetails = new ArrayList<>();
		Connection con = null;
		String query = "select hotel_id, location, hotel_name, room_type_mid_range_price, room_type_premium_price, image from hotel_details where status=?";
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, active);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			   
			HotelClass hotel = new HotelClass(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getString(6));
			hotelDetails.add(hotel);
		}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			ConnectionUtil.closeStatement(pstmt, con);
		}

		return hotelDetails;
	}
	
	@Override
	public List<HotelClass> getHotelByNo(String location) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		HotelClass hotel= null;
		
		List<HotelClass> hotels = new ArrayList<HotelClass>();

		String query = "select hotel_id, location, hotel_name, room_type_mid_range_price, room_type_premium_price, image from hotel_details "
				+ "where location=? and status=?";
		
		try {
			con = ConnectionUtil.getDBConnect();
			
			 pstmt =con.prepareStatement(query);
			 pstmt.setString(1, location);
			 pstmt.setString(2, active);
			
			 ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				hotel = new HotelClass(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getString(6));
				hotels.add(hotel);
				
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closeStatement(pstmt, con);
		}
		
		return hotels;
		
	}


	
	@Override
	public HotelClass getSingleHotel(int hotelId)  {
		String query = "select hotel_id, location, hotel_name, room_type_mid_range_price, room_type_premium_price, image"
				+ " from hotel_details where hotel_id=? and status=?";
		Connection con = null;
		PreparedStatement pstmt = null; 
		HotelClass hotel = null;
		
		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, hotelId);
			pstmt.setString(2, active);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			   
			 hotel = new HotelClass(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getString(6));
			
		}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			ConnectionUtil.closeStatement(pstmt, con);
		}

		return hotel;
	}
	

}
