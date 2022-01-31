<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>show All User</title>

<style>
table {
	border: 2px solid;
	border-collapse: collapse;
	background-color: mintcream;
	margin-left: 33%;
}

tr, td, th {
	border: 2px solid;
	text-align: center;
	padding: 10px;
}

a {
	text-decoration: none;
}

h1 {
	text-align: center;
	font-size: 50px;
	color: steelblue
}

h2 {
	margin-left: 20px;
}
</style>

</head>
<body>
	
	<h2>
		<a href="adminPage.jsp">Go To Home</a>
	</h2>

	<h1>Show All Users</h1>

	<br>
	<br>

	<table aria-describedby="Show All User">


		<th id="">User Id</th>
		<th id="">User Name</th>
		<th id="">User Email Id</th>
		<th id="">User Mobile No</th>

		<c:forEach items="${showalluserlist}" var="user">
		<tr>
			<td>${user.getId()}</td>
			<td>${user.getName()}</td>
			<td>${user.getEmail()}</td>
			<td>${user.getMboNo()}</td>

		</tr>
		</c:forEach>
	</table>

</body>
</html>