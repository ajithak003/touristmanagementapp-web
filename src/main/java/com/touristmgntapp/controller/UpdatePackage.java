package com.touristmgntapp.controller;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.touristmgntapp.daoImpl.PackageModeClassDaoImplement;
import com.touristmgntapp.model.PackageModeClass;


@WebServlet("/updatepackage")
public class UpdatePackage extends HttpServlet {

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
		
		String image = request.getParameter("packageimage");
		
		PackageModeClass packages = new PackageModeClass(packageId,packagename,packageOneDayPrice,season,protocol,description,"active",image);
		boolean pack = packageDao.updatePackage(packages);
		
		PrintWriter out = response.getWriter();
		if(pack) {
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Successfully Updated');");
			out.println("location='showAllAdminPackages';");
			out.println("</script>");
			
		}
		else {
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('can not be Updated');");
			out.println("location='showAllAdminPackages';");
			out.println("</script>");
		}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
