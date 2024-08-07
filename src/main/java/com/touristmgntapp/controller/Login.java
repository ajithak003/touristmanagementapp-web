package com.touristmgntapp.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.touristmgntapp.dao.Impl.AdminTableDaoImplement;
import com.touristmgntapp.dao.Impl.UserTableDaoImplement;
import com.touristmgntapp.model.AdminClass;
import com.touristmgntapp.model.UserClass;

import javax.servlet.http.HttpServlet;

@WebServlet("/login")
public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		try {
			UserTableDaoImplement userDao = new UserTableDaoImplement();
			AdminTableDaoImplement adminDao = new AdminTableDaoImplement();


			String email = request.getParameter("loginemail");
			email = email.trim().toLowerCase();

			if (email.endsWith("@admin.com")) {

				AdminClass admin;
				String password = request.getParameter("loginpsws");

				admin = adminDao.validateAdmin(email, password);
				if (admin == null) {

					request.getRequestDispatcher("login.jsp?error=user name and password mismatch").forward(request, response);
				} else {
					session.setAttribute("welcom", admin.getName());
					response.sendRedirect("adminPage.jsp");

				}
			}

			String password = request.getParameter("loginpsws");

			UserClass user = userDao.validateUser(email, password);

			if (user == null) {

				request.getRequestDispatcher("login.jsp?error=user name and password mismatch").forward(request, response);

			} else {

				session.setAttribute("user", user);
				session.setAttribute("welcom", user.getName());

				request.getRequestDispatcher("userPage.jsp").forward(request, response);

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}

}
