package com.touristmgntapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.touristmgntapp.dao.Impl.PackageModeClassDaoImplement;
import com.touristmgntapp.model.PackageModeClass;


@WebServlet("/updatepackage")
public class UpdatePackage extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)  {
		try {
		PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();
		
		String packagename = request.getParameter("packagename");
		
		double packageOneDayPrice = Double.parseDouble(request.getParameter("packageonedayprice"));
		
		String season = request.getParameter("season");
		
		String protocol = request.getParameter("protocols");
		
		String description = request.getParameter("description");
		
		int packageId = Integer.parseInt(request.getParameter("packageid"));
		
		String status = request.getParameter("status");
		
		String image = request.getParameter("packageimage");
		
		PackageModeClass packages = new PackageModeClass(packageId,packagename,packageOneDayPrice,season,protocol,description,status,image);
		boolean pack = packageDao.updatePackage(packages);
	
		if(pack) {
			
			List<PackageModeClass> packageList = packageDao.getAllAdminPackage();
			
			request.setAttribute("showalladminpackage", packageList);
			
			RequestDispatcher rd = request.getRequestDispatcher("showAllAdminPackages.jsp?updatepackage=updated");
		
				rd.forward(request, response);
			
		}
		else {
				response.sendRedirect("showAllAdminPackages.jsp?updateerror=cannot be updated");
			
		}} catch (IOException | ServletException | NumberFormatException e) {
			e.printStackTrace();
		}
		
		}
	}
	
	

