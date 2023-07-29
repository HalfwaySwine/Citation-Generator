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
 * Servlet implementation class DeleteCit 
 * responsible for deleting citation from SQL and re updating displayed list
 */
@WebServlet("/DeleteCit")
public class DeleteCit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteCit() {
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
		
		//gets hidden input box from oldcit.jsp it is the citation id
		String citid = request.getParameter("submit_id"); 

		try {  
			//connection and delete citation
			Class.forName("com.mysql.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?useSSL=false","root", "passwordhere"); 
			Statement st = con.createStatement();   
			st.execute("DELETE FROM citation2 WHERE id = "+citid+""); 

			//get userid and project name if it exist 
			int un= (int) session.getAttribute("userid");  
			String fukth = (String) session.getAttribute("name1"); 

			//if show all button is clicked it will display all citations again and update page
			if(fukth  == null || fukth.equals("")) { 
				session.removeAttribute("aa");
				ResultSet rs = st.executeQuery("select * from citation2 where userid = "+un+""); 
				request.setAttribute("rs", rs); 
				ArrayList<CitationU> aa = new ArrayList<>();
				while(rs.next()) {  
					CitationU type = new CitationU(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
					aa.add(type);
				} 
				session.removeAttribute("aa");
				session.setAttribute("aa", aa);	 
				//redisplays the updated list if it was showing user entered project name at the time delete was pushed
			}else {
				ResultSet rs2 = st.executeQuery("select * from citation2 where userid = "+un+" && ucatagory = \""+fukth+"\""); 
				ArrayList<CitationU> aa = new ArrayList<>();
				while(rs2.next()) {  
					CitationU type = new CitationU(rs2.getInt(1), rs2.getInt(2), rs2.getString(3), rs2.getString(4), rs2.getString(5));
					aa.add(type);

				}
				session.removeAttribute("aa");
				session.setAttribute("aa", aa);
			}

			dispatcher = request.getRequestDispatcher("OldCit.jsp"); 
			dispatcher.include(request, response); 


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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
