<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>user Page</title>

<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>

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
	
	<script src="assets/js/popUpMessages.js"></script>

	<c:if test="${param.rated!=null}">
		<script type="text/javascript">
			popupMessages('Thanks For Your Rating')
		</script>
	</c:if>

	<c:if test="${param.errormsg!=null}">
		<script type="text/javascript">
			popupMessages('can not be rated ! please try again')
		</script>
	</c:if>
	

</body>

</html>