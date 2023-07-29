package com.registration;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registrationServlet 
 * responsible for sending info from registration.jsp to SQL database(users table under airline) and redirecting to login page if successful 
 */
@WebServlet("/registrationServlet")
public class registrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		//gets info 
		String uname = request.getParameter("username"); 
		String uemail = request.getParameter("email"); 
		String upwd = request.getParameter("password"); 
		String umobile = request.getParameter("number"); 
		RequestDispatcher dispatch = null;
		Connection con = null; 
		PreparedStatement pst = null;


		try {   
			//gets connection
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?useSSL=false","root", "passwordhere"); 
			pst = con.prepareStatement("insert into users(uname,upwd,uemail,umobile) values(?,?,?,?)");
			pst.setString(1, uname);  
			pst.setString(2, upwd); 
			pst.setString(3, uemail); 
			pst.setString(4, umobile);
			
			//executes sql command 
			int rowCount = pst.executeUpdate();  
			if (rowCount > 0) {  
				//successful 
				dispatch = request.getRequestDispatcher("login.jsp"); 
				dispatch.forward(request, response);
			}else {  
				//error
				request.setAttribute("error", "SOMETHING FAILED");
				dispatch = request.getRequestDispatcher("registration.jsp"); 
				dispatch.include(request, response); 

			}

		} catch (Exception e) { 
			e.printStackTrace(); 

		}finally { 
			try { 
				//close connections
				con.close();  
				pst.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
