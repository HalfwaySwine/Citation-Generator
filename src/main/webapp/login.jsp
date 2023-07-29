<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="css/loginAndReg.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Raleway:wght@100;300&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head> 
<%-- Login Page --%>
<body>
	<div>
		<form action="index.jsp">
			<button id="goback">Back</button>
		</form>
	</div>
	<div id="titlehead">
		<h1>USER LOGIN</h1>
	</div>
	<form action="LoginServlet" method="post">
		<div id=tablestuff>
			<table id="maintable">
				<tr>
					<td>Enter Email:</td>
					<td><input type="text" name="username" id="username" required></td>
				</tr>
				<tr>
					<td>Enter Password:</td>
					<td><input type="password" name="password" id="password"
						required></td>
				</tr>
				<tr>
					<td></td>
					<td><span style="color: red;">${error}</span></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login"></td>
					<td><input type="reset"></td>
				</tr>
			</table>

		</div>
	</form>

</body>
</html>