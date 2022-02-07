<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>Confirm Booking</title>

<link rel='stylesheet' href="assets/css/showSingleBooking.css">

</head>
<body>



	<form action="">

		<h1>Booking Details</h1>

		<c:set var="booking" scope="session" value="${singlebookingdetails}" />
		<c:set var="flightfare" scope="session"
			value="${singlebookingflightfare}" />
		<c:set var="noOfHotelRooms" scope="session"
			value="${singlebookingnoofhotelroom}" />
		<c:set var="hotelfare" scope="session"
			value="${singlebookinghotelfare}" />


		<div class="container">
			<table aria-describedby="single booking details">
				<tr>
					<th id="">
						<h2>User Details</h2>
					</th>
				</tr>
				<br>

				<td>User Name :</td>
				<td>${booking.getUser().getName()}</td>

				<tr>
					<td>User Email Id :</td>
					<td>${booking.getUser().getEmail()}</td>

				</tr>

				<tr>
					<th id=""><h2>Package Details</h2></th>
				</tr>
				<br>
				<td>Tour place :</td>
				<td>${booking.getPackages().getName()}</td>
				</tr>
				<tr>
					<td>one Day Night Price / person :</td>
					<td>Rs. ${booking.getPackages().getPriceOneDays()}</td>
				</tr>
				<tr>
					<td>No Of Person :</td>
					<td>${booking.getNoOfPerson()}</td>
				</tr>
				<tr>
					<td>No Of Days in Night :</td>
					<td>${booking.getDaysPlan()}</td>
				</tr>
				<tr>
					<td>Tour Start Date :</td>
					<td>${booking.getStartDate()}</td>
				</tr>

				<tr>
					<th id="">
						<h2>Flight Details</h2>
					</th>
				</tr>
				<br>
				<td>Flight Name :</td>
				<td>${booking.getFlight().getFlightName()}</td>
				</tr>
				<tr>
					<td>departure place :</td>
					<td>${booking.getFlight().getDepature()}</td>
				</tr>
				<tr>
					<td>destination place :</td>
					<td>i${booking.getFlight().getDestination()}</td>
				</tr>
				<tr>
					<td>Departure Date And Time Name :</td>
					<fmt:parseDate value="${booking.getFlight().getDepatureDateTime()}"
						pattern="yyyy-MM-dd'T'HH:mm" var="DepatureDateTime" type="both" />

					<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm"
							value="${DepatureDateTime}" /></td>
				</tr>
				<tr>
					<td>Arrival Date And Time Name :</td>
					<fmt:parseDate value="${booking.getFlight().getArrivalDateTime()}"
						pattern="yyyy-MM-dd'T'HH:mm" var="ArrivalDateTime" type="both" />
					<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm"
							value="${ArrivalDateTime}" /></td>
				</tr>
				<tr>
					<td>Class :</td>
					<td>${booking.getFlightClass()}</td>
				</tr>
				<tr>
					<td>Ticket Price :</td>
					<td>Rs. ${flightfare}</td>
				</tr>

				<tr>
					<th id="">
						<h2>Hotel Details</h2>
					</th>
				</tr>
				<td>Hotel Name :</td>
				<td>${booking.getHotel().getHotelName()}</td>
				</tr>
				<tr>
					<td>Hotel Location :</td>

					<td>${booking.getHotel().getLocation()}</td>
				</tr>
				<tr>
					<td>Room Type :</td>
					<td>${booking.getHotelRoomType()}</td>
				</tr>
				<tr>
					<td>Hotel One Day Night Price :</td>
					<td>Rs. ${hotelfare}</td>
				</tr>
				<tr>
					<td>No Of Room :</td>
					<td>${noOfHotelRooms}Room</td>
				</tr>

				<tr>
					<td>Booking Date :</td>
					<fmt:parseDate value="${booking.getBookingDate()}"
						pattern="yyyy-MM-dd'T'HH:mm" var="bookingdate" type="both" />
					<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm"
							value="${bookingdate}" /></td>
				</tr>

				<tr>
					<td><h3>Package Total Price</h3></td>
					<td><h3>Rs. ${booking.getTotalPrice()}</h3></td>
				</tr>
			</table>


		</div>
	</form>
</body>
</html>