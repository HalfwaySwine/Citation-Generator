<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet" href="css/loginAndReg.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Raleway:wght@100;300&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<%-- Registration jsp page responsible for retrieving user info and sending it to the servlet --%>
</head>
<body>
	<div>
		<form action="index.jsp">
			<button id="goback">Back</button>
		</form>
	</div>
	<div id="titlehead">
		<h1>USER REGISTRATION</h1>
	</div>
	<form action="registrationServlet" method="post">
		<div id=tablestuff>
			<table id="maintable">
				<tr>
					<td>Enter Name:</td>
					<td><input type="text" name="username" id="username" required></td>
				</tr>
				<tr>
					<td>Enter Email:</td>
					<td><input type="email" name="email" id="email" required></td>
				</tr>
				<tr>
					<td>Enter Password:</td>
					<td><input type="password" name="password" id="password"
						pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
						title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
						required></td>
				</tr>
				<tr>
					<td>Contact Number:</td>
					<td><input type="tel" name="number" id="number"
						pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" title="Format xxx-xxx-xxxx" required></td>
				</tr>
				<tr>
					<td></td>
					<td><span style="color: red;">${error}</span></td>
				</tr>
				<tr>
					<td><input type="submit" value="Register"></td>
					<td><input type="reset"></td>
				</tr>
			</table>
		</div>

	</form>

</body>
</html>