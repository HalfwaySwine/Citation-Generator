<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" href="css/welcomePage.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Raleway:wght@100;300&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
	<%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  if(session.getAttribute("userr")==null)
      response.sendRedirect("login.jsp");

  %>
	<%-- Home screen displayed to people who login in has buttons for make citation and my saved citation and sign out --%>
	<div id="background">

		<form action="logout">
			<button id="goback" type="submit">SIGN OUT</button>
		</form>
		<div id="titlediv">
			<h1>
				Welcome
				<%=session.getAttribute("userr")%></h1>
		</div>
		<div id="threerow">
			<div class="innerdiv">
				<form action="makeCitationMLA.jsp">
					<button class="innerbut" type="submit">MAKE CITATION</button>
				</form>
			</div>
			<div class="innerdiv">
				<form action="OldCit.jsp">
					<button class="innerbut" type="submit">MY SAVED CITATIONS</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>