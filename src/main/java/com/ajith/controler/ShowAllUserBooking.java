package com.ajith.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajith.daoImplement.BookingTableDaoImplement;
import com.ajith.model.BookingClass;

@WebServlet("/showAllUserBooking")
public class ShowAllUserBooking extends HttpServlet{
	
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
