package com.touristMgntApp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/terms")
public class Terms extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		try {
		HttpSession session = request.getSession();

		int bookingId = Integer.parseInt(request.getParameter("bookingid"));
		session.setAttribute("datechangebookingid", bookingId);

		RequestDispatcher rd = request.getRequestDispatcher("terms.jsp");
		
			rd.forward(request, response);
		} catch (ServletException | IOException | NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}

}
