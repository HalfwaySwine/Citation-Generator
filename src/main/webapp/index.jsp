<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<link rel="stylesheet" href="css/welcomePage.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Raleway:wght@100;300&display=swap"
	rel="stylesheet">
</head>
<body>

	<%-- Home page for users to select login, register or guest --%>

	<div id="background">
		<div id="titlediv">
			<h1>Citation Generator</h1>
		</div>
		<div id="threerow">
			<div class="innerdiv">
				<form action="login.jsp">
					<button class="innerbut" type="submit">LOGIN</button>
				</form>
			</div>
			<div class="innerdiv">
				<form action="registration.jsp">
					<button class="innerbut" type="submit">REGISTER</button>
				</form>
			</div>

		</div>
	</div>
</body>
</html>