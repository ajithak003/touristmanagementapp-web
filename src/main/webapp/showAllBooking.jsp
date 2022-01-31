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

<style>
body {
	background-color: rgb(229, 236, 236);
}

h1 {
	text-align: center;
	font-size: 30px;
	font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS',
		sans-serif;
	font-weight: bold;
	color: red;
}

.box {
	border: 3px solid;
	height: 450px;
	width: 750px;
	margin-left: 290px;
	border-radius: 20px;
}

.title {
	margin-left: 220px;
	font-size: 30px;
	font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS',
		sans-serif;
	font-weight: bold;
	color: black;
	margin-top: -20px;
}

.status {
	color: rgb(3, 194, 3);
	font-size: 20px;
	font-family: 'Times New Roman', Times, serif;
	float: right;
	position: relative;
	right: 60px;
	top: -100px;
}

.textdate {
	font-size: 20px;
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
	margin-left: 20px;
	margin-top: -50px;
	color: blue;
}

#dd {
	margin-left: 62px;
	font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
	font-size: 40px;
	font-weight: bold;
	margin-top: -20px;
	color: darkgoldenrod;
}

#mm {
	margin-left: 57px;
	font-size: 30px;
	margin-top: -30px;
	color: red;
}

#yyyy {
	margin-left: 50px;
	font-size: 30px;
	font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS',
		sans-serif;
	margin-top: -20px;
	color: green;
}

.location {
	margin-left: 200px;
	margin-top: -160px;
	font-size: 25px;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	color: blue;
}

.hotel {
	margin-left: 200px;
	font-size: 20px;
}

.price {
	margin-left: 200px;
	font-size: 20px;
}

.days {
	margin-left: 200px;
	font-size: 20px;
	color: green;
}

.cancel {
	height: 40px;
	width: 120px;
	margin-left: 70px;
	margin-top: 20px;
	border-radius: 15px;
	background-color: red;
	color: floralwhite;
	font-size: 20px;
	font-weight: bold;
	border: none;
}

a {
	text-decoration: none;
	color: floralwhite;
}

.datechange {
	height: 40px;
	width: 150px;
	margin-left: 340px;
	border-radius: 15px;
	background-color: midnightblue;
	color: floralwhite;
	font-size: 20px;
	font-weight: bold;
}

.rate {
	height: 40px;
	width: 150px;
	position: relative;
	margin-left: 530px;
	top: 20px;
	border-radius: 15px;
	background-color: midnightblue;
	color: floralwhite;
	font-size: 20px;
	font-weight: bold;
	border: none;
}

.see {
	text-align: center;
}

.see, span {
	color: black;
}

#totprice {
	color: green;
}
</style>

</head>

<body>

	<div class="container">
		<h2>
			<a href="userPage.jsp">Go To Home</a>
		</h2>
		<div>
			<h1>My Trips</h1>

			<br> <br>

			<c:forEach items="${userallbooking}" var="singlebooking">

				<jsp:useBean id="rating"
					class="com.touristMgntApp.daoImpl.RatingDaoImplement" />


				<jsp:useBean id="cancel"
					class="com.touristMgntApp.daoImpl.BookingTableDaoImplement" />


				<form>

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
								No Of Days : <span>${singlebooking.getDaysPlan()}<span>
							</h2>
						</div>
						<div class="days">
							<h2>
								Total price &nbsp;: <span id="totprice">${singlebooking.getTotalPrice()}</span>
							</h2>
						</div>
						</table>

						<div>
							<c:if test="${cancel.endDateCheck(singlebooking)==false and singlebooking.getStatus().equals('confirmed')}">

                                 
								<button class="cancel" onclick="check()">
									<a href="cancelTrip?bookingid=${singlebooking.getBookingId()}">
										Cancel</a>
								</button>

								

									<button class="datechange">
										<a href="terms?bookingid=${singlebooking.getBookingId()}">Change
											Date</a>
									</button>
								
							</c:if>
							
							<c:if
								test="${singlebooking.getStatus().equals('confirmed') and rating.endDateCheck(singlebooking)==true}">
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
					</form>
					<br> <br>
			</c:forEach>

		</div>
	</div>
	<script>
		function check() {
			var result = confirm("if you want to cancel 10% cancelation charge will be detected on your total price");

			if (result == false) {
				event.preventDefault();
			}
		}
	</script>

</body>
</html>