package com.ajith.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajith.daoImplement.FlightTableDaoImplement;
import com.ajith.daoImplement.HotelTableDaoImplement;
import com.ajith.model.BookingClass;
import com.ajith.model.FlightClass;
import com.ajith.model.HotelClass;

@WebServlet("/hotels")
public class Hotel extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

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
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException | NumberFormatException e) {
			System.out.println(e.getMessage());
		} 

	}
}
