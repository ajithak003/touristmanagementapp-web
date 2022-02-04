package com.touristmgntapp.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.touristmgntapp.dao.Impl.HotelTableDaoImplement;
import com.touristmgntapp.model.HotelClass;

@WebServlet("/updatehotel")
public class UpdateHotel extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		try {
			HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();

			String hotelname = request.getParameter("hotelname");

			String hotelLocation = request.getParameter("hotellocation");

			double normalRoom = Double.parseDouble(request.getParameter("standardprice"));

			double premiumRoom = Double.parseDouble(request.getParameter("premiumprice"));

			int hotelid = Integer.parseInt(request.getParameter("hotelid"));
			
			String status = request.getParameter("status");

			String image = request.getParameter("hotelimage");

			HotelClass hotel = new HotelClass(hotelid, hotelLocation, hotelname, normalRoom, premiumRoom,status, image);
			boolean hotels = hotelDao.updateHotel(hotel);

			if (hotels) {
				List<HotelClass> hotelsList = hotelDao.getAllHotel();

				request.setAttribute("showalladminhotel", hotelsList);

				RequestDispatcher rd = request.getRequestDispatcher("showAllHotel.jsp?updatehote=successfully updated");
				rd.forward(request, response);

			} else {
				response.sendRedirect("showAllHotel.jsp?updateerror=cannot be updated");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
