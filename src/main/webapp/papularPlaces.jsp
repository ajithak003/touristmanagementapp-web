<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	position: absolute;
	top: 300px;
	left: 30%;
	background-color: black;
	border-radius: 25%;
	color: white;
}

.firsrrow {
	padding-left: 20%;
}

.firstrowimg {
	top: 400px;
	width: 298px;
	height: 350px;
	border-radius: 10px;
}

.table {
	left: 0px;
}

h2 {
	text-align: center;
	font-weight: bold;
	font-size: 35px;
	font-family: Verdana, Geneva, Tahoma, sans-serif;
}

</style>
</head>

<body>

		<h3>
			<a href="userPage.jsp">Go To Home</a>
		</h3>
		<table cellspacing="30px" cellpadding="1000px" class="table">

			<c:forEach begin="0" items="${popularplace}" var="packages"
				varStatus="loop">

				<c:if test="${loop.count%5==0}">
					<tr>
				</c:if>

				<td>
					<div class="firstrow">
						<a href="singlePackage?location=${packages.getName()}"> <img
							class="firstrowimg" src="Assets/${packages.getImage() }"
							alt="${packages.getName()}">
						</a>

						<h2 name="location">${packages.getName()}</h2>

					</div>
				</td>
			</c:forEach>

			
</body>

</html>