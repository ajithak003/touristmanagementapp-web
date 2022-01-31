<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>Show All Bookings</title>

<style>
table {
	border: 2px solid;
	border-collapse: collapse;
	background-color: mintcream;
}

tr, td, th {
	border: 2px solid;
	text-align: center;
	padding: 10px;
}

a {
	text-decoration: none;
}

h1 {
	text-align: center;
	font-size: 50px;
	color: steelblue
}

h2 {
	margin-left: 20px;
}
</style>

</head>
<body>

	<h2>
		<a href="adminPage.jsp">Go To Home</a>
	</h2>

	<h1>Show All Booking</h1>

	<br>
	<br>


	<table aria-describedby="Show All User Booking">
	

		<th id="">User Id</th>
		<th id="">User Name</th>
		<th id="">Package Name</th>
		<th id="">Tour Start Date</th>
		<th id="">Tour End Date</th>
		<th id="">Number Of Person</th>
		<th id="">No Of Days In Night</th>
		<th id="">Booking Date</th>
		<th id="">Flight Seat Class</th>
		<th id="">Hotel Name</th>
		<th id="">Hotel Room Type</th>
		<th id="">Total Price</th>
		<th id="">Payment Details</th>
		<th id="">Booking Status</th>

        
        <c:forEach items="${showalluserbooking}" var="booking">
          <fmt:parseDate value="${booking.getBookingDate()}" pattern="yyyy-MM-dd'T'HH:mm" var="bookingdate" type="both" />
		<tr>
			<td>${booking.getUser().getId()}</td>
			<td>${booking.getUser().getName()}</td>
			<td>${booking.getPackageName()}</td>
			<td>${booking.getStartDate()}</td>
			<td>${booking.getEndDate()}</td>
			<td>${booking.getNoOfPerson()}</td>
			<td>${booking.getDaysPlan()}</td>
			<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${bookingdate}" /></td>
			<td>${booking.getFlightClass()}</td>
			<td>${booking.getHotel().getHotelName()}</td>
			<td>${booking.getHotelRoomType()}</td>
			<td>${booking.getTotalPrice()}</td>
			<td>${booking.getPayment()}</td>
			<td>${booking.getStatus()}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>