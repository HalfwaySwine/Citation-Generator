<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Citations</title>
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
	<%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  if(session.getAttribute("userr")==null)
      response.sendRedirect("login.jsp");

  %>


	<%-- Responsible for showing users specific citations, they can also search by project the foreach is from JSTL --%>
	<div id="background">
		<form action="home.jsp">
			<button id="goback">Back</button>
		</form>
		<div id="titlediv">
			<h1>MY CITATIONS</h1>
		</div>

		<div id="centerdiv">
			<div id="divleft">
				<div>
					<form action="PastCit">
						<div id="buttondiv">
							<label><input type="submit" name="showall"
								value="show all"></label> <label><input type="text"
								name="projectType" id="projectType"><input type="submit"
								value="Search By Project"></label>
						</div>
					</form>
				</div>
				<table id="tablest">
					<tr>
						<th>CITATION</th>
						<th>DATE</th>
						<th>PROJECT</th>
						<th>ACTION</th>
					</tr>
					<%--The hidden input is for the citation id so it knows what to delete --%>
					<c:forEach var="aa" items="${aa}">
						<tr>
							<td><c:out value="${aa.ucitation}" /></td>
							<td><c:out value="${aa.date}" /></td>
							<td><c:out value="${aa.project}" /></td>
							<td><form action="DeleteCit">
									<input type="hidden" name="submit_id" value="${aa.id}" /><label><input
										type="submit" value="delete" id="dsdsd"></label>
								</form></td>
						</tr>

					</c:forEach>

				</table>

			</div>

		</div>
	</div>


</body>
</html>