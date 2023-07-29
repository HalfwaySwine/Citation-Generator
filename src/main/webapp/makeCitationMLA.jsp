<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ENTER WEBSITE INFO</title>
<link rel="stylesheet" href="css/EnterInfo.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Raleway:wght@100;300&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body> 
	<%-- Responsible for making citation, displaying at bottom of screen and saving in SQL database for user --%>
	<div>
		<form action="home.jsp">
			<button id="goback">Back</button>
		</form>
	</div>

	<div id="wrapform">
		<h1>ENTER WEBSITE INFO</h1>
		<form action="websiteServlet" method="post">
			<div id="innerwrap">
				<p>
					<label> Format <br /> <select name="format" id="format">
							<option value="APA">APA</option>
							<option value="MLA">MLA</option>
					</select>
					</label>
				</p>

				<p>
					<label>Article title: <input type="text" name="articlet"
						id="articlet" required></label>
				</p>

				<p>
					<label>Author </br> (Last, First etc....): <input type="text"
						name="author" id="author"></label>
				</p>

				<p>
					<label>Website Title: <input type="text" name="webtitle"
						id="webtitle" required></label>
				</p>

				<p>
					<label>Sponser or Publisher: <input type="text"
						name="publisher" id="publisher"></label>
				</p>

				<p>
					<label>URL: <input type="text" name="url" id="url" required></label>
				</p>

				<p>
					<label>Published Date: <input type="date" name="datepup"
						id="datepup"></label>
				</p>

				<p>
					<label>Date accessed: <input type="date" name="dateacc"
						id="dateacc" required></label>
				</p>

				<p>
					<label>Project: <input type="text" name="folder"
						id="folder" required></label>
				</p>

				<p>
					<label><input type="submit" value="Submit"></label>

				</p>


			</div>
		</form>
	</div>
	<div id="citdisplay">
		<h1>Copy here</h1>
		<h2>${citationsuc}</h2>
	</div>
</body>
</html>