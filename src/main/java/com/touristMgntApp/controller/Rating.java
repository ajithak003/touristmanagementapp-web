package com.touristMgntApp.controller;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.touristMgntApp.daoImpl.BookingTableDaoImplement;
import com.touristMgntApp.daoImpl.RatingDaoImplement;
import com.touristMgntApp.models.BookingClass;
import com.touristMgntApp.models.UserFeedbackClass;


@WebServlet("/ratings")
public class Rating extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		try{
						
			RatingDaoImplement ratingDao = new RatingDaoImplement();
			
			int bookingId = Integer.parseInt(request.getParameter("bookingId"));
			
			BookingTableDaoImplement bookingDao = new BookingTableDaoImplement();
			BookingClass booking = bookingDao.getSingleBookingById(bookingId);
			
			float rating = Float.parseFloat(request.getParameter("rate"));
			
			String describrion = request.getParameter("describe");
			
			UserFeedbackClass userRating = new UserFeedbackClass(bookingId,booking.getUser().getId(),booking.getPackages().getPackageId(),booking.getUser().getName(),booking.getPackageName(),rating,describrion);
			boolean rate  = ratingDao.insertFeedback(userRating);
			PrintWriter out = response.getWriter();
			if(rate) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Thanks For Your Rating');");
				out.println("location='UserPage.jsp';");
				out.println("</script>");
			}
			else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('can not be rated ! please try again');");
				out.println("location='UserPage.jsp';");
				out.println("</script>");
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
}
