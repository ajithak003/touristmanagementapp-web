<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>date change feature plane</title>

<link rel='stylesheet' href="assets/css/allFlights.css">

</head>
<body>

	<form action="confirmdatechange">
		<div>
			<h1>Flights</h1>

			<c:set var="bookingpackage" scope="session"
				value="${sessionScope.datechangebookings}" />

			<c:if test="${empty datechangeflightlist}">
				<br>
				<br>
				<p class="noflight">No Flights Available
				<p>
			</c:if>

			<c:forEach items="${datechangeflightlist}" var="flight">

				<c:if
					test="${flight.getBusinessClassSeat()>=bookingpackage.getNoOfPerson() or flight.getEconomicClassSeat()>=bookingpackage.getNoOfPerson()}">

					<div class="container">
						<h2>${flight.getFlightName()}</h2>
						<div>
							<img src="https://pngimg.com/uploads/plane/plane_PNG5248.png"
								alt="flight png" width="300px" height="100px">
						</div>
						<div class="depature">

							<h3 class="place">${flight.getDepature()}</h3>
							<fmt:parseDate value="${flight.getDepatureDateTime()}"
								pattern="yyyy-MM-dd'T'HH:mm" var="DepatureDateTime" type="both" />
							<h3 class="date">
								<fmt:formatDate pattern="dd/MM/yyyy HH:mm"
									value="${DepatureDateTime}" />
							</h3>
						</div>
						<div class="destinations">

							<h3 class="place" name="destination">${flight.getDestination()}</h3>
							<fmt:parseDate value="${flight.getArrivalDateTime()}"
								pattern="yyyy-MM-dd'T'HH:mm" var="ArrivalDateTime" type="both" />
							<h3 class="date">
								<fmt:formatDate pattern="dd/MM/yyyy HH:mm"
									value="${ArrivalDateTime}" />
							</h3>
						</div>
						<div class="price">

							<p>
								<c:if
									test="${bookingpackage.getFlightClass().equalsIgnoreCase('business class')}">

									<c:if
										test="${flight.getBusinessClassSeat()>=bookingpackage.getNoOfPerson()}">
										<input type="radio" name="price" id="Business"
											value="${flight.getBusinessClassFare()}" required
											title="please select" aria-label="Business Class">
										<label for="Business Class">Business Class <span>Rs.
												${flight.getBusinessClassFare()}</span></label>
									</c:if>
								</c:if>
							</p>

							<p>
								<c:if
									test="${bookingpackage.getFlightClass().equalsIgnoreCase('economic class')}">

									<c:if
										test="${flight.getBusinessClassSeat()>=bookingpackage.getNoOfPerson()}">
										<input type="radio" name="price" id="Economic"
											value="${flight.getEconomicClassFare()}" required
											title="please select" aria-label="Economic Class">
										<label for="Economic Class">Economic Class <span>Rs.
												${flight.getEconomicClassFare()}</span></label>
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