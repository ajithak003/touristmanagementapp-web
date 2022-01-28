<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>showAllFlight</title>

<style>
table {
	border: 2px solid;
	border-collapse: collapse;
	background-color: silver;
}

tr, td, th {
	border: 1px solid;
	border-collapse: collapse;
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
</style>

</head>
<body>

	<h2>
		<a href="adminPage.jsp">Go To Home</a>
	</h2>
	<h1>Show All Flight</h1>

	<br>
	<br>
	<table aria-describedby="Show All Flight">
		<th id="">Flight No</th>
		<th id="">Flight Name</th>
		<th id="">Departure</th>
		<th id="">Destination</th>
		<th id="">Departure Date And Time</th>
		<th id="">Arrival Date And Time</th>
		<th id="">Business Class Fare</th>
		<th id="">Economic Class Fare</th>
		<th id="">Status</th>
		<th id="">Business Class Seats Status</th>
		<th id="">Economic Class Seat Status</th>
		<th id="">Action</th>
		<th id="">Action</th>

       <c:forEach items="${showalladminflight}" var="singleFlight">
       
	<fmt:parseDate value="${singleFlight.getDepatureDateTime()}" pattern="yyyy-MM-dd'T'HH:mm" var="DepartureDateTime" type="both" />
	<fmt:parseDate value="${singleFlight.getArrivalDateTime()}" pattern="yyyy-MM-dd'T'HH:mm" var="ArrivalDateTime" type="both" />
	
		<tr>
			<td>${singleFlight.getFlightNo()}</td>
			<td>${singleFlight.getFlightName()}</td>
			<td>${singleFlight.getDepature()}</td>
			<td>${singleFlight.getDestination()}</td>
			<td><fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${DepartureDateTime}" /></td>
			<td><fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${ArrivalDateTime}" /></td>
			<td>${singleFlight.getBusinessClassFare()}</td>
			<td>${singleFlight.getEconomicClassFare()}</td>
			<td>${singleFlight.getStatus()}</td>
			<td>${singleFlight.getBusinessClassSeat()}</td>
			<td>${singleFlight.getEconomicClassSeat()}</td>
			<td><a
				href="updateFlight?flightno=${singleFlight.getFlightNo()}">Edit</a></td>
			<td><a
				href="deleteFlight?flightno=${singleFlight.getFlightNo()}">Delete</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>