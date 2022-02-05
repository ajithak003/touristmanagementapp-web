<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="icon" type="" href="Assets/logo.png">
<title>Ratings</title>

<style>
* {
	margin: 0;
	padding: 0;
}

h1 {
	text-align: center;
	color: blue;
	font-size: 40px;
	font-family: sans-serif;
	margin-top: 20px;
}

.rate {
	position: absolute;
	margin-left: 500px;
	margin-top: 100px;
	height: 46px;
	padding: 0 10px;
	border: none;
	border-radius: 20px;
}

.rate:not(:checked)>input {
	position: absolute;
	top: -9999px;
}

.rate:not(:checked)>label {
	float: right;
	width: 1em;
	overflow: hidden;
	white-space: nowrap;
	cursor: pointer;
	font-size: 80px;
	color: #ccc;
}

.rate:not(:checked)>label:before {
	content: '\2605';
}

.rate>input:checked ~ label {
	color: #15ff00;
}

.rate:not(:checked)>label:hover, .rate:not(:checked)>label:hover ~ label
	{
	color: #00e1ff;
}

.rate>input:checked+label:hover, .rate>input:checked+label:hover ~ label,
	.rate>input:checked ~ label:hover, .rate>input:checked ~ label:hover ~
	label, .rate>label:hover ~ input:checked ~ label {
	color: #fffb00;
}

textarea {
	position: relative;
	margin-top: 230px;
	margin-left: 490px;
	height: 100px;
	width: 450px;
	border: 3px solid;
}

textarea, :placeholder-shown {
	font-size: 25px;
}

button {
	position: absolute;
	left: 900px;
	height: 40px;
	width: 120px;
	border: none;
	border-radius: 150px;
	background-color: rgb(196, 221, 243);
	font-size: 20px;
	font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS',
		sans-serif;
	color: black;
	font-weight: bold;
}
a{
text-decoration: none;
color: blue;
}
</style>

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