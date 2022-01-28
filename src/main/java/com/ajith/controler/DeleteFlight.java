package com.ajith.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajith.daoImplement.FlightTableDaoImplement;

@WebServlet("/deleteFlight")
public class DeleteFlight extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		int flightNo = Integer.parseInt(request.getParameter("flightno"));
		System.out.print(flightNo);

		FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
		boolean flight;
		try {
			flight = flightDao.deleteFlight(flightNo);
		
		PrintWriter out = response.getWriter();
		if (flight ) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Successfully Deleted !');");
			out.println("location='showAllFlight';");
			out.println("</script>");
			
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('can not be Deleted !');");
			out.println("location='showAllFlight';");
			out.println("</script>");
		
		}
		} catch (ClassNotFoundException | SQLException | IOException | NumberFormatException e) {
			System.out.println(e.getMessage());
		}

	}

}
