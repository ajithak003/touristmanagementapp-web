package com.ajith.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajith.daoImplement.PackageModeClassDaoImplement;
import com.ajith.model.PackageModeClass;

/**
 * Servlet implementation class showAllPackage
 */
@WebServlet("/showAllPackage")
public class showAllAdminPackage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showAllAdminPackage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	    PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();
	    List<PackageModeClass> packages = packageDao.getAllPackage();
	    for(int i =0; i<packages.size(); i++){
	    	
	    	PackageModeClass singlePackage = packages.get(i);
	    
	    }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
