package com.ajith.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajith.daoImplement.UserTableDaoImplement;
import com.ajith.exception.UserDefineException;
import com.ajith.model.UserClass;

@WebServlet("/register")
public class UserRegister extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		try {

			UserTableDaoImplement userDao = new UserTableDaoImplement();

			String name = request.getParameter("FullName");

			String email = request.getParameter("regemail");
			email = email.trim().toLowerCase();

			long mboilNo = Long.parseLong(request.getParameter("regmobile"));

			String password = request.getParameter("regpsw");

			HttpSession session = request.getSession();

			boolean verifi = true;
			verifi = userDao.emailvalid(email);

			if (!verifi) {
				throw new UserDefineException();

			}

			else {
				if (email.contains("@admin")) {

					session.setAttribute("notallow", "Not allowed '@admin' !");

					response.sendRedirect("Register.jsp");

				} else {

					UserClass userinsert = new UserClass(name, email, mboilNo, password);
					boolean boo = userDao.insertUser(userinsert);
					if (boo) {
						PrintWriter out = response.getWriter();
						out.println("<script type=\"text/javascript\">");
						out.println("alert('Successfully Registered ! please Login');");
						out.println("location='login.jsp';");
						out.println("</script>");

					}

				}
			}
		} catch (UserDefineException | IOException e) {
			HttpSession session = request.getSession();
			session.setAttribute("error", ((UserDefineException) e).reregister());
			try {
				response.sendRedirect("Register.jsp");
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			}

		}

	}
}
