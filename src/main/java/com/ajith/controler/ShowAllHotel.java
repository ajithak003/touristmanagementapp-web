package com.ajith.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajith.daoImplement.HotelTableDaoImplement;
import com.ajith.model.HotelClass;

@WebServlet("/showAllHotel")
public class ShowAllHotel extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			 HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();
		        List<HotelClass> hotels = hotelDao.getAllHotel();
		
		request.setAttribute("showalladminhotel", hotels);
		
		RequestDispatcher rd = request.getRequestDispatcher("showAllHotel.jsp");
	
			rd.forward(request, response);
		} catch (ServletException | IOException  e) {
			System.out.println(e.getMessage());
		}
	}


}
