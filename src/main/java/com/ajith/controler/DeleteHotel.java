package com.ajith.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajith.daoImplement.HotelTableDaoImplement;

@WebServlet("/deleteHotel")
public class DeleteHotel extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		int hotelId = Integer.parseInt(request.getParameter("hotelid"));
		HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();

		boolean hotel = hotelDao.deleteHotel(hotelId);
		try {
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
