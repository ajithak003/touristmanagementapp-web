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
<title>Show all bookings</title>
<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>

<link rel='stylesheet' href="assets/css/showAllBooking.css">

</head>

<body>

	<div class="container">
		<h2>
			<a href="userPage.jsp" id="home">Go To Home</a>
		</h2>
		<div>
			<h1>My Trips</h1>

			<br> <br>

			<c:forEach items="${userallbooking}" var="singlebooking">

					<div class="box">
						<div class="title">
							<h3>${singlebooking.getPackageName().toUpperCase()}TRIP</h3>
						</div>
						<div class="status">
							<h3>${singlebooking.getStatus()}</h3>
						</div>
						<div class="textdate">
							<h2>Start Date</h2>
						</div>
						<div class="date">
							<h2 id="dd">${singlebooking.getStartDate().getDayOfMonth()}</h2>

							<fmt:parseDate value="${singlebooking.getStartDate()}"
								pattern="yyyy-MM-dd" var="singlebookingmonth" type="both" />
							<h2 id="mm">
								<fmt:formatDate pattern=" MMM " value="${singlebookingmonth}" />
							</h2>

							<h2 id="yyyy">${singlebooking.getStartDate().getYear()}</h2>
						</div>

						<div class="location">
							<h2>${singlebooking.getFlight().getDepature()}-
								${singlebooking.getFlight().getDestination()}</h2>
						</div>
						<div class="hotel">

							<h2>
								Hotel Name : <span>${singlebooking.getHotel().getHotelName()}</span>
							</h2>
						</div>
						<div class="price">

							<h2>
								No Of Days : <span>${singlebooking.getDaysPlan()}</span>
							</h2>
						</div>
						<div class="days">
							<h2>
								Total price &nbsp;: <span id="totprice">Rs. ${singlebooking.getTotalPrice()}</span>
							</h2>
						</div>
						

						<div>
							<c:if test="${singlebooking.isCancel()==false and singlebooking.getStatus().equals('confirmed')}">
								
								<button class="cancel" onclick="cancelBooking(${singlebooking.getBookingId()})">Cancel</button>

									<button class="datechange">
										<a href="terms?bookingid=${singlebooking.getBookingId()}">Change
											Date</a>
									</button>
								
							</c:if>
							
							<c:if
								test="${singlebooking.getStatus().equals('confirmed') and singlebooking.isRating()}">
								<button class="rate">
									<a href="rating?bookingid=${singlebooking.getBookingId()}">Rate
										Now</a>
								</button>
							</c:if>
						</div>
					</div>
					<h3 class="see">
						<a
							href="showSingleBooking?bookingid=${singlebooking.getBookingId()}"><span>SEE
								DETAILS</span></a>
					</h3>
					<br> <br>
			</c:forEach>

		</div>
	</div>
	<script src="assets/js/popUpMessages.js"></script>
</body>
</html>