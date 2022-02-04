<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>showAllPlaces</title>

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

.slideimg {
	position: sticky;
	width: 80%;
	height: 400px;
	left: 10%;
}

.prev {
	position: absolute;
	left: 12%;
	top: 150px;
	font-size: x-large;
}

.next {
	position: absolute;
	left: 86%;
	top: 150px;
	right: 20px;
	font-size: x-large;
}

.next:hover, .prev:hover {
	height: 15x;
	width: 10px;
	background-color: gray;
}

h1 {
	color:blue;
	text-align: center;
	font-size: 40px;
}

a{
color:blue;
}

.firsrrow {
	padding-left: 20%;
}

.firstrowimg {
	top: 400px;
	width: 300px;
	height: 350px;
	border-radius: 10px;
}

.table {
	left: 10px;
	margin-top: 50px;
}

h2 {
	text-align: center;
	font-weight: bold;
	font-size: 35px;
	font-family: Verdana, Geneva, Tahoma, sans-serif;
}

second {
	border: 3px solid;
}
td {
	padding-right: 15px;
	padding-left:18px;
	padding-bottom: 40px;
}
</style>
</head>

<body>

	<div class="second">
	
		<h3>
			<a href="adminPage.jsp">Go To Home</a>
		</h3>
		 
		 <h1>Popular Places</h1>
		 
		<table class="table" aria-describedby="Show All places">

			<c:forEach begin="0" items="${showAllPlaces}" var="packages"
				varStatus="loop">

				<td>
					<div class="firstrow">
						<img class="firstrowimg" src="assets/images/${packages.getImage() }"
							alt="${packages.getName()}">


						<h2 name="location">${packages.getName()}</h2>
						

					</div>
				</td>
				<c:if test="${loop.count%4==0}">
					<tr>
				</c:if>
				
			</c:forEach>
        <th id=""></th>
		</table>

	</div>
<body>

</body>

</html>