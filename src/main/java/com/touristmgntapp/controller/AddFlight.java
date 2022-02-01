package com.touristmgntapp.controller;

import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.touristmgntapp.dao.Impl.FlightTableDaoImplement;
import com.touristmgntapp.model.FlightClass;

@WebServlet("/addflight")
public class AddFlight extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)  {
		
		
		try {
			
					
		String flightName = req.getParameter("flightname");
		
		String depature = req.getParameter("Depature");
		
		String destination = req.getParameter("destination");
		
		String depatureDate = req.getParameter("DepatureDate");
		LocalDateTime depatureTimeDate = LocalDateTime.parse(depatureDate);
		
		String arrivalDate = req.getParameter("ArrivalDate");
		LocalDateTime arrivalTimeDate = LocalDateTime.parse(arrivalDate);
		
		double businessClassFare = Double.parseDouble(req.getParameter("businessclassfare"));
		
		double economicClassFare = Double.parseDouble(req.getParameter("economicclassfare"));
		
		String status = req.getParameter("status");
		
		int businessClassSeat = Integer.parseInt(req.getParameter("businessclassseat"));
		
		int economicClassSeat = Integer.parseInt(req.getParameter("economicclassseat"));
		
		FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
		FlightClass flight = new FlightClass(flightName,depature, destination, depatureTimeDate, arrivalTimeDate,
				businessClassFare, economicClassFare,status,businessClassSeat,economicClassSeat);
		
		boolean flights = flightDao.insertFlight(flight);
		
		PrintWriter out = res.getWriter();
		
		if(flights) {
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Successfully Added');");
			out.println("location='addFlight.jsp';");
			out.println("</script>");
			
		}
		else {
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('can not be added! please try again');");
			out.println("location='addFlight.jsp';");
			out.println("</script>");
			
		}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
