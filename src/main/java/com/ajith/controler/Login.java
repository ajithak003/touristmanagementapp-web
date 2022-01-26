package com.ajith.controler;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajith.daoImplement.AdminTableDaoImplement;
import com.ajith.daoImplement.UserTableDaoImplement;
import com.ajith.model.AdminClass;
import com.ajith.model.UserClass;

import javax.servlet.http.HttpServlet;

@WebServlet("/login")
public class Login extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		try {
			UserTableDaoImplement userDao = new UserTableDaoImplement();
			AdminTableDaoImplement adminDao = new AdminTableDaoImplement();

			adminDao = new AdminTableDaoImplement();
			userDao = new UserTableDaoImplement();

			String email = request.getParameter("loginemail");
			email = email.trim().toLowerCase();

			if (email.endsWith("@admin.com")) {

				AdminClass admin = new AdminClass();
				String password = request.getParameter("loginpsws");
				// System.out.println(password);

				admin = adminDao.validateAdmin(email, password);
				if (admin == null) {

					session.setAttribute("error", "user name and password mismatch");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				} else {

					session.setAttribute("welcom", admin.getName());
					response.sendRedirect("AdminPage.jsp");

				}
			}

			String password = request.getParameter("loginpsws");

			UserClass user = userDao.validateUser(email, password);

			if (user == null) {

				session.setAttribute("error", "user name and password mismatch");
				request.getRequestDispatcher("login.jsp").forward(request, response);

			} else {

				response.sendRedirect("UserPage.jsp");

				session.setAttribute("user", user);
				session.setAttribute("welcom", user.getName());
				session.setAttribute("wallet", "none");

				request.getRequestDispatcher("UserPage.jsp").forward(request, response);

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}

}
