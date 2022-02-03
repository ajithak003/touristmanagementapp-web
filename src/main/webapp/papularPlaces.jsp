<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>Popular Places</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	text-decoration: none;
	font-family: Arial, sans-serif;
}

body {
	background-color: rgb(248, 237, 221);
}

h1 {
	color: blue;
	text-align: center;
	font-size: 40px;
}

.firstrowimg {
	top: 400px;
	width: 298px;
	height: 350px;
	border-radius: 10px;
}

.table {
	left: 0px;
	margin-top: 50px;
}

h2 {
	text-align: center;
	font-weight: bold;
	font-size: 35px;
	font-family: Verdana, Geneva, Tahoma, sans-serif;
}

td {
	padding-right: 15px;
	padding-left: 20px;
	padding-bottom: 40px;
}
a{color:blue;}
</style>
</head>

<body>

		<h3>
			<a href="userPage.jsp">Go To Home</a>
		</h3>
		<h1>Popular Places</h1>
		
		<table class="table" aria-describedby="popular places">
		

			<c:forEach begin="0" items="${popularplace}" var="packages"
				varStatus="loop">

				<td>
					<div class="firstrow">
						<a href="singlePackage?location=${packages.getName()}"> <img
							class="firstrowimg" src="Assets/${packages.getImage() }"
							alt="${packages.getName()}">
						</a>

						<h2 name="location">${packages.getName()}</h2>

					</div>
				</td>
				<c:if test="${loop.count%4==0}">
					<tr>
				</c:if>
			</c:forEach>
<th id=""></th>
			</table>
</body>

</html>