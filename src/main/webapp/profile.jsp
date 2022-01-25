<%@page import="com.ajith.model.UserClass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>Profile</title>
<style>
/*  body{
            background-color:rgb(202, 187, 187);
        } */
h1 {
	text-align: center;
	color: blue;
}

.table {
	align-items: center;
	border: 3px solid;
	margin-left: 35%;
	height: 430px;
	width: 400px;
}

.update {
	text-decoration: none;
	position: absolute;
	margin-left: 320px;
	font-size: 20px;
	font-weight: bold;
	margin-top: -440px;
}

a {
	text-decoration: none;
}
</style>
</head>
<body>

	<%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
	<h3>
		<a href="UserPage.jsp">Go To Home</a>
	</h3>
	<h1>My Profile</h1>


	<!-- <a class = "update" href="updateprofile.jsp">Update</a> -->
	<br>
	<br>

	<%  
    UserClass user = (UserClass) session.getAttribute("user");

%>

	<div class="table">
		<table cellspacing="50px">
			<tr>
				<td><h2>Name</h2></td>
				<td><h3><%=user.getName() %></h3></td>
			</tr>
			<tr>
				<td><h2>Email Id</h2></td>
				<td><h3><%=user.getEmail() %></h3></td>
			</tr>

			<tr>
				<td><h2>Mobile No</h2></td>
				<td><h3><%= user.getMboNo() %></h3></td>
			</tr>

		</table>
		<a class="update" href="updateprofile.jsp">Update</a>
	</div>
</body>
</html>