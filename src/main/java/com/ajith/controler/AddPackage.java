package com.ajith.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajith.daoImplement.PackageModeClassDaoImplement;
import com.ajith.exception.UserDefineException;
import com.ajith.model.PackageModeClass;


@WebServlet("/addpackage")
public class AddPackage extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException  {
	

		PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();
		
		String packagename = request.getParameter("packagename");
		//System.out.println(packagename);
		
		double packageOneDayPrice = Double.parseDouble(request.getParameter("packageonedayprice"));
		//System.out.println(packageOneDayPrice);
		
		String season = request.getParameter("season");
		//System.out.println(season);
		
		String protocol = request.getParameter("protocol");
		//System.out.println(protocol);
		
		String description = request.getParameter("description");
		//System.out.println(description);
		
		String image = request.getParameter("packageimage");
		//System.out.println(image);
try {
		
		PackageModeClass packages = new PackageModeClass(packagename,packageOneDayPrice,season,protocol,description,image);
		//ystem.out.println(packages);
		boolean pack = packageDao.insertPackage(packages);
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		if(pack) {
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Successfully Added');");
			out.println("location='addPackage.jsp';");
			out.println("</script>");
			
		}
		else {
			//System.out.println("insert invalid");
			throw new UserDefineException();
		}
		} catch (UserDefineException e) {
			HttpSession session = request.getSession();
			//System.out.println("error");
			session.setAttribute("addpackageerror", e.addPackage());
			try {
				response.sendRedirect("addPackage.jsp");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
	}}
}