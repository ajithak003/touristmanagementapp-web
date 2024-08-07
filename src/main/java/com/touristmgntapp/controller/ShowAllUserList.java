package com.touristmgntapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.touristmgntapp.dao.Impl.UserTableDaoImplement;
import com.touristmgntapp.model.UserClass;



@WebServlet("/showAllUserList")
public class ShowAllUserList extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		UserTableDaoImplement userDao = new UserTableDaoImplement();
        List<UserClass> users = userDao.getAllUser();
         
         request.setAttribute("showalluserlist", users);
         
         RequestDispatcher rd = request.getRequestDispatcher("showAllUserList.jsp");
         try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			System.out.println(e.getMessage());
		}
         
        
		
	}

}
