package com.touristmgntapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.touristmgntapp.dao.Impl.HotelTableDaoImplement;
import com.touristmgntapp.model.HotelClass;

@WebServlet("/deleteHotel")
public class DeleteHotel extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
		int hotelId = Integer.parseInt(request.getParameter("hotelid"));
		HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();

		boolean hotel = hotelDao.deleteHotel(hotelId);
		
			PrintWriter out = response.getWriter();
		

		if (hotel) {
            List<HotelClass> hotelsList = hotelDao.getAllHotel();
			
			request.setAttribute("showalladminhotel", hotelsList);
			
			RequestDispatcher rd = request.getRequestDispatcher("showAllHotel.jsp?deletehote=successfully deleted");
			rd.forward(request, response);
			

		} else {
			response.sendRedirect("showAllHotel.jsp?deleteerror=cannot be deleted");

		}
		} catch (IOException | NumberFormatException | ServletException e) {
			System.out.println(e.getMessage());
		}
	}

}
