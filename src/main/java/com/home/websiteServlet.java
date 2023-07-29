package com.home;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class websiteServlet
 * Responsible for getting info from makeCiation.jsp and sending making a CitM object which will make the citation based on the format and info. 
 * It will then store the info in SQL database(citation2 table user airline) with specific user ID and will display citation at the bottom of the screen.
 * 
 */
@WebServlet("/websiteServlet")
public class websiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 

		//get entered info 
		String format = request.getParameter("format"); 
		String articletitle = request.getParameter("articlet"); 
		String author = request.getParameter("author"); 
		String webtitle = request.getParameter("webtitle"); 
		String url = request.getParameter("url");  
		String folder = request.getParameter("folder"); 
		String puplisheDate = request.getParameter("datepup"); 
		String dateAcc = request.getParameter("dateacc");  
		String publisher = request.getParameter("publisher"); 

		//make citation
		CitM cit = new CitM(format, articletitle, author, webtitle, url, puplisheDate, dateAcc, publisher);
		String ct = cit.makeCit();

		//stuff you need
		RequestDispatcher dispatch = null;
		Connection con = null; 
		PreparedStatement pst = null; 
		HttpSession session = request.getSession();

		try {   		
			//connect
			Class.forName("com.mysql.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?useSSL=false","root", "passwordhere"); 
			pst = con.prepareStatement("insert into citation2(userid,ucit,udate,ucatagory) values(?,?,?,?)");  
			//get user id set in login
			int un= (int) session.getAttribute("userid"); 
			//place info
			pst.setInt(1, un);  
			pst.setString(2, ct); 
			pst.setString(3, dateAcc); 
			pst.setString(4, folder);
			//execute
			int rowCount = pst.executeUpdate();  
			//success
			if (rowCount > 0) {  
				session.setAttribute("citationsuc", ct);
				dispatch = request.getRequestDispatcher("makeCitationMLA.jsp"); 
				dispatch.include(request, response); 
			}else {  
				//failure for some reason
				session.setAttribute("errorcit", "SOMETHING FAILED");
				dispatch = request.getRequestDispatcher("makeCitationMLA.jsp"); 
				dispatch.include(request, response); 
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
