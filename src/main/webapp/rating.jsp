<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="icon" type="" href="Assets/logo.png">
<title>Ratings</title>

<link rel='stylesheet' href="assets/css/rating.css">

</head>

<body>

	<h2>
		<a href="userPage.jsp">Go To Home</a>
	</h2>

	<h1>Rate Your Experience</h1>

	<form action="ratings" method="get">

		<c:set var="bookingId" scope="session" value="${ratingbookingid}" />

		<div class="rate">
			<input type="radio" id="star5" name="rate" value="5" required /> <label
				for="star5" title=" Excellent"></label> <input type="radio"
				id="star4" name="rate" value="4" required /> <label for="star4"
				title="very good">4 stars</label> <input type="radio" id="star3"
				name="rate" value="3" required /> <label for="star3" title="Good">3
				stars</label> <input type="radio" id="star2" name="rate" value="2" required />
			<label for="star2" title="Average">2 stars</label> <input
				type="radio" id="star1" name="rate" value="1" required /> <label
				for="star1" title="Bad">1 star</label>
		</div>
		<br>
		<textarea name="describe" id="" cols="30" rows="10"
			placeholder="Describe your experience" pattern="[A-Za-z0-9]{3,}" 
			title="must contain character and numbers only minimum 3 characters or numbers"></textarea>
		<br> <br> <br>
		<button name="bookingId" value="${bookingId}">Rate Now</button>
	</form>
</body>

</html>