package com.ajith.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajith.daoImplement.PackageModeClassDaoImplement;
import com.ajith.model.PackageModeClass;

@WebServlet("/showAllPlaces")
public class ShowAllPlaces extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();
		List<PackageModeClass> packages = packageDao.getAllPackage();

		request.setAttribute("showAllPlaces", packages);

		RequestDispatcher rd = request.getRequestDispatcher("showAllPlaces.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
