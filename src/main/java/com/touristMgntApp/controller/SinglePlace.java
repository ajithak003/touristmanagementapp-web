package com.touristMgntApp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.touristMgntApp.daoImpl.PackageModeClassDaoImplement;
import com.touristMgntApp.daoImpl.RatingDaoImplement;
import com.touristMgntApp.models.BookingClass;
import com.touristMgntApp.models.PackageModeClass;
import com.touristMgntApp.models.UserClass;
import com.touristMgntApp.models.UserFeedbackClass;

@WebServlet("/singlePackage")
public class SinglePlace extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			String location = request.getParameter("location");

			PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();
			PackageModeClass packages = packageDao.getSinglePackage(location.toLowerCase());

			HttpSession session = request.getSession();
			session.setAttribute("singlepackages", packages);

			UserClass user = (UserClass) session.getAttribute("user");
			double totalPrice = packages.getPriceOneDays();
			
			RatingDaoImplement ratingDao = new RatingDaoImplement();
			UserFeedbackClass rating = ratingDao.getAllFeedbackratingS(location);
			session.setAttribute("singleaverating", rating);
            
			BookingClass booking = new  BookingClass( user, packages,  null,  null,  0,null ,totalPrice, "", "", "",location,0); 
		   
			session.setAttribute("booking",booking);
			
			response.sendRedirect("singlePackage.jsp");
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
