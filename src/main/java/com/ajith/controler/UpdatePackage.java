package com.ajith.controler;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajith.daoImplement.PackageModeClassDaoImplement;
import com.ajith.model.PackageModeClass;


@WebServlet("/updatepackage")
public class UpdatePackage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)  {
		
		try {
		PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();
		
		String packagename = request.getParameter("packagename");
		
		double packageOneDayPrice = Double.parseDouble(request.getParameter("packageonedayprice"));
		
		String season = request.getParameter("season");
		
		String protocol = request.getParameter("protocols");
		
		String description = request.getParameter("description");
		
		int packageId = Integer.parseInt(request.getParameter("packageid"));
		
		String image = request.getParameter("packageimage");
		
		PackageModeClass packages = new PackageModeClass(packageId,packagename,packageOneDayPrice,season,protocol,description,image);
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