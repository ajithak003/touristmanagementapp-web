package com.touristMgntApp.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		session.removeAttribute("welcom");
		session.removeAttribute("user");
		session.invalidate();

		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 

		try {
			response.sendRedirect("index.jsp");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
