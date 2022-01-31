<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
	width: 300px;
	height: 350px;
	border-radius: 10px;
}

.table {
	left: 10px;
}

h2 {
	text-align: center;
	font-weight: bold;
	font-size: 35px;
	font-family: Verdana, Geneva, Tahoma, sans-serif;
}
td {
	padding-right: 15px;
	padding-left:18px;
	
}

</style>
</head>

<body>

	<div class="second">
		<h3>
			<a href="index.jsp">Go To Home</a>
		</h3>
		<table  class="table" aria-describedby="Show All home places">

			<c:forEach begin="0" items="${showAllHomePlaces}" var="packages"
				varStatus="loop">

				<c:if test="${loop.count%5==0}">
					<tr>
				</c:if>

				<td>
					<div class="firstrow">
						<img class="firstrowimg" src="Assets/${packages.getImage() }"
							alt="${packages.getName()}">


						<h2 name="location">${packages.getName()}</h2>

					</div>
				</td>
			</c:forEach>
			<th id=""></th>
		</table>

	</div>
<body>

</body>

</html>