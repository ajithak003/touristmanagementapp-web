package com.ajith.controler;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajith.daoImplement.HotelTableDaoImplement;
import com.ajith.model.HotelClass;

@WebServlet ("/updatehotel")
public class updateHotel extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res)  {
		
		
		try {
			HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();
		
		String hotelname = req.getParameter("hotelname");
		//System.out.println(hotelname);
		
		String hotelLocation = req.getParameter("hotellocation");
		//System.out.println(hotelLocation);
		
	   double normalRoom = Double.parseDouble(req.getParameter("standardprice"));
		//System.out.println(normalRoom);
		
		double premiumRoom = Double.parseDouble (req.getParameter("premiumprice"));
		//System.out.println(premiumRoom);
		
		int hotelid = Integer.parseInt(req.getParameter("hotelid"));
		
		String image = req.getParameter("hotelimage");
		
		
		HotelClass hotel = new HotelClass(hotelid,hotelLocation,hotelname,normalRoom,premiumRoom,image);
		//System.out.println(hotelDao);
		boolean hotels = hotelDao.updateHotel(hotel);
		
		HttpSession session = req.getSession();
		PrintWriter out = res.getWriter();
		if(hotels==true) {
			//System.out.println("update success");
//			session.setAttribute("hotel", "true");
//			req.getRequestDispatcher("showAllHotel.jsp").forward(req,res);
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Successfully Updated');");
			out.println("location='showAllHotel.jsp';");
			out.println("</script>");
			
		}
		else {
			//System.out.println("update invalid");
//			session.setAttribute("hotel", "false");
//			req.getRequestDispatcher("showAllHotel.jsp").forward(req,res);
			out.println("<script type=\"text/javascript\">");
			out.println("alert('can not be Updated');");
			out.println("location='showAllHotel.jsp';");
			out.println("</script>");
		}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
