package com.ajith.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajith.daoImplement.BookingTableDaoImplement;
import com.ajith.model.BookingClass;

@WebServlet("/showSingleBooking")
public class ShowSingleBooking extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		
		int bookingId = Integer.parseInt( request.getParameter("bookingid"));
		   BookingTableDaoImplement bookingDao = new BookingTableDaoImplement();
		   BookingClass booking = bookingDao.getSingleBookingById(bookingId); 	
		   
		   request.setAttribute("singlebookingdetails", booking);
		       
		        double hotelfare;
		        if(booking.getHotelRoomType().equalsIgnoreCase("premimum room")){
		        	hotelfare = booking.getHotel().getPremiumPrice();
		        }
		        else{
		        	hotelfare = booking.getHotel().getMidRangePrice();
		        }
		        
		        request.setAttribute("singlebookinghotelfare", hotelfare);
		      
		      double flightfare;
		       if(booking.getFlightClass().equalsIgnoreCase("economic class")){
		    	   flightfare = booking.getFlight().getEconomicClassFare();
		       }
		       else{
		    	   flightfare = booking.getFlight().getBusinessClassFare();
		       }
		       
		       request.setAttribute("singlebookingflightfare", flightfare);
		       
		       int noOfHotelRooms = (int) booking.getNoOfRoom();
		       request.setAttribute("singlebookingnoofhotelroom", noOfHotelRooms);
		       
		       RequestDispatcher rd = request.getRequestDispatcher("showSingleBooking.jsp");
		       try {
				rd.forward(request, response);
			} catch (ServletException | IOException | NumberFormatException e) {
				System.out.println(e.getMessage());
			}
	}

}
