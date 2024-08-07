package com.touristmgntapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.touristmgntapp.dao.Impl.BookingTableDaoImplement;
import com.touristmgntapp.dao.Impl.UserTableDaoImplement;
import com.touristmgntapp.model.BookingClass;
import com.touristmgntapp.model.UserClass;

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
					int bookingId = bookDao.fetchMaxOfBookingId(user.getId());
					EmailContent emailContent = new EmailContent(); 
					String htmlContent = emailContent.getEmailContent(bookingId);
					EmailService email = new EmailService();
					email.sentEmail(user.getEmail(),htmlContent);
				}

			} else {
			        
			     UserClass newUser;
					
				 newUser = userDao.getSingleUserById(user.getId());

			    session.setAttribute("user", newUser);
			        	
				response.sendRedirect("wallet.jsp?infomsg=Insufficient balance !");
			}
			} catch (IOException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}

	}
}
