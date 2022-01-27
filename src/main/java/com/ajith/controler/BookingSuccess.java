package com.ajith.controler;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajith.daoImplement.BookingTableDaoImplement;
import com.ajith.daoImplement.UserTableDaoImplement;
import com.ajith.model.BookingClass;
import com.ajith.model.UserClass;

@WebServlet("/bookingsus")
public class BookingSuccess extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		try {
			UserClass users = (UserClass) session.getAttribute("user");
			UserTableDaoImplement userDao = new UserTableDaoImplement();
			UserClass user = userDao.getUserById(users);

			BookingClass booking = (BookingClass) session.getAttribute("confirmbooking");
			/* FlightClass flight = (FlightClass) session.getAttribute("singleflight"); */

			int days = Integer.parseInt(booking.getDaysPlan().substring(0, 1));

			if (user.getWallet() >= booking.getTotalPrice()) {
				BookingTableDaoImplement bookDao = new BookingTableDaoImplement();
				
				BookingClass confirmBooking = new BookingClass(user, booking.getPackages(), booking.getFlight(),
						booking.getHotel(), booking.getNoOfPerson(), booking.getStartDate(), booking.getTotalPrice(),
						booking.getFlightClass(), booking.getHotelRoomType(), booking.getDaysPlan(),
						booking.getPackageName(), booking.getNoOfRoom());
				
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