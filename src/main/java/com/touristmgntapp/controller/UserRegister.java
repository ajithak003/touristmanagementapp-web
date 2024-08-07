package com.touristmgntapp.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.touristmgntapp.dao.Impl.UserTableDaoImplement;
import com.touristmgntapp.exception.UserDefineException;
import com.touristmgntapp.model.UserClass;

@WebServlet("/register")
public class UserRegister extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		try {

			UserTableDaoImplement userDao = new UserTableDaoImplement();

			String name = request.getParameter("FullName");

			String email = request.getParameter("regemail");
			email = email.trim().toLowerCase();

			long mboilNo = Long.parseLong(request.getParameter("regmobile"));

			String password = request.getParameter("regpsw");

			boolean verifi = true;
			verifi = userDao.emailvalid(email);

			if (!verifi) {
				throw new UserDefineException();

			}

			else {
				if (email.contains("@admin")) {

					response.sendRedirect("register.jsp?notallow=not allowed to use @admin");

				} else {

					UserClass userinsert = new UserClass(name, email, mboilNo, password);
					boolean boo = userDao.insertUser(userinsert);
					if (boo) {
						EmailVerificationServlet.sendVerificationEmail(email); 

						response.sendRedirect("login.jsp?infomsg=successfully registered");

					}

				}
			}
		} catch (UserDefineException | IOException e) {
			try {
				response.sendRedirect("register.jsp?errormsg=This email id already registered");
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			}

		}

	}
	
}
