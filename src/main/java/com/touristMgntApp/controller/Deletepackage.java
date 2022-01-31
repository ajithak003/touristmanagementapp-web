package com.touristMgntApp.controller;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.touristMgntApp.daoImpl.PackageModeClassDaoImplement;

@WebServlet("/deletepackage")
public class Deletepackage extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		   String packageName = request.getParameter("packagname");
	       PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();
	    
	       boolean packages = packageDao.deletePackage(packageName);
	       try {
			PrintWriter out = response.getWriter();

	       if(packages) {
	    	    out.println("<script type=\"text/javascript\">");
				out.println("alert('Successfully Deleted !');");
				out.println("location='showAllAdminPackages';");
				out.println("</script>");
				
			}
			else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('can not be Deleted !');");
				out.println("location='showAllAdminPackages';");
				out.println("</script>");
			}
	       }catch(Exception e) {
	    	   System.out.println(e.getMessage());
	       }

	}
	
}
