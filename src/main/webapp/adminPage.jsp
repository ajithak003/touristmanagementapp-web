<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>AdminPage</title>

<link rel='stylesheet' href="assets/css/adminPage.css">

</head>

<body>


	<h1>Tourist Management</h1>
	<span>Welcome <c:out value="${sessionScope.welcom }" />

	</span>
	<br>


	<div id="link">
		<ul>
			<li><a href="#">Home</a></li>
			<li><a href="showAllPlaces">Popular Places</a></li>
			<li><a>Package</a>
				<ul class="list">
					<li><a href="addPackage.jsp">Add Package</a></li>
					<li><a href="showAllAdminPackages">show all package</a></li>
				</ul></li>


			<li><a>flights</a>
				<ul class="list">
					<li><a href="addFlight.jsp">Add flight</a></li>
					<li><a href="showAllFlight">show all flight</a></li>
				</ul></li>
			<li></li>
			<li><a>Hotels</a>
				<ul class="list">
					<li><a href="addHotel.jsp">Add hotel</a></li>
					<li><a href="showAllHotel">show all hotel</a></li>
				</ul></li>
			<li><a>More</a>
				<ul class="list">
					<li><a href="showAllUserList">View User List</a></li>
					<li><a href="showAllUserBooking">view all booking</a></li>
					<li><a href="adminratings">view all feedback</a></li>
				</ul></li>
			<li><a href="logout">Logout</a></li>

		</ul>



	</div>

</body>
</html>