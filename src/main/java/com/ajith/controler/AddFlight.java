package com.ajith.controler;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajith.daoImplement.FlightTableDaoImplement;
import com.ajith.daoImplement.PackageModeClassDaoImplement;
import com.ajith.model.FlightClass;
import com.ajith.model.PackageModeClass;

@WebServlet("/addflight")
public class AddFlight extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)  {
		
		
		try {
			
			DateTimeFormatter formatter =
		            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();
		
		String flightName = req.getParameter("flightname");
		//System.out.println(flightName);
		
		String depature = req.getParameter("Depature");
		//System.out.println(depature);
		
		String destination = req.getParameter("destination");
		//System.out.println(destination);
		
		String depatureDate = req.getParameter("DepatureDate");
		LocalDateTime depatureTimeDate = LocalDateTime.parse(depatureDate);
		//System.out.println(depatureTimeDate);
		
		String ArrivalDate = req.getParameter("ArrivalDate");
		LocalDateTime arrivalTimeDate = LocalDateTime.parse(ArrivalDate);
		//System.out.println(arrivalTimeDate);
		
		double businessClassFare = Double.parseDouble(req.getParameter("businessclassfare"));
		//System.out.println(businessClassFare);
		
		double economicClassFare = Double.parseDouble(req.getParameter("economicclassfare"));
		//System.out.println(economicClassFare);
		
		String status = req.getParameter("status");
		//System.out.println(status);
		
		int businessClassSeat = Integer.parseInt(req.getParameter("businessclassseat"));
		//System.out.println(businessClassSeat);
		
		int economicClassSeat = Integer.parseInt(req.getParameter("economicclassseat"));
		//System.out.println(economicClassSeat);
		
		FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
		FlightClass flight = new FlightClass(flightName,depature, destination, depatureTimeDate, arrivalTimeDate,
				businessClassFare, economicClassFare,status,businessClassSeat,economicClassSeat);
		
		boolean flights = flightDao.insertFlight(flight);
		
		HttpSession session = req.getSession();
		PrintWriter out = res.getWriter();
		
		if(flights==true) {
			
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
