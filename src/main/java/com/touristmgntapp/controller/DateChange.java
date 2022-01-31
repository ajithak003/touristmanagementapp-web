package com.touristmgntapp.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.touristmgntapp.daoImpl.BookingTableDaoImplement;
import com.touristmgntapp.daoImpl.FlightTableDaoImplement;
import com.touristmgntapp.models.BookingClass;
import com.touristmgntapp.models.FlightClass;

@WebServlet("/dateChangeflight")
public class DateChange extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();

		int bookingId = (int) session.getAttribute("datechangebookingid");
		session.setAttribute("datechangebookingid", bookingId);
		BookingTableDaoImplement book = new BookingTableDaoImplement();

		BookingClass bookingpackage = book.getSingleBookingById(bookingId);

		String date = request.getParameter("changedate");
		LocalDate startDate = LocalDate.parse(date);

		double oldFlightPrice = 0.0;
		int bseats = bookingpackage.getFlight().getBusinessClassSeat();
		int eseats = bookingpackage.getFlight().getEconomicClassSeat();

		if (bookingpackage.getFlightClass().equalsIgnoreCase("business class")) {
			oldFlightPrice = bookingpackage.getFlight().getBusinessClassFare() * bookingpackage.getNoOfPerson();
			bseats = bookingpackage.getFlight().getBusinessClassSeat() + bookingpackage.getNoOfPerson();
		} else if (bookingpackage.getFlightClass().equalsIgnoreCase("economic class")) {
			oldFlightPrice = bookingpackage.getFlight().getEconomicClassFare() * bookingpackage.getNoOfPerson();
			eseats = bookingpackage.getFlight().getEconomicClassSeat() + bookingpackage.getNoOfPerson();
		}

		double totalPrice = bookingpackage.getTotalPrice() - oldFlightPrice;
		session.setAttribute("totalPrice", totalPrice);

		session.setAttribute("oldflightbseats", bseats);
		session.setAttribute("oldflighteseats", eseats);

		FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
		List<FlightClass> flights = flightDao.getFlightByNo(bookingpackage.getPackageName(), startDate);

		BookingClass bookings = new BookingClass(bookingpackage.getUser(), bookingpackage.getPackages(),
				bookingpackage.getFlight(), bookingpackage.getHotel(), bookingpackage.getNoOfPerson(), startDate,
				bookingpackage.getTotalPrice(), bookingpackage.getFlightClass(), bookingpackage.getHotelRoomType(),
				bookingpackage.getDaysPlan(), bookingpackage.getPackageName(), bookingpackage.getNoOfRoom());

		session.setAttribute("datechangebookings", bookings);
		
		request.setAttribute("datechangeflightlist", flights);
		
		RequestDispatcher rd = request.getRequestDispatcher("dateChangeflight.jsp");
		
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
