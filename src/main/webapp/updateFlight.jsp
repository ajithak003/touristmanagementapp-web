<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
a{
text-decoration: none;
}
</style>
</head>
<body>

	<div class="container">
	<br>
	<h3><a href="showAllFlight">Go Back</a></h3>
		<h1>Update Flight</h1>
		<br> <br> <br>

		<c:set var="flight" scope="session" value="${updateflight}" />


		<form action="updateflight" method="get">

			<div class="addpackage">
				<table aria-describedby="update flight">
				<th id=""></th>
					<tr>
						<td><label for="location">Flight Name : </label></td>
						<td><input type="text" name="flightname" id="flightname"
							value="${flight.getFlightName()}" required
							pattern="[Aa-Zz 0-9]{2,}" autofocus></td>
					</tr>

					<tr>
						<td><label for="depature">Departure Location : </label></td>
						<td><input type="text" name="Depature" id="Depature"
							value="${flight.getDepature()}" required pattern="[aa-Zz]{2,}"
							title="must contain characters only"></td>
					</tr>
					<tr>
						<td><label for="destination">destination Location :</label></td>
						<td><input type="text" name="destination" id="destination"
							value="${flight.getDestination()}" required
							pattern="[aa-Zz]{2,}" title="must contain characters only"></td>
					</tr>
					<tr>
						<td><label>Departure Date And Time</label></td>
						<td><input type="datetime-local" name="DepatureDate"
							id="Depature Date" value="${flight.getDepatureDateTime()}"></td>
					</tr>
					<tr>
						<td><label>Arrival Date And Time</label></td>
						<td><input type="datetime-local" name="ArrivalDate"
							id="Arrival Date" value="${flight.getArrivalDateTime()}"></td>
					</tr>
					<tr>
						<td><label for="">Business Class Fare :</label></td>
						<td><input type="text" name="businessclassfare"
							id="businessclassfare" value="${flight.getBusinessClassFare()}"
							pattern="[0-9 .]{2,10}" title="must contain number only"></td>
					</tr>
					<tr>
						<td><label for="">Economic Class Fare :</label></td>
						<td><input type="text" name="economicclassfare"
							id="economicclassfare" value="${flight.getEconomicClassFare()}"
							pattern="[0-9 .]{2,10}" title="must contain number only"></td>
					</tr>

					<tr>
						<td><label for=" ">Status :</label></td>
						<td><input type="text" name="status" id="status" cols="30"
							rows="3" value="${flight.getStatus()}" required
							pattern="[aa-Zz]{2,}" title="must contain characters only"></td>
					</tr>
					<tr>
						<td><label for="">Business Class Seats Count :</label></td>
						<td><input type="text" name="businessclassseat"
							id="businessclassseat" value="${flight.getBusinessClassSeat()}"
							pattern="[0-9]{2,3}" title="must contain number only"></td>
					</tr>
					<tr>
						<td><label for="">Economic Class Seats Count :</label></td>
						<td><input type="text" name="economicclassseat"
							id="economicclassseat" value="${flight.getEconomicClassSeat()}"
							pattern="[0-9]{2,3}" title="must contain number only"></td>
					</tr>
				</table>

				<button name="flightno" value="${flight.getFlightNo()}">Update
					Flight</button>
			</div>
		</form>
	</div>
</body>
</html>