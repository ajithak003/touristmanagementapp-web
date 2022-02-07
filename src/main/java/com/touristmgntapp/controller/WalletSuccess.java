package com.touristmgntapp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.touristmgntapp.dao.Impl.UserTableDaoImplement;
import com.touristmgntapp.model.UserClass;

@WebServlet("/walletSus")
public class WalletSuccess extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		try {
			HttpSession session = request.getSession();

			UserClass user = (UserClass) session.getAttribute("user");
			UserTableDaoImplement userDao = new UserTableDaoImplement();
			String amounts = request.getParameter("amount");
			long amount = Long.parseLong(amounts);
			if (amount > 0) {
				long totalAmount = user.getWallet() + amount;
				boolean wallet = userDao.addWalletAmount(user.getId(), totalAmount);

				if (wallet) {

					UserClass newUser = userDao.getUserById(user);
					session.setAttribute("user", newUser);
					response.sendRedirect("walletSus.jsp");
				}

				else {
					response.sendRedirect("wallet.jsp?error=Transaction failed");
				}
			}
		} catch (ClassNotFoundException | SQLException | IOException | NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}
}
