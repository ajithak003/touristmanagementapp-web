package com.touristMgntApp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.touristMgntApp.daoImpl.FlightTableDaoImplement;

@WebServlet("/deleteFlight")
public class DeleteFlight extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
		int flightNo = Integer.parseInt(request.getParameter("flightno"));
		System.out.print(flightNo);

		FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
		boolean flight;
	
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
