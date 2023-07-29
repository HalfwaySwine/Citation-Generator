package com.home;

/* 
 * Object used to hold info retrieved from SQL to store in an arraylist so OldCit.jsp can display info easier
 * 
 */
public class CitationU {
	
	public int id; 
	private int userid; 
	private String ucitation;
	private String date; 
	private String project; 
	
	
	public CitationU(int id,int userid,String ucitation,String date,String project) { 
		this.id = id; 
		this.userid = userid; 
		this.ucitation = ucitation; 
		this.date = date; 
		this.project = project;
	} 
	
	public int getId() { 
		return this.id;
	} 
	
	public int getUserId() { 
		return this.userid;
	} 
	
	public String getUcitation() { 
		return this.ucitation;
	} 
	
	public String getDate() { 
		return this.date;
	} 
	
	public String getProject() { 
		return this.project;
	}
	
}
