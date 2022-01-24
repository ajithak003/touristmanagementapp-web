package com.ajith.controler;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajith.daoImplement.PackageModeClassDaoImplement;
import com.ajith.model.PackageModeClass;


@WebServlet("/updatepackage")
public class updatePackage extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)  {
		
		try {
		PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();
		
		String packagename = req.getParameter("packagename");
		//System.out.println(packagename);
		
		double packageOneDayPrice = Double.parseDouble(req.getParameter("packageonedayprice"));
		//System.out.println(packageOneDayPrice);
		
		String season = req.getParameter("season");
		//System.out.println(season);
		
		String protocol = req.getParameter("protocols");
		//System.out.println(protocol);
		
		String description = req.getParameter("description");
		//System.out.println(description);
		
		int packageId = Integer.parseInt(req.getParameter("packageid"));
		//System.out.println(packageId);
		
		String image = req.getParameter("packageimage");
		
		PackageModeClass packages = new PackageModeClass(packageId,packagename,packageOneDayPrice,season,protocol,description,image);
		//System.out.println("servlet : "+packages);
		boolean pack = packageDao.updatePackage(packages);
		
		HttpSession session = req.getSession();
		PrintWriter out = res.getWriter();
		if(pack==true) {
			//System.out.println("insert success");
//			session.setAttribute("adminpackage", "true");
//			req.getRequestDispatcher("showAllAdminPackages.jsp").forward(req,res);
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Successfully Updated');");
			out.println("location='showAllAdminPackages.jsp';");
			out.println("</script>");
			
		}
		else {
			//System.out.println("insert invalid");
			//session.setAttribute("adminpackage", "false");
			//req.getRequestDispatcher("showAllAdminPackages.jsp").forward(req,res);
			out.println("<script type=\"text/javascript\">");
			out.println("alert('can not be Updated');");
			out.println("location='showAllAdminPackages.jsp';");
			out.println("</script>");
		}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
