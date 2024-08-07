package com.touristmgntapp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.touristmgntapp.dao.Impl.BookingTableDaoImplement;
import com.touristmgntapp.dao.Impl.FlightTableDaoImplement;
import com.touristmgntapp.dao.Impl.UserTableDaoImplement;
import com.touristmgntapp.model.BookingClass;
import com.touristmgntapp.model.FlightClass;
import com.touristmgntapp.model.UserClass;

@WebServlet("/confirmdatechange")
public class ConfirmDateChange extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();

		UserClass users = (UserClass) session.getAttribute("user");
		UserTableDaoImplement userDao = new UserTableDaoImplement();
		try {
			UserClass user = userDao.getUserById(users);

			BookingClass booking = (BookingClass) session.getAttribute("datechangebookings");
			int bookingId = (int) session.getAttribute("datechangebookingid");

			int oldFlightbSeat = (Integer) session.getAttribute("oldflightbseats");
			int oldFlighteSeat = (Integer) session.getAttribute("oldflighteseats");

			String flightNoStr = request.getParameter("flightno");
			int flightNo = Integer.parseInt(flightNoStr);
			double flightFare = Double.parseDouble(request.getParameter("price"));

			double oldtotalPrice = (Double) session.getAttribute("totalPrice");

			double totalPrice = flightFare * booking.getNoOfPerson() + oldtotalPrice;
			totalPrice = totalPrice + 1000;
			double totalPriceBalance = totalPrice - booking.getTotalPrice();

			FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
			FlightClass flight = flightDao.getSingleFlight(flightNo);
			int newFlightbSeat = flight.getBusinessClassSeat();
			int newFlighteSeat = flight.getEconomicClassSeat();
			if ("business class".equalsIgnoreCase(booking.getFlightClass())) {
				newFlightbSeat = flight.getBusinessClassSeat() - booking.getNoOfPerson();
			} else {
				newFlighteSeat = flight.getEconomicClassSeat() - booking.getNoOfPerson();
			}
			int days = Integer.parseInt(booking.getDaysPlan().substring(0, 1));
			BookingTableDaoImplement bookingDao = new BookingTableDaoImplement();

			if (totalPriceBalance > 0) {

				if (user.getWallet() >= totalPriceBalance) {
					double wallet = user.getWallet() - totalPriceBalance;

					boolean change = bookingDao.dateChange(booking, wallet, days, newFlightbSeat, newFlighteSeat,
							oldFlightbSeat, oldFlighteSeat, flight.getFlightNo(), bookingId, totalPrice);
					if (change) {
						response.sendRedirect("confirmdatechange.jsp");
					}

				} else {
					response.sendRedirect("wallet.jsp?errormsg=Insufficient balance");
				}
			}
			if (totalPriceBalance <= 0) {

				double wallet = user.getWallet() - totalPriceBalance;

				boolean change = bookingDao.dateChange(booking, wallet, days, newFlightbSeat, newFlighteSeat,
						oldFlightbSeat, oldFlighteSeat, flight.getFlightNo(), bookingId, totalPrice);
				if (change) {
					response.sendRedirect("confirmdatechange.jsp");
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
