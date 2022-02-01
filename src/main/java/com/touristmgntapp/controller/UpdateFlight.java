package com.touristmgntapp.controller;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.touristmgntapp.daoImpl.FlightTableDaoImplement;
import com.touristmgntapp.model.FlightClass;


@WebServlet(urlPatterns = "/updateflight")
public class UpdateFlight extends HttpServlet {
	
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
		
		int flightno = Integer.parseInt(request.getParameter("flightno"));
		
		FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
		FlightClass flight = new FlightClass(flightno,flightName,depature, destination, depatureTimeDate, arrivalTimeDate,
				businessClassFare, economicClassFare,status,businessClassSeat,economicClassSeat);
		 
		
		boolean flights = flightDao.updateFlight(flight);
		
		PrintWriter out = response.getWriter();
		int i=1;
		if(flights) {
			/*
			 * out.println("<script type=\"text/javascript\">");
			 * out.println("alert('Successfully Updated');");
			 * out.println("location='showAllFlight';"); out.println("</script>");
			 */
		
			
		       List<FlightClass> showFlights = flightDao.getAllFlight();

			request.setAttribute("showalladminflight", showFlights);
			System.out.println("enter");
			if(i==1) {
			request.setAttribute("updateflight","true");
			System.out.println(i);
			i++;
			}
			RequestDispatcher rd = request.getRequestDispatcher("showAllFlight.jsp");
			rd.forward(request, response);
			
			
			
		}
		else {
	
			out.println("<script type=\"text/javascript\">");
			out.println("alert('can not be updated');");
			out.println("location='showAllFlight';");
			out.println("</script>");
		
		}	
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
