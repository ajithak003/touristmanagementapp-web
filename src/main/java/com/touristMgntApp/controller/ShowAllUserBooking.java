package com.touristMgntApp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.touristMgntApp.daoImpl.BookingTableDaoImplement;
import com.touristMgntApp.models.BookingClass;

@WebServlet("/showAllUserBooking")
public class ShowAllUserBooking extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		 BookingTableDaoImplement bookingDao = new BookingTableDaoImplement();
	       List<BookingClass> bookings = bookingDao.getAllUserBooking();
	       
	       request.setAttribute("showalluserbooking", bookings);
	       
	       RequestDispatcher rd = request.getRequestDispatcher("showAllUserBooking.jsp");
	       try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
		        System.out.println(e.getMessage());
		}
	       
		
	}

}
