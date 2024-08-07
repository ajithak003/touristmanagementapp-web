package com.touristmgntapp.controller;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.touristmgntapp.dao.Impl.BookingTableDaoImplement;
import com.touristmgntapp.dao.Impl.RatingDaoImplement;
import com.touristmgntapp.model.BookingClass;
import com.touristmgntapp.model.UserFeedbackClass;


@WebServlet("/ratings")
public class Rating extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		try{
			
			String rating = request.getParameter("rate");
						
			RatingDaoImplement ratingDao = new RatingDaoImplement();
			
			int bookingId = Integer.parseInt(request.getParameter("bookingId"));
			
			BookingTableDaoImplement bookingDao = new BookingTableDaoImplement();
			BookingClass booking = bookingDao.getSingleBookingById(bookingId);
			
			int ratings = Integer.parseInt(rating);
			
			String describrion = request.getParameter("describe");
			
			UserFeedbackClass userRating = new UserFeedbackClass(bookingId,booking.getUser().getId(),booking.getPackages().getPackageId(),booking.getUser().getName(),booking.getPackageName(),ratings,describrion);
			boolean rate  = ratingDao.insertFeedback(userRating);
			//PrintWriter out = response.getWriter();
			if(rate) {
				/*
				 * out.println("<script type=\"text/javascript\">");
				 * out.println("alert('Thanks For Your Rating');");
				 * out.println("location='userPage.jsp';"); out.println("</script>");
				 */
				response.sendRedirect("userPage.jsp?rated=Thanks For Your Rating");
			}
			else {
				/*
				 * out.println("<script type=\"text/javascript\">");
				 * out.println("alert('can not be rated ! please try again');");
				 * out.println("location='userPage.jsp';"); out.println("</script>");
				 */
				response.sendRedirect("userPage.jsp?errormsg=can not be rated ! please try again");
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
}
