<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>ahowAllHotels</title>

<style>
table {
	border: 2px solid;
	border-collapse: collapse;
	background-color: rgb(235, 206, 194);
	margin-left: 18%;
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
</style>
</head>
<body>

	<h2>
		<a href="adminPage.jsp">Go To Home</a>
	</h2>

	<h1>Show All Hotels</h1>

	<br>
	<br>

	<table aria-describedby="Show All Hotels">

		<th id="">Hotel Id</th>
		<th id="">Hotel Name</th>
		<th id="">Hotel Location</th>
		<th id="">Standard Room Price</th>
		<th id="">Premium Room Price</th>
		<th id="">Action</th>
		<th id="">Action</th>

        <c:forEach items="${showalladminhotel}" var="hotel">

		<tr>
			<td>${hotel.getHotelId()}</td>
			<td>${hotel.getHotelName()}</td>
			<td>${hotel.getLocation()}</td>
			<td>${hotel.getMidRangePrice()}</td>
			<td>${hotel.getPremiumPrice()}</td>
			<td><a href="updateHotel?hotelid=${hotel.getHotelId()}">Edit</a></td>
			<td><a href="deleteHotel?hotelid=${hotel.getHotelId()}">Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>