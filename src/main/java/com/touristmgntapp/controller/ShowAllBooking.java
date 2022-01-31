package com.touristmgntapp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.touristmgntapp.daoImpl.BookingTableDaoImplement;
import com.touristmgntapp.models.BookingClass;
import com.touristmgntapp.models.UserClass;

@WebServlet("/showAllBooking")
public class ShowAllBooking extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		UserClass user = (UserClass) session.getAttribute("user");
		BookingTableDaoImplement bookingDao = new BookingTableDaoImplement();
		try {
			List<BookingClass> booking = bookingDao.getAllbooking(user);
			request.setAttribute("userallbooking", booking);
			
			RequestDispatcher rd = request.getRequestDispatcher("showAllBooking.jsp");
			rd.forward(request, response);
			
			
		} catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
			System.out.println(e.getMessage());
		}
	}

}