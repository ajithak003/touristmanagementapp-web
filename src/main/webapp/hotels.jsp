<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>All Hotels</title>


<style>
body {
	background-color: rgb(243, 221, 167);
}

h1 {
	text-align: center;
	font-size: 40px;
	font-family: Verdana, Geneva, Tahoma, sans-serif;
	font-weight: bold;
	color: yellowgreen;
}

.container {
	border: 3px;
	border-style: solid;
	border-radius: 30px;
	padding: 35px;
	height: 350px;
}

img {
	position: relative;
	height: 350px;
	width: 400px;
}

.name {
	position: relative;
	margin-left: 450px;
	margin-top: -325px;
}

.hotelname {
	position: relative;
	margin-left: 300px;
	margin-top: -37px;
}

.location {
	position: relative;
	margin-left: 455px;
	margin-top: 60px;
}

.locationname {
	position: relative;
	margin-left: 300px;
	margin-top: -37px;
}

.radio {
	position: relative;
	top: 50px;
	margin-left: 450px;
	font-size: 20px;
	font-weight: bold;
}

span {
	color: orangered;
}

#Premium {
	position: relative;
	left: 50px;
}

button {
	position: relative;
	top: 70px;
	margin-left: 1050px;
	height: 50px;
	width: 130px;
	background-color: royalblue;
	border-radius: 50px;
	border: none;
	font-size: 18px;
	color: white;
	font-family: monospace;
	font-weight: bold;
}

.nohotel {
	color: darkred;
	text-align: center;
	color: black;
	font-size: 40px;
	font-weight: bold;
}
</style>
</head>
<body>

	<form action="booking">

		<h1>Hotels</h1>
		<br> <br>

		<c:set var="hotels" scope="session" value="${bookingallhotels}" />
		<c:if test="${empty hotels}">
			<br>
			<br>
			<p class="nohotel">No Hotels Available
			<p>
		</c:if>

		<c:forEach items="${hotels}" var="hotel">

			<div class="container">
				<div>
					<img src="Assets/${hotel.getImage()}"
						alt="${hotel.getHotelName()}, ${hotel.getLocation()}">
					<div class="name">
						<h3>Hotel Name :</h3>
						<h3 class="hotelname">${hotel.getHotelName()}</h3>
					</div>
					<div class="location">
						<h3>Location :</h3>
						<h3 class="locationname">${hotel.getLocation()}</h3>
					</div>
					<div class="radio">
						<p>

							<input type="radio" name="hotelprice" id="Normal"
								value="${hotel.getMidRangePrice()}" required><label
								for="">Normal Room <span>${hotel.getMidRangePrice()}</span></label>

							<input type="radio" name="hotelprice" id="Premium"
								value="${hotel.getPremiumPrice()}" required><label
								for="" id="Premium">Premium Room <span>${hotel.getPremiumPrice()}</span></label>

						</p>
					</div>
					<button id="button" name="hotelid" value="${hotel.getHotelId()}">Book
						hotel</button>
				</div>

			</div>
			<br>
			<br>
		</c:forEach>

	</form>
</body>
</html>