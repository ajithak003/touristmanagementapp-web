package com.touristmgntapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.touristmgntapp.daoImpl.HotelTableDaoImplement;
import com.touristmgntapp.model.BookingClass;
import com.touristmgntapp.model.HotelClass;

@WebServlet("/booking")
public class Booking extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		try {
		HttpSession session = request.getSession();

		BookingClass booking = (BookingClass) session.getAttribute("bookingsflight");

		String hotelId = request.getParameter("hotelid");

		double no = booking.getNoOfPerson();
		double noOfRoom = Math.ceil(no / 4);
		double hotelPrices = Double.parseDouble(request.getParameter("hotelprice"));
		request.setAttribute("hotelprice", hotelPrices);

		double hotelonePrice = hotelPrices * noOfRoom;
		int days = Integer.parseInt(booking.getDaysPlan().substring(0, 1));

		double hotelPrice = hotelonePrice * days;
		double totalPrice = booking.getTotalPrice() + hotelPrice;

		HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();
		HotelClass hotel = hotelDao.getSingleHotel(Integer.parseInt(hotelId));

		String room = null;
		if (hotelPrices == hotel.getPremiumPrice()) {
			room = "premimum room";
		} else {
			room = "Standard Room";
		}

		double flightFare = (Double) session.getAttribute("flightfare");
		request.setAttribute("flightfare", flightFare);

		int noOfHotelRooms = (int) noOfRoom;
		request.setAttribute("noofroom", noOfHotelRooms);

		BookingClass bookings = new BookingClass(booking.getUser(), booking.getPackages(), booking.getFlight(), hotel,
				booking.getNoOfPerson(), booking.getStartDate(), totalPrice, booking.getFlightClass(), room,
				booking.getDaysPlan(), booking.getPackageName(), noOfHotelRooms);

		session.setAttribute("confirmbooking", bookings);

		RequestDispatcher rd = request.getRequestDispatcher("booking.jsp");
	
			rd.forward(request, response);
		} catch (ServletException | IOException | NumberFormatException e) {
			System.out.println(e.getMessage());
		}

	}

}
