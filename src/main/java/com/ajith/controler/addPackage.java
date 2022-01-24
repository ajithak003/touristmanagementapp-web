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


@WebServlet(urlPatterns = "/addpackage")
public class addPackage extends HttpServlet {

	Scanner sc = new Scanner(System.in);

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException  {
	

		PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();
		
		String packagename = req.getParameter("packagename");
		//System.out.println(packagename);
		
		double packageOneDayPrice = Double.parseDouble(req.getParameter("packageonedayprice"));
		//System.out.println(packageOneDayPrice);
		
		String season = req.getParameter("season");
		//System.out.println(season);
		
		String protocol = req.getParameter("protocol");
		//System.out.println(protocol);
		
		String description = req.getParameter("description");
		//System.out.println(description);
		
		String image = req.getParameter("packageimage");
		//System.out.println(image);
try {
		
		PackageModeClass packages = new PackageModeClass(packagename,packageOneDayPrice,season,protocol,description,image);
		//ystem.out.println(packages);
		boolean pack = packageDao.insertPackage(packages);
		
		HttpSession session = req.getSession();
		PrintWriter out = res.getWriter();
		if(pack==true) {
			
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
			// TODO Auto-generated catch block
			HttpSession session = req.getSession();
			//System.out.println("error");
			session.setAttribute("addpackageerror", e.addPackage());
			try {
				res.sendRedirect("addPackage.jsp");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}}
}
