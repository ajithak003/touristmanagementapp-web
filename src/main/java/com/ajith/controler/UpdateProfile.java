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

			String email = req.getParameter("regemail");
			email = email.trim().toLowerCase();

			long mboilNo = Long.parseLong(req.getParameter("regmobile"));

			String password = req.getParameter("regpsw");

			boolean update = userDao.updateuser(name, email, mboilNo, password);
			PrintWriter out = res.getWriter();
			if (update) {

				out.println("<script type=\"text/javascript\">");
				out.println("alert('Successfully Updated ! please Login');");
				out.println("location='logout.jsp';");
				out.println("</script>");

			}

			else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('can't be updated! please try agin later');");
				out.println("location='logout.jsp';");
				out.println("</script>");

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
