package com.ajith.controler;

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

	public void doPost(HttpServletRequest req, HttpServletResponse res) {

		HttpSession session = req.getSession();

		try {
			UserTableDaoImplement userDao = new UserTableDaoImplement();
			AdminTableDaoImplement adminDao = new AdminTableDaoImplement();

			adminDao = new AdminTableDaoImplement();
			userDao = new UserTableDaoImplement();

			String email = req.getParameter("loginemail");
			email = email.trim().toLowerCase();

			if (email.endsWith("@admin.com")) {

				AdminClass admin = new AdminClass();
				String password = req.getParameter("loginpsws");
				// System.out.println(password);

				admin = adminDao.validateAdmin(email, password);
				if (admin == null) {

					session.setAttribute("error", "user name and password mismatch");
					req.getRequestDispatcher("login.jsp").forward(req, res);
				} else {

					res.sendRedirect("AdminPage.jsp");

					session.setAttribute("welcom", admin.getName());

					req.getRequestDispatcher("UserPage.jsp").forward(req, res);

				}
			}

			String password = req.getParameter("loginpsws");
			

			UserClass user = userDao.validateUser(email, password);

			if (user == null) {

				session.setAttribute("error", "user name and password mismatch");
				req.getRequestDispatcher("login.jsp").forward(req, res);

			} else {

				res.sendRedirect("UserPage.jsp");

				
				session.setAttribute("user", user);
				session.setAttribute("welcom", user.getName());
				session.setAttribute("wallet", "none");

				req.getRequestDispatcher("UserPage.jsp").forward(req, res);

			}

		} catch (Exception e) {

		}

	}

}
