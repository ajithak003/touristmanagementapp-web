package com.touristmgntapp.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.touristmgntapp.dao.Impl.PackageModeClassDaoImplement;
import com.touristmgntapp.exception.UserDefineException;
import com.touristmgntapp.model.PackageModeClass;

@WebServlet("/addpackage")
public class AddPackage extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		try {

			PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();

			String packagename = request.getParameter("packagename");

			double packageOneDayPrice = Double.parseDouble(request.getParameter("packageonedayprice"));

			String season = request.getParameter("season");

			String protocol = request.getParameter("protocol");

			String description = request.getParameter("description");

			String image = request.getParameter("packageimage");

			PackageModeClass packages = new PackageModeClass(packagename.toLowerCase(), packageOneDayPrice, season,
					protocol, description, image);
			boolean pack = packageDao.insertPackage(packages);

			if (pack) {
				response.sendRedirect("addPackage.jsp?infomsg=successfully added");

			} else {
				throw new UserDefineException();
			}
		} catch (UserDefineException | NumberFormatException | IOException e) {

			try {
				response.sendRedirect("addPackage.jsp?error=" + ((UserDefineException) e).addPackage());
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			}

		}
	}
}