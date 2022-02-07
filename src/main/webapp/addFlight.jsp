<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>add package</title>

<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>

<link rel='stylesheet' href="assets/css/addFlight.css">

</head>
<body>


	<form action="addflight" method="post">
		<div class="container">
			<h1>Add Flight</h1>
			<h2>
				<a href="adminPage.jsp">Go To Home</a>
			</h2>
			<br> <br> <br>

			<div class="addpackage">
				<table aria-describedby="add package">
					<th id=""></th>

					<tr>
						<td><label for="location" aria-label="location">Flight Name : </label></td>
						<td><input type="text" name="flightname" id="flightname"
							required autofocus pattern="[A-Za-z0-9]{2,}"
							title="must contain and character and numbers only not allowed special character and minimum 2 character or numbers">
						</td>
					</tr>

					<tr>
						<td><label for="depature place" aria-label="depature place">Departure Location :
						</label></td>
						<td><input type="text" name="Depature" id="Depature" required
							pattern="[A-Za-z]{2,}"  title="must contain characters only minimum 2 characters">
						</td>
					</tr>
					<tr>
						<td><label for="destination place" aria-label="destination place">destination
								Location :</label></td>
						<td><input type="text" name="destination" id="destination"
							required pattern="[A-Za-z]{2,}"
							title="must contain characters only minimum 2 characters"></td>
					</tr>
					<tr>
						<td><label for="Departure Date And Time" aria-label="Departure Date And Time">Departure Date And Time</label></td>
						<td><input type="datetime-local" name="DepatureDate" id="date" required></td>
					</tr>
					<tr>
						<td><label for="Arrival Date And Time" aria-label="Arrival Date And Time">Arrival Date	And Time</label></td>
						<td><input type="datetime-local" name="ArrivalDate" id="date" required></td>
					</tr>
					<tr>
						<td><label for="Business Class Fare" aria-label="Business Class Fare">Business Class Fare :</label></td>
						<td><input type="number" name="businessclassfare"
							placeholder="Rs" id="businessclassfare" min="600" max="200000"
							required
							title="must contain number only maximum Rs. 600 minimum Rs. 200000"></td>
					</tr>
					<tr>
						<td><label for="Economic Class Fare" aria-label="Economic Class Fare">Economic Class Fare :</label></td>
						<td><input type="number" name="economicclassfare"
							placeholder="Rs" id="economicclassfare" min="600" max="200000"
							title="must contain number only maximum Rs. 600 minimum Rs. 200000"
							required></td>
					</tr>

					<tr>
						<td><label for="flight Status" aria-label="flight Status">Status : </label></td>
						<td><select name="status">
								<option value="available">available</option>
								<option value="unavailable">unavailable</option>
						</select></td>
					</tr>
					<tr>
						<td><label for="Business Class Seats Count" aria-label="Business Class Seats Count">Business
								Class Seats Count :</label></td>
						<td><input type="number" name="businessclassseat"
							id="businessclassseatr" required min="50" max="350"
							title="must contain number only maximum 50 minimum 350 number of seats"></td>
					</tr>
					<tr>
						<td><label for="Economic Class Seats Count" aria-label="Economic Class Seats Count">Economic
								Class Seats Count :</label></td>
						<td><input type="number" name="economicclassseat"
							id="economicclassseat" required min="50" max="350"
							title="must contain number only maximum 50 minimum 350 number of seats"></td>
					</tr>
				</table>
				<button>Add Flight</button>
			</div>
		</div>
	</form>

	<script src="assets/js/popUpMessages.js"></script>

	<c:if test="${param.infomsg!=null}">
		<script type="text/javascript">
			popupMessages('Successfully Added')
		</script>
	</c:if>
	<c:if test="${param.error!=null}">
		<script type="text/javascript">
			popupMessages('Flight can not be Added')
		</script>
	</c:if>

</body>

</html>