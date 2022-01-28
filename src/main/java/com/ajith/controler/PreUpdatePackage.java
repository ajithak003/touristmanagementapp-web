package com.ajith.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajith.daoImplement.PackageModeClassDaoImplement;
import com.ajith.model.PackageModeClass;

@WebServlet("/updatePackage")
public class PreUpdatePackage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		String packageName = request.getParameter("packagname");
		PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();
		PackageModeClass packages = packageDao.getPackageByNo(packageName);

		request.setAttribute("updatepackage", packages);

		RequestDispatcher rd = request.getRequestDispatcher("updatePackage.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
