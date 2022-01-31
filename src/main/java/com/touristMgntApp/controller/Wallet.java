package com.touristMgntApp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.touristMgntApp.daoImpl.UserTableDaoImplement;
import com.touristMgntApp.models.UserClass;

@WebServlet("/wallet")
public class Wallet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
        UserClass user = (UserClass) session.getAttribute("user");
        
        UserTableDaoImplement userDao = new UserTableDaoImplement();
        UserClass newUser;
		try {
			newUser = userDao.getSingleUserById(user.getId());
         
        session.setAttribute("newUser", newUser);
        
        response.sendRedirect("wallet.jsp");
        
		} catch (ClassNotFoundException | SQLException | IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
