<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>Profile</title>

<link rel='stylesheet' href="assets/css/profile.css">

</head>
<body>

	<h3>
		<a href="userPage.jsp">Go To Home</a>
	</h3>
	<h1>My Profile</h1>
	<br>
	<br>

	<c:set var="user" scope="session" value="${user}" />
	<a class="update" href="updateprofile.jsp">Update</a>
	<div class="table">


		<table aria-describedby="profile">
		<th id=""></th>
			<tr>
				<td><h2>Name</h2></td>
				<td><h3>${user.getName()}</h3></td>
			</tr>
			<tr>
				<td><h2>Email Id</h2></td>
				<td><h3>${user.getEmail()}</h3></td>
			</tr>

			<tr>
				<td><h2>Mobile No</h2></td>
				<td><h3>${user.getMboNo()}</h3></td>
			</tr>

		</table>

	</div>
	
</body>
</html>