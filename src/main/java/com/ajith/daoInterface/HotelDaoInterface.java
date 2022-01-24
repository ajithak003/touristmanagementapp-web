package com.ajith.daoInterface;

import java.sql.SQLException;
import java.util.List;

import com.ajith.model.HotelClass;

public interface HotelDaoInterface {
	
	public boolean insertHotel(HotelClass hotel) throws ClassNotFoundException, SQLException;
    List<HotelClass> getAllHotel() throws ClassNotFoundException, SQLException;
	public List<HotelClass> getHotelByNo(String loction) throws ClassNotFoundException, SQLException;
	public boolean updateHotel(HotelClass hotel) throws ClassNotFoundException, SQLException;
	public boolean deleteHotel(int hotel_id) throws ClassNotFoundException, SQLException;
	public HotelClass getSingleHotel(int hotelId);

}