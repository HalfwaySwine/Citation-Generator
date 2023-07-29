package com.loginout;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.home.CitationU;

/**
 * Servlet implementation class LoginServlet 
 * takes user and password entered by user and checks it with the SQL database and forwards to home page if true and outputs invalid if not
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		//gets username and password
		String uemail = request.getParameter("username"); 
		String upwd = request.getParameter("password");    
		
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null; 
		PreparedStatement pst = null; 
		Connection con = null;

		try {  
			//gets connection 
			Class.forName("com.mysql.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?useSSL=false","root", "passwordhere"); 
			pst = con.prepareStatement("select * from users where uemail = ? and upwd = ?");
			pst.setString(1, uemail); 
			pst.setString(2, upwd); 
			
			ArrayList<CitationU> aa = new ArrayList<>(); 
			session.setAttribute("aa", aa);
			
			ResultSet rs = pst.executeQuery();  
			//valid user
			if (rs.next()) {   
				session.setAttribute("userr", rs.getString("uname"));//added 
				session.setAttribute("userid", rs.getInt("id"));
				dispatcher = request.getRequestDispatcher("home.jsp"); 
				dispatcher.forward(request, response);
			}else {   
				//invalid user
				request.setAttribute("error", "INVALID CREDENTIALS");
				dispatcher = request.getRequestDispatcher("login.jsp"); 
				dispatcher.include(request, response); 

			}
		}catch(Exception e) { 
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
