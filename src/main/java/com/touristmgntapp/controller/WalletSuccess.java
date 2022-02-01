package com.touristmgntapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.touristmgntapp.daoImpl.UserTableDaoImplement;
import com.touristmgntapp.model.UserClass;

@WebServlet("/walletSus")
public class WalletSuccess extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		try {
			HttpSession session = request.getSession();

			UserClass user = (UserClass) session.getAttribute("newUser");
			UserTableDaoImplement userDao = new UserTableDaoImplement();
			String amounts = request.getParameter("amount");
			long amount = Long.parseLong(amounts);
			if (amount > 0) {
				long totalAmount = user.getWallet() + amount;
				boolean wallet = userDao.addWalletAmount(user.getId(), totalAmount);

				if (wallet) {

					UserClass newUser = userDao.getUserById(user);
					request.setAttribute("walletuser", newUser);

					RequestDispatcher rd = request.getRequestDispatcher("walletSus.jsp");
					rd.forward(request, response);

				}

				else {
					PrintWriter out = response.getWriter();
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Successfully Added');");
					out.println("location='addHotel.jsp';");
					out.println("</script>");
				}
			}
		} catch (ClassNotFoundException | SQLException | ServletException | IOException | NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}
}
