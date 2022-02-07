<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>showAllPlaces</title>

<link rel='stylesheet' href="assets/css/popularPlaces.css">

</head>

<body>

	<div class="second">
		<h3>
			<a href="index.jsp">Go To Home</a>
		</h3>

		<h1>Popular Places</h1>

		<table class="table" aria-describedby="Show All home places">
			<c:forEach begin="0" items="${showAllHomePlaces}" var="packages"
				varStatus="loop">

				<td>
					<div class="firstrow">
						<img class="firstrowimg"
							src="assets/images/${packages.getImage() }"
							alt="${packages.getName()}" width="298px" height="350px">


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