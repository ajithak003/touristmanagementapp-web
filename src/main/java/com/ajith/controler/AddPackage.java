package com.ajith.controler;

import java.io.IOException;
import java.io.PrintWriter;

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


	public void doPost(HttpServletRequest request, HttpServletResponse response) {
	

		PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();
		
		String packagename = request.getParameter("packagename");
		
		double packageOneDayPrice = Double.parseDouble(request.getParameter("packageonedayprice"));
		
		String season = request.getParameter("season");
		
		String protocol = request.getParameter("protocol");
		
		String description = request.getParameter("description");
		
		String image = request.getParameter("packageimage");

		try {
		
		PackageModeClass packages = new PackageModeClass(packagename,packageOneDayPrice,season,protocol,description,image);
		boolean pack = packageDao.insertPackage(packages);
		
		PrintWriter out = response.getWriter();
		if(pack) {
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Successfully Added');");
			out.println("location='addPackage.jsp';");
			out.println("</script>");
			
		}
		else {
			throw new UserDefineException();
		}
		} catch (UserDefineException | NumberFormatException | IOException e) {
			HttpSession session = request.getSession();
			session.setAttribute("addpackageerror", ((UserDefineException) e).addPackage());
			try {
				response.sendRedirect("addPackage.jsp");
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			}
		
	}}
}
