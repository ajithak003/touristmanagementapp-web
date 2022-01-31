package com.touristmgntapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.touristmgntapp.daoImpl.HotelTableDaoImplement;
import com.touristmgntapp.exception.UserDefineException;
import com.touristmgntapp.models.HotelClass;


@WebServlet("/addhotel")
public class AddHotel extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		
		
		
		try {
			HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();
		
		String hotelname = request.getParameter("hotelname");
		
		String hotelLocation = request.getParameter("hotellocation");
		
	   double normalRoom = Double.parseDouble(request.getParameter("standardprice"));
		
		double premiumRoom = Double.parseDouble (request.getParameter("premiumprice"));
		
		String image = request.getParameter("hotelimage");
		
		
		HotelClass hotel = new HotelClass(hotelname,hotelLocation,normalRoom,premiumRoom,image);
		boolean hotels;
		
			hotels = hotelDao.insertHotel(hotel);
		
		
		PrintWriter out =  response.getWriter();
		if(hotels) {			

			out.println("<script type=\"text/javascript\">");
			out.println("alert('Successfully Added');");
			out.println("location='addHotel.jsp';");
			out.println("</script>");
			
		}
		
		else {
			throw new UserDefineException();
		}
		} catch (UserDefineException | ClassNotFoundException | SQLException  e) {
			HttpSession session = request.getSession();
			session.setAttribute("addHotelerror", ((UserDefineException) e).addhotel());
			try {
				response.sendRedirect("addHotel.jsp");
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			}
		
		}
	
	}

}
