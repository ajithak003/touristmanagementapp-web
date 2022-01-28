package com.ajith.controler;

import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajith.daoImplement.FlightTableDaoImplement;
import com.ajith.daoImplement.PackageModeClassDaoImplement;
import com.ajith.model.FlightClass;


@WebServlet(urlPatterns = "/updateflight")
public class UpdateFlight extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)  {
		
		try {
			
		PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();
		
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
		
		int flightno = Integer.parseInt(req.getParameter("flightno"));
		
		FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
		FlightClass flight = new FlightClass(flightno,flightName,depature, destination, depatureTimeDate, arrivalTimeDate,
				businessClassFare, economicClassFare,status,businessClassSeat,economicClassSeat);
		 
		
		boolean flights = flightDao.updateFlight(flight);
		
		PrintWriter out = res.getWriter();
		if(flights) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Successfully Updated');");
			out.println("location='showAllFlight';");
			out.println("</script>");
			
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
