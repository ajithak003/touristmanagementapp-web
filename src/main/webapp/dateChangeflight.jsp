<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>date change feature plane</title>
<style>
body {
	background-color: aliceblue;
}

h1 {
	color: darkred;
	text-align: center;
	font-size: 50px;
	font-weight: bold;
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
}

.container {
	border: 3px solid;
	border-radius: 20px;
	height: 350px;
}

h2 {
	color: blue;
	margin-left: 250px;
	margin-top: 20px;
	font-size: 40px;
}

h3 {
	font-size: 24px;
}

img {
	width: 300px;
	height: 100px;
	margin-left: 490px;
	margin-top: -10px;
}

.depature {
	margin-left: 20px;
	position: relative;
	top: -70px;
}

.place {
	position: relative;
	top: 22pxpx;
}

.date {
	margin-left: 160px;
	margin-top: -50px;
	word-spacing: 15px;
	color: rgba(255, 217, 0, 0.925);
}

.destinations {
	margin-left: 900px;
	position: relative;
	top: -120px;
}

#button {
	margin-left: 1050px;
	width: 150px;
	height: 40px;
	border-radius: 30px;
	border: none;
	background-color: blue;
	color: white;
	font-size: 20px;
	font-weight: bold;
	position: relative;
	top: -100px;
}

.price {
	position: relative;
	top: -100px;
	margin-left: 50px;
	font-size: 20px;
	font-weight: bold;
}

span {
	color: darkorange;
}

#Economic {
	position: relative;
	left: 30px;
}

.flightno {
	visibility: hidden;
}
</style>

</head>
<body>

	<form action="confirmdatechange">
		<div>
			<h1>Flights</h1>
			
		<c:set var="bookingpackage" scope="session" value="${sessionScope.datechangebookings}"/> 
		
		<c:forEach items="${datechangeflightlist}"  var="flight" >
		
		
			
			<c:if test="${flight.getBusinessClassSeat()>=bookingpackage.getNoOfPerson() or flight.getEconomicClassSeat()>=bookingpackage.getNoOfPerson()}">	
		

			<div class="container">
				<h2>${flight.getFlightName()}</h2>
				<div>
					<img src="https://pngimg.com/uploads/plane/plane_PNG5248.png"
						alt="">
				</div>
				<div class="depature">

					<h3 class="place">${flight.getDepature()}</h3>
					<fmt:parseDate value="${flight.getDepatureDateTime()}" pattern="yyyy-MM-dd'T'HH:mm" var="DepatureDateTime" type="both" />
					<h3 class="date"><fmt:formatDate pattern="dd/MM/yyyy HH:mm"	value="${DepatureDateTime}" /></h3>
				</div>
				<div class="destinations">
					
					<h3 class="place" name="destination">${flight.getDestination()}</h3>
					<fmt:parseDate value="${flight.getArrivalDateTime()}" pattern="yyyy-MM-dd'T'HH:mm" var="ArrivalDateTime" type="both" />
					<h3 class="date"><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${ArrivalDateTime}" /></h3>
				</div>
				<div class="price">

					<p>
						<c:if test="${bookingpackage.getFlightClass().equalsIgnoreCase('business class')}">
            
            <c:if test="${flight.getBusinessClassSeat()>=bookingpackage.getNoOfPerson()}">
						<input type="radio" name="price" id="Business"
							value="${flight.getBusinessClassFare()}" required><label
							for="">Business Class <span>${flight.getBusinessClassFare() }></span></label>
						</c:if>
						</c:if>
					</p>

					<p>
						<c:if test="${bookingpackage.getFlightClass().equalsIgnoreCase('economic class')}">
            
            <c:if test="${flight.getBusinessClassSeat()>=bookingpackage.getNoOfPerson()}">
						<input type="radio" name="price" id="Business"
							value="${flight.getEconomicClassFare()}" required><label
							for="">Economic Class <span>${flight.getEconomicClassFare()}</span></label>
						</c:if>
						</c:if>
					</p>

				</div>
				<div class="btn">
					<button id="button" name="flightno"
						value="${flight.getFlightNo()}">Book flight</button>
				</div>

			</div>
			</c:if>
			<br>
			<br>
			</c:forEach>
			
		</div>

	</form>

</body>
</html>