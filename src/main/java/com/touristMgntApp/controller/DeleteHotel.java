package com.touristMgntApp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.touristMgntApp.daoImpl.HotelTableDaoImplement;

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
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Successfully Deleted !');");
			out.println("location='showAllHotel';");
			out.println("</script>");

		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('can not be Deleted !');");
			out.println("location='showAllHotel';");
			out.println("</script>");
		

		}
		} catch (IOException | NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}

}
