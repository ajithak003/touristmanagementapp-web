package com.ajith.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajith.daoImplement.FlightTableDaoImplement;
import com.ajith.model.FlightClass;

@WebServlet("/updateFlight")
public class PreUpdateFlight extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		int flightNo = Integer.parseInt(request.getParameter("flightno"));
		FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
		FlightClass flight = flightDao.getSingleFlight(flightNo);

		request.setAttribute("updateflight", flight);

		RequestDispatcher rd = request.getRequestDispatcher("updateFlight.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException | NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}
}
