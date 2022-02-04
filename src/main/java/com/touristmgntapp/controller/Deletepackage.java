package com.touristmgntapp.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.touristmgntapp.dao.Impl.PackageModeClassDaoImplement;
import com.touristmgntapp.model.PackageModeClass;

@WebServlet("/deletepackage")
public class Deletepackage extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		   String packageName = request.getParameter("packagname");
	       PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();
	    
	       boolean packages = packageDao.deletePackage(packageName);
	       try {

	       if(packages) {
	    	   List<PackageModeClass> packageList = packageDao.getAllAdminPackage();
				
				request.setAttribute("showalladminpackage", packageList);
				
				RequestDispatcher rd = request.getRequestDispatcher("showAllAdminPackages.jsp?deletepackage=successfully deleted");
			
					rd.forward(request, response);
			}
			else {
				response.sendRedirect("showAllAdminPackages.jsp?deleteerror=cannot be deleted");
			}
	       }catch(Exception e) {
	    	   System.out.println(e.getMessage());
	       }

	}
	
}
