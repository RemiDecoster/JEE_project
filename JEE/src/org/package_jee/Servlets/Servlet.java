package org.package_jee.Servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Servlet extends HttpServlet {
	private void doProcess( HttpServletRequest request, HttpServletResponse response) {
		String pageName = "/accueil.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
		try{rd.forward(request, response);} 
		catch(ServletException e) {e.printStackTrace();} 
		catch(IOException e) {e.printStackTrace();}

	}
}
