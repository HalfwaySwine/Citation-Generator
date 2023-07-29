package com.loginout;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class logout 
 * responsible  for logout. Sends user back to index.jsp and removes all attributes 
 */
@WebServlet("/logout")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();  
		RequestDispatcher dispatcher = null; 
		session.removeAttribute("aa");
		session.removeAttribute("userid"); 
		session.removeAttribute("userr"); 
		session.removeAttribute("name1"); 
		//session.invalidate();   
		session.setAttribute("userId", null); 
		response.sendRedirect("index.jsp"); 
		dispatcher = request.getRequestDispatcher("index.jsp"); 
		dispatcher.include(request, response);  
		session.invalidate();
		//request.getSession(false).invalidate();
		
	}

	
}
