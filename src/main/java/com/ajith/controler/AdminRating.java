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
import javax.servlet.http.HttpSession;

import com.ajith.daoImplement.RatingDaoImplement;
import com.ajith.daoImplement.UserTableDaoImplement;
import com.ajith.model.UserFeedbackClass;

/**
 * Servlet implementation class AdminRating
 */

@WebServlet("/adminratings")
public class AdminRating extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRating() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println("calling");
		 try {
		RatingDaoImplement ratingDao = new RatingDaoImplement();
	     
			List<UserFeedbackClass> ratings = ratingDao.getAllFeedback();
		
			request.setAttribute("adminratings", ratings);
		    
		    RequestDispatcher rd=request.getRequestDispatcher("adminRating.jsp");
			rd.forward(request, response);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
