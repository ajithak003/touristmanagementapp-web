package com.ajith.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajith.daoImplement.HotelTableDaoImplement;
import com.ajith.model.HotelClass;

@WebServlet("/updateHotel")
public class PreUpdateHotel extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		int hotelId = Integer.parseInt(request.getParameter("hotelid"));
		HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();
		HotelClass hotel = hotelDao.getSingleHotel(hotelId);

		request.setAttribute("updatehotel", hotel);

		RequestDispatcher rd = request.getRequestDispatcher("updateHotel.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException | NumberFormatException e) {
			System.out.println(e.getMessage());
		}

	}

}
