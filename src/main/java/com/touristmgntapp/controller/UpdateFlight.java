package com.touristmgntapp.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.touristmgntapp.dao.Impl.FlightTableDaoImplement;
import com.touristmgntapp.model.FlightClass;

@WebServlet(urlPatterns = "/updateflight")
public class UpdateFlight extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {

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
			FlightClass flight = new FlightClass(flightno, flightName, depature, destination, depatureTimeDate,
					arrivalTimeDate, businessClassFare, economicClassFare, status, businessClassSeat,
					economicClassSeat);

			boolean flights = flightDao.updateFlight(flight);

			if (flights) {
				List<FlightClass> showFlights = flightDao.getAllFlight();

				request.setAttribute("showalladminflight", showFlights);
				
				RequestDispatcher rd = request.getRequestDispatcher("showAllFlight.jsp?&updateflight=34");
				rd.forward(request, response);

			} else {

				response.sendRedirect("showAllFlight.jsp?updateerror=cannot be updated");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
