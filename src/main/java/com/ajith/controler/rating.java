package com.ajith.controler;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajith.daoImplement.BookingTableDaoImplement;
import com.ajith.daoImplement.RatingDaoImplement;
import com.ajith.model.BookingClass;
import com.ajith.model.UserClass;
import com.ajith.model.UserFeedbackClass;


@WebServlet("/rating")
public class rating extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		
		try{
			
			HttpSession session = req.getSession();
			UserClass user = (UserClass) session.getAttribute("user");
			//System.out.println(user);
			RatingDaoImplement ratingDao = new RatingDaoImplement();
			
			int bookingId = Integer.parseInt(req.getParameter("bookingId"));
			//System.out.println(bookingId);
			
			BookingTableDaoImplement bookingDao = new BookingTableDaoImplement();
			BookingClass booking = bookingDao.getSingleBookingById(bookingId);
			
			float rating = Float.parseFloat(req.getParameter("rate"));
			//System.out.println(rating);
			
			String describrion = req.getParameter("describe");
			
			UserFeedbackClass userRating = new UserFeedbackClass(bookingId,user.getId(),booking.getPackages().getPackageId(),user.getName(),booking.getPackageName(),rating,describrion);
			boolean rate  = ratingDao.insertFeedback(userRating);
			PrintWriter out = res.getWriter();
			if(rate==true) {
				//System.out.println("successfully rated");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Thanks For Your Rating');");
				out.println("location='UserPage.jsp';");
				out.println("</script>");
			}
			else {
				//System.out.println("invalid");
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
