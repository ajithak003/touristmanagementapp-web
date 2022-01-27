package com.ajith.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajith.daoImplement.UserTableDaoImplement;
import com.ajith.model.UserClass;



@WebServlet("/showAllUserList")

public class ShowAllUserList extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println("calling");
		UserTableDaoImplement userDao = new UserTableDaoImplement();
        List<UserClass> users = userDao.getAllUser();
         
         request.setAttribute("showalluserlist", users);
         
         RequestDispatcher rd = request.getRequestDispatcher("showAllUserList.jsp");
         rd.forward(request, response);
         
        
		
	}

}
