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

<link rel='stylesheet' href="assets/css/popularPlaces.css">

</head>

<body>

	<h3>
		<a href="userPage.jsp">Go To Home</a>
	</h3>
	<h1>Popular Places</h1>

	<table class="table" aria-describedby="popular places">


		<c:forEach begin="0" items="${popularplace}" var="packages"
			varStatus="loop">
			<c:if test="${packages.getStatus().equals('active') }">
				<td>
					<div class="firstrow">
						<a href="singlePackage?location=${packages.getName()}"> <img
							class="firstrowimg" src="assets/images/${packages.getImage() }"
							alt="${packages.getName()}" width = "298px" height = "350px">
						</a>

						<h2 name="location">${packages.getName()}</h2>

					</div>
				</td>
				<c:if test="${loop.count%4==0}">
					<tr>
				</c:if>
			</c:if>
		</c:forEach>
		<th id=""></th>
	</table>
</body>

</html>