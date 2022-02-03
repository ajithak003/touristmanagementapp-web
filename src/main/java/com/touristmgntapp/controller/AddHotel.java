package com.touristmgntapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.touristmgntapp.dao.Impl.HotelTableDaoImplement;
import com.touristmgntapp.exception.UserDefineException;
import com.touristmgntapp.model.HotelClass;


@WebServlet("/addhotel")
public class AddHotel extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		
		
		
		try {
			HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();
		
		String hotelname = request.getParameter("hotelname");
		
		String hotelLocation = request.getParameter("hotellocation");
		
	   double normalRoom = Double.parseDouble(request.getParameter("standardprice"));
		
		double premiumRoom = Double.parseDouble (request.getParameter("premiumprice"));
		
		String image = request.getParameter("hotelimage");
		
		
		HotelClass hotel = new HotelClass(hotelname.toLowerCase(),hotelLocation,normalRoom,premiumRoom,image);
		boolean hotels;
		
			hotels = hotelDao.insertHotel(hotel);
		
		
		if(hotels) {			

			response.sendRedirect("addHotel.jsp?infomsg=successfully added");

		}
		
		else {
			throw new UserDefineException();
		}
		} catch (UserDefineException | ClassNotFoundException | SQLException  e) {
			try {
				response.sendRedirect("addHotel.jsp?error="+((UserDefineException) e).addhotel());
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			}
		}
	
	}

}
