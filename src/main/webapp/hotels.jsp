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

<link rel='stylesheet' href="assets/css/hotels.css">

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
          <c:if test="${hotel.getStatus().equals('active')}">
			<div class="container">
				<div>
					<img src="assets/images/${hotel.getImage()}"
						alt="${hotel.getHotelName()}, ${hotel.getLocation()}" width = "400px" height = "350px">
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
								for="">Normal Room <span> Rs. ${hotel.getMidRangePrice()}</span></label>

							<input type="radio" name="hotelprice" id="Premium"
								value="${hotel.getPremiumPrice()}" required><label
								for="" id="Premium">Premium Room <span> Rs. ${hotel.getPremiumPrice()}</span></label>

						</p>
					</div>
					<button id="button" name="hotelid" value="${hotel.getHotelId()}">Book
						hotel</button>
				</div>

			</div>
			</c:if>
			<br>
			<br>
		</c:forEach>

	</form>
</body>
</html>