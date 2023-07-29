package com.home;

/* 
 * Responsible for holding the citation info gathered from the makeCitation.jsp file and is called from the websiteSeervlet.java file and making the citation
 * 
 */
public class CitM {

	private String format; 
	private String atitle; 
	private String authors;
	private String wtitle;
	private String url; 
	private String pupdate; 
	private String accdate;  
	private String publisher;

	public CitM(String format, String atitle, String authors, String wtitle, String url, String pupdate, String accdate, String publisher) { 
		this.format = format; 
		this.atitle = atitle; 
		this.authors = authors; 
		this.wtitle = wtitle; 
		this.url = url; 
		this.pupdate = pupdate; 
		this.accdate = accdate;  
		this.publisher = publisher;
	} 

	/* 
	 * make citation based on format given earlier
	 */
	public String makeCit() {
		if(this.format.equals("MLA")) { 
			return makeMLA();
		}else { 
			return makeAPA();
		}

	}

	//make mla citation
	private String makeMLA() { 
		String cit = ""; 
		//no author title first
		if(this.authors.equals("")) { 
			cit += "\""+this.atitle+"\"";
		}else { 
			cit += this.authors + ". "+"\""+this.atitle+".\" ";
		} 
		cit += this.wtitle +", ";  
		if((!(this.wtitle.equals(this.publisher)) || !(this.authors.equals(this.publisher))) && !this.publisher.equals("")) { 
			cit += this.publisher+", ";
		} 
		if(!this.pupdate.equals("")) {  
			//pub date
			String year = this.pupdate.substring(0, 4); 
			String month = getMonth(this.pupdate.substring(5, 7));  
			String day = this.pupdate.substring(8); 
			cit += day + " "; 
			cit += month + ". "; 
			cit += year +", "; 
		}else {  
			//access date 
			String year = this.accdate.substring(0, 4); 
			String month = getMonth(this.accdate.substring(5, 7));  
			String day = this.accdate.substring(8); 
			cit += day + " "; 
			cit += month + ". "; 
			cit += year +", "; 
		}
		cit += this.url + ".";
		return cit;
	} 


	//make apa citation
	private String makeAPA() { 
		String cit = "";   

		String date = ""; 
		if(this.pupdate.equals("")) { 
			date += "(n.d). ";
		}else {  
			String year = this.pupdate.substring(0, 4); 
			String month = getMonth(this.pupdate.substring(5, 7));  
			String day = this.pupdate.substring(8); 
			date += "(" + year +", " + month + " " + day + "). "; 
		} 

		if(this.authors.equals("")) { 
			cit += this.atitle + ". " + this.wtitle + ". " ;
			cit += date; 
			cit += this.url;
			return cit;
		}else { 
			cit += this.authors + ". " + date + this.atitle + ". " + this.wtitle + ". " + this.url; 
			return cit;	
		}		
	} 

	//month
	private static String getMonth(String month) {  
		String yearn = ""; 
		switch(month) { 
		case "01":
			yearn = "Jan"; 
			break; 
		case "02":
			yearn = "Feb"; 
			break; 
		case "03":
			yearn = "Mar"; 
			break; 
		case "04":
			yearn = "Apr"; 
			break; 	
		case "05":
			yearn = "May"; 
			break; 
		case "06":
			yearn = "Jun"; 
			break; 
		case "07":
			yearn = "Jul"; 
			break; 	
		case "08":
			yearn = "Aug"; 
			break; 	
		case "09":
			yearn = "Sep"; 
			break; 	
		case "10":
			yearn = "Oct"; 
			break; 	
		case "11":
			yearn = "Nov"; 
			break; 	
		case "12":
			yearn = "Dec"; 
			break; 	

		}
		return yearn;

	}

}
