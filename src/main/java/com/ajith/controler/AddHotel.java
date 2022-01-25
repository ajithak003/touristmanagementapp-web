package com.ajith.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajith.daoImplement.HotelTableDaoImplement;
import com.ajith.exception.UserDefineException;
import com.ajith.model.HotelClass;


@WebServlet("/addhotel")
public class AddHotel extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		
		
		
		try {
			HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();
		
		String hotelname = request.getParameter("hotelname");
		//System.out.println(hotelname);
		
		String hotelLocation = request.getParameter("hotellocation");
		//System.out.println(hotelLocation);
		
	   double normalRoom = Double.parseDouble(request.getParameter("standardprice"));
		//System.out.println(normalRoom);
		
		double premiumRoom = Double.parseDouble (request.getParameter("premiumprice"));
		//System.out.println(premiumRoom);
		
		String image = request.getParameter("hotelimage");
		
		
		HotelClass hotel = new HotelClass(hotelname,hotelLocation,normalRoom,premiumRoom,image);
		//System.out.println(hotelDao);
		boolean hotels;
		
			hotels = hotelDao.insertHotel(hotel);
		
		HttpSession session = request.getSession();
		
		PrintWriter out =  response.getWriter();
		if(hotels) {
			//System.out.println("insert success");
			

			out.println("<script type=\"text/javascript\">");
			out.println("alert('Successfully Added');");
			out.println("location='addHotel.jsp';");
			out.println("</script>");
			
		}
		
		else {
			//System.out.println("insert invalid");
			throw new UserDefineException();
		}
		} catch (UserDefineException | ClassNotFoundException | SQLException e) {
			HttpSession session = request.getSession();
			//System.out.println("error");
			session.setAttribute("addHotelerror", ((UserDefineException) e).addhotel());
			try {
				response.sendRedirect("addHotel.jsp");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
		}
	
	}

}
