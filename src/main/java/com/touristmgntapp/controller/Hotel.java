package com.touristmgntapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.touristmgntapp.dao.Impl.FlightTableDaoImplement;
import com.touristmgntapp.dao.Impl.HotelTableDaoImplement;
import com.touristmgntapp.model.BookingClass;
import com.touristmgntapp.model.FlightClass;
import com.touristmgntapp.model.HotelClass;

@WebServlet("/hotels")
public class Hotel extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
		HttpSession session = request.getSession();

		BookingClass booking = (BookingClass) session.getAttribute("bookings");

		String flightNoStr = request.getParameter("flightno");
		int flightNo = Integer.parseInt(flightNoStr);

		double flightFare = Double.parseDouble(request.getParameter("price"));

		session.setAttribute("flightfare", flightFare);

		FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
		FlightClass flight = flightDao.getSingleFlight(flightNo);

		String flightClass;
		if (flightFare == flight.getBusinessClassFare()) {
			flightClass = "business class";
		} else {
			flightClass = "economic class";
		}

		double totalPrice = (booking.getTotalPrice() + flightFare) * booking.getNoOfPerson();

		HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();
		List<HotelClass> hotels = hotelDao.getHotelByNo(booking.getPackageName());
		
		request.setAttribute("bookingallhotels", hotels);

		BookingClass bookings = new BookingClass(booking.getUser(), booking.getPackages(),flight, null,
				booking.getNoOfPerson(), booking.getStartDate(), totalPrice, flightClass, "", booking.getDaysPlan(),
				booking.getPackageName(), 0);
		
		session.setAttribute("bookingsflight", bookings);
		
		RequestDispatcher rd = request.getRequestDispatcher("hotels.jsp");
		
			rd.forward(request, response);
		} catch (ServletException | IOException | NumberFormatException e) {
			System.out.println(e.getMessage());
		} 

	}
}
