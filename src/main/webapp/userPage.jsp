<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>user Page</title>

<link rel='stylesheet' href="assets/css/userPage.css">

</head>

<body>



	<h1>Tourist Management</h1>
	<span>welcome <c:out value="${sessionScope.welcom }" />

	</span>
	<br>

	<div id="link">
		<ul>
			<li><a href="#">Home</a></li>
			<li><a href="papularPlaces">Book Package</a></li>
			<li><a href="papularPlaces">Popular Places</a></li>
			<li><a href="showAllBooking">My Booking</a></li>
			<li><a>More</a>
				<ul>
					<li><a href="profile.jsp">Profile</a></li>
					<li><a href="wallet"> Wallet Topup</a>
					<li>
				</ul></li>
			<li><a href="userRating">Ratings</a></li>
			<li><a href="logout">Logout</a></li>
		</ul>
	</div>


	<br>
	<br>

</body>

</html>