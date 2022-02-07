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

<link rel='stylesheet' href="assets/css/updateFlight.css">

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
						<td><input type="text" name="flightname" id="flightname" autofocus aria-label="location"
							value="${flight.getFlightName()}" required pattern="[A-Za-z0-9]{2,}"
							title="must contain and character and numbers only not allowed special character and minimum 2 character or numbers">
						</td>
					</tr>

					<tr>
						<td><label for="depature">Departure Location : </label></td>
						<td><input type="text" name="Depature" id="Depature" aria-label="depature"
							value="${flight.getDepature()}" required pattern="[A-Za-z]{2,}"
							title="must contain characters only minimum 2 characters"></td>
					</tr>
					<tr>
						<td><label for="destination">destination Location :</label></td>
						<td><input type="text" name="destination" id="destination"
							value="${flight.getDestination()}" required aria-label="destination"
							pattern="[A-Za-z]{2,}"title="must contain characters only minimum 2 characters">
						</td>
					</tr>
					<tr>
						<td><label for="Departure Date And Time">Departure Date And Time</label></td>
						<td><input type="datetime-local" name="DepatureDate" aria-label="Departure Date And Time"
							id="date" value="${flight.getDepatureDateTime()}"></td>
					</tr>
					<tr>
						<td><label for="Arrival Date And Time">Arrival Date And Time</label></td>
						<td><input type="datetime-local" name="ArrivalDate" aria-label="Arrival Date And Time"
							id="date" value="${flight.getArrivalDateTime()}"></td>
					</tr>
					<tr>
						<td><label for="Business Class Fare">Business Class Fare :</label></td>
						<td><input type="number" name="businessclassfare" placeholder="Rs. "
							id="businessclassfare" value="${flight.getBusinessClassFare()}" aria-label="Business Class Fare"
							 min="600" max="200000" title="must contain number only maximum Rs. 600 minimum Rs. 200000">
						</td>
					</tr>
					<tr>
						<td><label for="Economic Class Fare">Economic Class Fare :</label></td>
						<td><input type="number" name="economicclassfare" placeholder="Rs. "
							id="economicclassfare" value="${flight.getEconomicClassFare()}" aria-label="Economic Class Fare"
							 min="600" max="200000" title="must contain number only maximum Rs. 600 minimum Rs. 200000">
						</td>
					</tr>

					<tr>
						<td><label for="flight status">Status :</label></td>
						<td>
						<select name="status" aria-label="flight status">
						<option value="available">available</option>
						<option value="unavailable">unavailable</option>
						</select>
						</td>
					</tr>
					<tr>
						<td><label for="Business Class Seats Count">Business Class Seats Count :</label></td>
						<td><input type="number" name="businessclassseat" id="businessclassseat"
							 value="${flight.getBusinessClassSeat()}" min="50" max="350" aria-label="Business Class Seats Count"
							title="must contain number only maximum 50 minimum 350 number of seats"></td>
					</tr>
					<tr>
						<td><label for="Economic Class Seats Count">Economic Class Seats Count :</label></td>
						<td><input type="number" name="economicclassseat" id="economicclassseat"
							 value="${flight.getEconomicClassSeat()}" min="50" max="350" aria-label="Economic Class Seats Count"
							 title="must contain number only maximum 50 minimum 350 number of seats"></td>
					</tr>
				</table>

				<button name="flightno" value="${flight.getFlightNo()}">Update Flight</button>
			</div>
		</form>
	</div>
</body>
</html>