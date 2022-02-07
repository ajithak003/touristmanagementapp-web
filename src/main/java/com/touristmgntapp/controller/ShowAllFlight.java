package com.touristmgntapp.controller;

import java.io.IOException;
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

@WebServlet("/showAllFlight")
public class ShowAllFlight extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
		FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
	       List<FlightClass> flight = flightDao.getAllFlight();
		request.setAttribute("showalladminflight", flight);
		
		RequestDispatcher rd = request.getRequestDispatcher("showAllFlight.jsp");
	
			rd.forward(request, response);
		} catch (ServletException | IOException | ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
