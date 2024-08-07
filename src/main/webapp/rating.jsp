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

	<form id="rating-form" action="ratings" method="post">

		<c:set var="bookingId" scope="session" value="${ratingbookingid}" />

		<div class=rating>
		<span class="star"  data-value="5">&#9733;</span>
        <span class="star"  data-value="4">&#9733;</span>
        <span class="star"  data-value="3">&#9733;</span>
        <span class="star"  data-value="2">&#9733;</span>
        <span class="star"  data-value="1">&#9733;</span>
		</div>
		<br>
		<textarea name="describe" id="" cols="30" rows="10"
			aria-label="description" placeholder="Describe your experience"
			title="must contain character and numbers only minimum 3 characters or numbers"></textarea>
			<br> <br>
			<p id="rating-value"></p>
			 <!-- Hidden input field to store the selected rating value -->
             <input type="hidden" id="selected-rating" name="rate" value="">
			
		<br> <br> <br>
		<button id="submit-rating" name="bookingId" value="${bookingId}">Rate Now</button>
		 
	</form>
</body>

<script src="assets/js/rating.js"></script>

</html>