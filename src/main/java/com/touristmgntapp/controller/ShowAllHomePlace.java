package com.touristmgntapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.touristmgntapp.daoImpl.PackageModeClassDaoImplement;
import com.touristmgntapp.model.PackageModeClass;

@WebServlet("/showAllHomePlaces")
public class ShowAllHomePlace extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		 PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();
	       List<PackageModeClass> packages = packageDao.getAllPackage();
	       
	       request.setAttribute("showAllHomePlaces",packages );
		    
		    RequestDispatcher rd=request.getRequestDispatcher("showAllHomePlaces.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				System.out.println(e.getMessage());
			} 
		
	}
	
}
