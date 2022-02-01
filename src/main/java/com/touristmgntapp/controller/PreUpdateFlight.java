package com.touristmgntapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.touristmgntapp.dao.Impl.FlightTableDaoImplement;
import com.touristmgntapp.model.FlightClass;

@WebServlet("/updateFlight")
public class PreUpdateFlight extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		try {
		int flightNo = Integer.parseInt(request.getParameter("flightno"));
		FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
		FlightClass flight = flightDao.getSingleFlight(flightNo);

		request.setAttribute("updateflight", flight);

		RequestDispatcher rd = request.getRequestDispatcher("updateFlight.jsp");
	
			rd.forward(request, response);
		} catch (ServletException | IOException | NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}
}
