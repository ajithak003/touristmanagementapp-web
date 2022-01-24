package com.ajith.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajith.daoImplement.AdminTableDaoImplement;
import com.ajith.daoImplement.UserTableDaoImplement;
import com.ajith.exception.UserDefineException;
import com.ajith.model.AdminClass;
import com.ajith.model.UserClass;

import javax.servlet.http.HttpServlet;







@WebServlet("/login")
public class Login extends HttpServlet {
	
	
	 
		public void doPost (HttpServletRequest req,HttpServletResponse res) {
			 
			 HttpSession session=req.getSession();
			 
			
			 
		try {
			UserTableDaoImplement userDao = new UserTableDaoImplement();
			AdminTableDaoImplement adminDao = new AdminTableDaoImplement();
			
			adminDao = new AdminTableDaoImplement();
			userDao = new UserTableDaoImplement();

			//System.out.println("Login Page");
			String email = req.getParameter("loginemail");
			//System.out.println(email);
					email = email.trim().toLowerCase();

						// System.out.println(email);
					

				if (email.endsWith("@admin.com")) {

					AdminClass admin = new AdminClass();
					String password = req.getParameter("loginpsws");
					//System.out.println(password);
					
					 admin = adminDao.validateAdmin(email, password);
					if (admin == null) {
						//System.out.println("user name and password mismatch");
						
						session.setAttribute("error", "user name and password mismatch");
					    req.getRequestDispatcher("login.jsp").forward(req,res); 
					} else if (admin != null) {
					
							res.sendRedirect("AdminPage.jsp");
						
						//System.out.println("Welcom " + admin.getName());
						session.setAttribute("welcom",admin.getName() );
					
							req.getRequestDispatcher("UserPage.jsp").forward(req,res);
						
				         
					}
					}
				
				String password = req.getParameter("loginpsws");
				//System.out.println(password);
				
				UserClass user = userDao.validateUser(email, password);
				
				if (user == null) {
					//System.out.println("user name and password mismatch");
					//throw new UserDefineException();
					
					session.setAttribute("error", "user name and password mismatch");
				    req.getRequestDispatcher("login.jsp").forward(req,res); 

				} else if (user != null) {
				
						res.sendRedirect("UserPage.jsp");
					
					//System.out.println("Welcom " + user.getName());
					session.setAttribute("user", user);
					session.setAttribute("welcom",user.getName());
					session.setAttribute("wallet", "none");
					
						req.getRequestDispatcher("UserPage.jsp").forward(req,res);
					
					
				}
				
					} catch (Exception e) {
				// TODO Auto-generated catch block
						
						//System.out.println(e.getMessage());
						
						
							
			}
	
	

}

		}

