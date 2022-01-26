package com.ajith.controler;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajith.daoImplement.UserTableDaoImplement;

@WebServlet("/updateprofile")
public class UpdateProfile extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) {

		
		try {

			UserTableDaoImplement userDao = new UserTableDaoImplement();
			

			String name = req.getParameter("FullName");
		//System.out.println(name);

			String email = req.getParameter("regemail");
			//System.out.println(email);
			email = email.trim().toLowerCase();
			
			// System.out.println(email);

			long mboilNo = Long.parseLong(req.getParameter("regmobile"));
			//System.out.println(mboilNo);

			String password = req.getParameter("regpsw");
			//System.out.println(password);
			
			boolean update = userDao.updateuser(name, email, mboilNo, password);
			//System.out.println(update);
			PrintWriter out = res.getWriter();
			if(update) {
				
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Successfully Updated');");
				out.println("location='logout.jsp';");
				out.println("</script>");


				
			}
			
			else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('can't be updated! please try agin later');");
				out.println("location='logout.jsp';");
				out.println("</script>");

			}

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
