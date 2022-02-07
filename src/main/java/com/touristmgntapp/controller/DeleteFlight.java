package com.touristmgntapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.touristmgntapp.dao.Impl.FlightTableDaoImplement;
import com.touristmgntapp.model.FlightClass;

@WebServlet("/deleteFlight")
public class DeleteFlight extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
			List<FlightClass> showFlights = flightDao.getAllFlight();

			request.setAttribute("showalladminflight", showFlights);
			
			RequestDispatcher rd = request.getRequestDispatcher("showAllFlight.jsp?deleteflight=successfully deleted");
			rd.forward(request, response);
			
		} else {
			response.sendRedirect("showAllFlight.jsp?deleteerror=cannot be deleted");
		}
		} catch (ClassNotFoundException | SQLException | IOException | NumberFormatException | ServletException e) {
			System.out.println(e.getMessage());
		}

	}

}
