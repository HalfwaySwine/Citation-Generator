package com.home;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PastCit 
 * responsible for displaying old retreving old citations for data base and sending them in a session attribute array list labeled aa
 */
@WebServlet("/PastCit")
public class PastCit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PastCit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		//stuff needed
		HttpSession session = request.getSession(); 
		Connection con = null;  
		RequestDispatcher dispatcher = null;  

		try {  
			//connection
			Class.forName("com.mysql.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?useSSL=false","root", "passwordhere"); 
			Statement st = con.createStatement();  

			//list all if show all button is hit
			if (request.getParameter("showall") != null) { 
				//gets user id and shows all citations user has made
				int un= (int) session.getAttribute("userid"); 
				ResultSet rs = st.executeQuery("select * from citation2 where userid = "+un+""); 
				request.setAttribute("rs", rs); 
				
				//sends them to a CitationU arraylist which ill be used in the JSP file to display the info
				ArrayList<CitationU> aa = new ArrayList<>();
				while(rs.next()) {  
					CitationU type = new CitationU(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
					aa.add(type);

				} 
				//removes name1 which is important for search by project so it doesn't get confused when deleting is pushed 
				//updates page
				session.removeAttribute("name1");  
				session.removeAttribute("aa"); 
				session.setAttribute("aa", aa); 
				dispatcher = request.getRequestDispatcher("OldCit.jsp"); 
				dispatcher.include(request, response); 

			} else if((request.getParameter("projectType") != null) && !(request.getParameter("projectType").equals(""))) {  
				//this is if the search by project is clicked
				//gets the user entered info for project name
				String projectName = request.getParameter("projectType");
				//gets user id
				int un= (int) session.getAttribute("userid"); 
				ResultSet rs = st.executeQuery("select * from citation2 where userid = "+un+" && ucatagory = \""+projectName+"\""); 
				//sends them to a CitationU arraylist which ill be used in the JSP file to display the info
				ArrayList<CitationU> aa = new ArrayList<>();
				while(rs.next()) {  
					CitationU type = new CitationU(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
					aa.add(type);

				}
				//name1 useful for delete button 
				session.removeAttribute("name1"); 
				session.setAttribute("name1", projectName);
				session.removeAttribute("aa");
				session.setAttribute("aa", aa);
				dispatcher = request.getRequestDispatcher("OldCit.jsp"); 
				dispatcher.include(request, response); 
			}else { 
				dispatcher = request.getRequestDispatcher("OldCit.jsp"); 
				dispatcher.include(request, response); 
			}
			
			
		}catch(Exception e) { 
			e.printStackTrace();
		}finally { 
			try { 
				//close connections
				con.close();  
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
