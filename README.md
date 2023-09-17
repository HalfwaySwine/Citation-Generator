# Citation-Generator 
A citation Generator that uses a login and register system. It uses JSP, JAVA, and SQL. The project runs on the apache tomcat server 9.0. 

The index.jsp page features a login and registration page. Both the login and registration interact with your SQL database via Java servlets. After logging in, you can view old citations or make new citations. Pressing on make citation will prompt you to enter the format, author, article title, and more. It will also ask for a project name. The name you give can be used later for searching up old citations. If you press on view old citations you can show all or search by the project name you gave. On display, it gives you the citation the date accessed, the project name, and the option to delete it. The citations are stored in their own table with a column that holds the user's unique id(first time using SQL so not sure if this is the right approach). 

# How to run in Eclipse 
First download and import the project. Next, you will need to  download SQL and set that up. After it has been setup you need to go to all servlet classes except logout.java to have the proper connection to your SQL and password. You will also need to download an apache tomcat server. I ended up using 9.0. 

# Plan to add later 
Id like to add an edit button as well and more options for formats with citations. I also wasn't to focused on how the project looked so I didn't pay to much attention to CSS id like to go back and make it look much nicer.
