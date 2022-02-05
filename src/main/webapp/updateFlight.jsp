<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>update package</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	text-decoration: none;
	font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS',
		sans-serif;
	background-color: azure;
}

h1 {
	text-align: center;
	color: blue;
}

.addpackage {
	border: 3px solid;
	height: 630px;
	width: 45%;
	position: absolute;
	left: 27%;
	padding: 25px;
}

label {
	font-size: 20px;
	font-weight: bolder;
	font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande',
		'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}

input {
	border: 3px solid;
	height: 25px;
	width: 222px;
	font-size: 16px;
	font-weight: bold;
}

input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}

textarea {
	border: 3px solid;
}

button {
	height: 30px;
	width: 150px;
	margin-left: 70%;
	margin-top: 20px;
	border-radius: 20px;
	background-color: yellowgreen;
	font-size: 18px;
	font-family: Georgia, 'Times New Roman', Times, serif;
	font-weight: bold;
	border: none
}

.container {
	height: 830px;
}
td {
	padding-top: 10px;
	padding-bottom: 10px;
}
#home{
text-decoration: none;
color: blue;
}
select{
    border: 3px solid;
	height: 25px;
	width: 222px;
	font-size: 16px;
	font-weight: bold;
}
option{
font-weight: bold;
}
</style>
</head>
<body>

	<div class="container">
	<br>
	<h3><a href="showAllFlight" id="home">Go Back</a></h3>
		<h1>Update Flight</h1>
		<br> <br> <br>

		<c:set var="flight" scope="session" value="${updateflight}" />


		<form action="updateflight" method="post">

			<div class="addpackage">
				<table aria-describedby="update flight">
				<th id=""></th>
					<tr>
						<td><label for="location">Flight Name : </label></td>
						<td><input type="text" name="flightname" id="flightname" autofocus
							value="${flight.getFlightName()}" required pattern="[A-Za-z0-9]{2,}"
							title="must contain and character and numbers only not allowed special character and minimum 2 character or numbers">
						</td>
					</tr>

					<tr>
						<td><label for="depature">Departure Location : </label></td>
						<td><input type="text" name="Depature" id="Depature"
							value="${flight.getDepature()}" required pattern="[A-Za-z]{2,}"
							title="must contain characters only minimum 2 characters"></td>
					</tr>
					<tr>
						<td><label for="destination">destination Location :</label></td>
						<td><input type="text" name="destination" id="destination"
							value="${flight.getDestination()}" required
							pattern="[A-Za-z]{2,}"title="must contain characters only minimum 2 characters">
						</td>
					</tr>
					<tr>
						<td><label for="Departure Date And Time">Departure Date And Time</label></td>
						<td><input type="datetime-local" name="DepatureDate"
							id="date" value="${flight.getDepatureDateTime()}"></td>
					</tr>
					<tr>
						<td><label for="Arrival Date And Time">Arrival Date And Time</label></td>
						<td><input type="datetime-local" name="ArrivalDate"
							id="date" value="${flight.getArrivalDateTime()}"></td>
					</tr>
					<tr>
						<td><label for="Business Class Fare">Business Class Fare :</label></td>
						<td><input type="number" name="businessclassfare" placeholder="Rs. "
							id="businessclassfare" value="${flight.getBusinessClassFare()}"
							 min="600" max="200000" title="must contain number only maximum Rs. 600 minimum Rs. 200000">
						</td>
					</tr>
					<tr>
						<td><label for="Economic Class Fare">Economic Class Fare :</label></td>
						<td><input type="number" name="economicclassfare" placeholder="Rs. "
							id="economicclassfare" value="${flight.getEconomicClassFare()}"
							 min="600" max="200000" title="must contain number only maximum Rs. 600 minimum Rs. 200000">
						</td>
					</tr>

					<tr>
						<td><label for="flight status">Status :</label></td>
						<td>
						<select name="status">
						<option value="available">available</option>
						<option value="unavailable">unavailable</option>
						</select>
						</td>
					</tr>
					<tr>
						<td><label for="Business Class Seats Count ">Business Class Seats Count :</label></td>
						<td><input type="number" name="businessclassseat" id="businessclassseat"
							 value="${flight.getBusinessClassSeat()}" min="50" max="350"
							title="must contain number only maximum 50 minimum 350 number of seats"></td>
					</tr>
					<tr>
						<td><label for="Economic Class Seats Count">Economic Class Seats Count :</label></td>
						<td><input type="number" name="economicclassseat" id="economicclassseat"
							 value="${flight.getEconomicClassSeat()}" min="50" max="350"
							 title="must contain number only maximum 50 minimum 350 number of seats"></td>
					</tr>
				</table>

				<button name="flightno" value="${flight.getFlightNo()}">Update Flight</button>
			</div>
		</form>
	</div>
</body>
</html>