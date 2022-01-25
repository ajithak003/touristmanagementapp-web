
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>Tourist Managements</title>

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	text-decoration: none;
	font-family: Arial, sans-serif;
}

body {
	background-image: url("Assets/home.png.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	width: 100%;
	height: 100vh;
	filter: brightness(150%);
}

h1 {
	color: crimson;
	text-align: center;
	font-weight: bold;
	font-size: 100px;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

ul {
	list-style: none;
	background-color: black;
	height: 70px;
	padding-inline: 100px;
}

li {
	display: inline-block;
	line-height: 2px;
	width: 250px;;
	padding: 24px;
	word-spacing: 4px;
	position: relative;
	margin-top: 10px;
	font-size: 20px;
	left: 150px;
}

a {
	text-decoration: none;
	color: blanchedalmond;
}

a:hover {
	color: deepskyblue;
}
</style>

</head>
<body>

	<div id="link">
		<ul>
			<li><a href="#">Home</a></li>
			<li><a href="showAllHomePlaces">Popular Places</a></li>
			<li><a href="showAllRating.jsp">Ratings</a></li>
			<li><a href="login.jsp">Login</a></li>

		</ul>
	</div>
	<h1>Tourist Management</h1>


</body>
</html>