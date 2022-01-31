package com.touristMgntApp.controller;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.touristMgntApp.daoImpl.BookingTableDaoImplement;
import com.touristMgntApp.daoImpl.UserTableDaoImplement;
import com.touristMgntApp.models.BookingClass;
import com.touristMgntApp.models.UserClass;

@WebServlet("/bookingsus")
public class BookingSuccess extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		try {
			UserClass users = (UserClass) session.getAttribute("user");
			UserTableDaoImplement userDao = new UserTableDaoImplement();
			UserClass user = userDao.getUserById(users);

			BookingClass booking = (BookingClass) session.getAttribute("confirmbooking");

			int days = Integer.parseInt(booking.getDaysPlan().substring(0, 1));

			if (user.getWallet() >= booking.getTotalPrice()) {
				BookingTableDaoImplement bookDao = new BookingTableDaoImplement();
				
				int businessClassSeats = booking.getFlight().getBusinessClassSeat();
				int economicClassSeats = booking.getFlight().getEconomicClassSeat();
				if (booking.getFlightClass().equalsIgnoreCase("business class")) {
					businessClassSeats = booking.getFlight().getBusinessClassSeat() - booking.getNoOfPerson();
				} else {
					economicClassSeats = booking.getFlight().getEconomicClassSeat() - booking.getNoOfPerson();
				}

				boolean book = bookDao.insertbooking(booking, days, businessClassSeats, economicClassSeats);

				long wallet = userDao.showWalletAmount(user);
				wallet = (long) (wallet - booking.getTotalPrice());
				userDao.addWalletAmount(user.getId(), wallet);
				if (book) {
				  response.sendRedirect("bookingsus.jsp");
				}

			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Insufficient balance !');");
				out.println("location='wallet.jsp';");
				out.println("</script>");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
