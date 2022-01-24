package com.ajith.controler;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajith.daoImplement.UserTableDaoImplement;
import com.ajith.exception.UserDefineException;
import com.ajith.model.UserClass;




@WebServlet(urlPatterns = {"/register", "/otp"})


public class UserRegister extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		
		
		

		try {

			UserTableDaoImplement userDao = new UserTableDaoImplement();
			

			String name = req.getParameter("FullName");
		//	System.out.println(name);

			String email = req.getParameter("regemail");
			//System.out.println(email);
			email = email.trim().toLowerCase();
			
			// System.out.println(email);

			long mboilNo = Long.parseLong(req.getParameter("regmobile"));
			//System.out.println(mboilNo);

			String password = req.getParameter("regpsw");
			//System.out.println(password);

			HttpSession session = req.getSession();
			
				boolean verifi = true;
				verifi = userDao.emailvalid(email);

				if (verifi == false) {
					throw new UserDefineException();

				}
		
			else {
				if (email.contains("@admin")) {
					
					//System.out.println("notallow");
					session.setAttribute("notallow", "Not allowed '@admin' !");
					try {
						res.sendRedirect("Register.jsp");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
				
			UserClass userinsert = new UserClass(name, email, mboilNo, password);
			//System.out.println(userinsert);
			boolean boo = userDao.insertUser(userinsert);
			if (boo) {
				//System.out.println("Successfully Register");
				
				session.setAttribute("success", "Successfully Register");
				try {
					res.sendRedirect("otp.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			}
			}
		} catch (UserDefineException e) {
			// TODO Auto-generated catch block
			HttpSession session = req.getSession();
			//System.out.println("error");
			session.setAttribute("error", e.reregister());
			try {
				res.sendRedirect("Register.jsp");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		
	}

	}}
