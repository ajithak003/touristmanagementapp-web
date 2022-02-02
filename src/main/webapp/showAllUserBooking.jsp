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

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>

<style>


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
table {
	
	background-color: silver;
}
 th{
background:silver;;
  color:black;
  border: 1px solid;
	border-collapse: collapse;
}
td{
border: 1px solid;
	border-collapse: collapse;
}
</style>

</head>
<body>

	<h2>
		<a href="adminPage.jsp">Go To Home</a>
	</h2>

	<h1>Show All Booking</h1>


	<table aria-describedby="Show All User Booking" id="table_id" class="cell-border"  style="width:100%" >
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
         
		<tr>
					<td>${loop.count}</td>
					<td>${booking.getUser().getId()}</td>
					<td>${booking.getUser().getName()}</td>
					<td>${booking.getPackageName()}</td>
					<td>${booking.getStartDate()}</td>
					<td>${booking.getEndDate()}</td>
					<td>${booking.getNoOfPerson()}</td>
					<td>${booking.getDaysPlan()}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm"
							value="${bookingdate}" /></td>
					<td>${booking.getFlightClass()}</td>
					<td>${booking.getHotel().getHotelName()}</td>
					<td>${booking.getHotelRoomType()}</td>
					<td>${booking.getTotalPrice()}</td>
					<td>${booking.getPayment()}</td>
					<td>${booking.getStatus()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
		$(document).ready(function() {
			$('#table_id').DataTable();
		});
		
	</script>
</body>
</html>