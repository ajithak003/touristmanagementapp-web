package com.touristmgntapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.touristmgntapp.dao.Impl.FlightTableDaoImplement;
import com.touristmgntapp.exception.UserDefineException;
import com.touristmgntapp.model.FlightClass;

@WebServlet("/addflight")
public class AddFlight extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)  {
		
		
		try {
			
					
		String flightName = request.getParameter("flightname");
		
		String depature = request.getParameter("Depature");
		
		String destination = request.getParameter("destination");
		
		String depatureDate = request.getParameter("DepatureDate");
		LocalDateTime depatureTimeDate = LocalDateTime.parse(depatureDate);
		
		String arrivalDate = request.getParameter("ArrivalDate");
		LocalDateTime arrivalTimeDate = LocalDateTime.parse(arrivalDate);
		
		double businessClassFare = Double.parseDouble(request.getParameter("businessclassfare"));
		
		double economicClassFare = Double.parseDouble(request.getParameter("economicclassfare"));
		
		String status = request.getParameter("status");
		
		int businessClassSeat = Integer.parseInt(request.getParameter("businessclassseat"));
		
		int economicClassSeat = Integer.parseInt(request.getParameter("economicclassseat"));
		
		FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
		FlightClass flight = new FlightClass(flightName,depature.toLowerCase(), destination.toLowerCase(), depatureTimeDate, arrivalTimeDate,
				businessClassFare, economicClassFare,status,businessClassSeat,economicClassSeat);
		
		boolean flights = flightDao.insertFlight(flight);
				
		if(flights) {
			
			response.sendRedirect("addFlight.jsp?infomsg=successfully added");
			
		}
		else {
			response.sendRedirect("addFlight.jsp?error=can not be added! please try again");
		}
		}catch(IOException | NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
