<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>Show All Bookings</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>

<link rel='stylesheet' href="assets/css/showAllUserBooking.css">

</head>
<body>

	<h2>
		<a href="adminPage.jsp">Go To Home</a>
	</h2>

	<h1>Show All Booking</h1>


	<table aria-describedby="Show All User Booking" id="table_id"
		class="cell-border" style="width: 70%">
		<thead class="table-dark">
			<th id="">Sl.No</th>
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
			<th id="">Total Price (Rs)</th>
			<th id="">Payment Details</th>
			<th id="">Booking Status</th>

		</thead>
		<tbody>
			<c:forEach begin="0" items="${showalluserbooking}" var="booking"
				varStatus="loop">
				<fmt:parseDate value="${booking.getBookingDate()}"
					pattern="yyyy-MM-dd'T'HH:mm" var="bookingdate" type="both" />
				<fmt:parseDate value="${booking.getStartDate()}"
					pattern="yyyy-MM-dd" var="startdate" type="both" />
				<fmt:parseDate value="${booking.getEndDate()}"
					pattern="yyyy-MM-dd" var="enddate" type="both" />

				<tr>
					<td>${loop.count}</td>
					<td>${booking.getUser().getId()}</td>
					<td>${booking.getUser().getName()}</td>
					<td>${booking.getPackageName()}</td>
					<td><fmt:formatDate pattern="dd/MM/yy"
							value="${startdate}" /></td>
					<td><fmt:formatDate pattern="dd/MM/yy"
							value="${enddate}" /></td>
					<td>${booking.getNoOfPerson()}</td>
					<td>${booking.getDaysPlan()}</td>
					<td><fmt:formatDate pattern="dd/MM/yy HH:mm"
							value="${bookingdate}" /></td>
					<td>${booking.getFlightClass()}</td>
					<td>${booking.getHotel().getHotelName()}</td>
					<td>${booking.getHotelRoomType()}</td>
					<td>${booking.getTotalPrice()}</td>
					<td>${booking.getPayment()}</td>
					<td><c:if test="${booking.getStatus().equals('confirmed') }">
							<span class="badge badge-pill badge-success">${booking.getStatus()}</span>
						</c:if> <c:if test="${booking.getStatus().equals('cancel') }">
							<span class="badge badge-pill badge-danger">${booking.getStatus()}</span>
						</c:if></td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<script src="assets/js/dataTable.js"></script>
	
</body>
</html>