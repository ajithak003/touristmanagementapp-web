package com.ajith.controler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajith.daoImplement.RatingDaoImplement;
import com.ajith.model.UserFeedbackClass;

@WebServlet("/adminratings")
public class AdminRating extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			RatingDaoImplement ratingDao = new RatingDaoImplement();

			List<UserFeedbackClass> ratings = ratingDao.getAllFeedback();

			request.setAttribute("adminratings", ratings);

			RequestDispatcher rd = request.getRequestDispatcher("adminRating.jsp");
			rd.forward(request, response);

		} catch (ClassNotFoundException | SQLException | ServletException | IOException e) {

			System.out.println(e.getMessage());
		}
	}

}
