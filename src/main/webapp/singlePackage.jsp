<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>Single Places</title>

<link rel='stylesheet' href="assets/css/singlePackage.css">

</head>
<body>

	<c:set var="packages" scope="session"
		value="${sessionScope.singlepackages}" />
	<c:set var="rating" scope="session"
		value="${sessionScope.singleaverating}" />

	<form action="allFlights">

		<div id="container">

			<h1 name="place">${packages.getName()}</h1>
			<br> <a href="#"> <img class="firstrowimg"
				src="assets/images/${packages.getImage()}" alt="${packages.getName()}" width = "1000px" height="">

			</a> <br> <br>
			<table class="details" aria-describedby="single place details">
				<tr>
					<td><p>${packages.getDescription()}</p></td>
				</tr>
				<tr>
					<td>
						<h3>Location :</h3>
					</td>
					<td><p>${packages.getName()}</p></td>
				</tr>
				<tr>
					<td>
						<h3>
							One Day night <br> Package Price
						</h3>
					</td>

					<td><p>Rs. ${packages.getPriceOneDays()}</p></td>
				</tr>
				<tr>
					<td>
						<h3>Season :</h3>
					</td>
					<td><p>${packages.getSeason()}</p></td>
				</tr>
				<tr>
					<td>
						<h3>Tourist Protocols :</h3>
					</td>

					<td><p>${packages.getProtocols()}</p></td>
				</tr>
				<c:if test="${rating!=null}">
					<tr>
						<td>
							<h3>Ratings</h3>
						</td>

						<td>
							<h3>${rating.getRating()}/ 5</h3>
						</td>
					</tr>
				</c:if>
              <th id=""></th>
			</table>
			<br> <br>

			<table aria-describedby="single place details">
				<tr>
					<td><label for="tour start date">start Date</label></td>
					<td><label for="no of person">No of person</label></td>
					<td><label for="no of night">No of days in night</label></td>
				</tr>
				<tr>
					<td><input type="date" name="startdate" id="date" aria-label="startdate"
						class="data" required title="please enter the date"></td>
					<td><input type="number" name="noofperson" class="data" id="" aria-label="noofperson"
						required pattern="[0-9]" min="1" max="30" title="must contain number only minimum 1 and maximum 30"></td>
					<td><select name="noofdays" id="select" class="data" required aria-label="noofdays">
							<option value="2 days plan">2N</option>
							<option value="3 days plan">3N</option>
							<option value="4 days plan">4N</option>
							<option value="5 days plan">5N</option>
					</select></td>
					<td>
						<button value="Book Place" class="btn" id="button">Book Place</button>
					</td>
				</tr>
				<th id=""></th>

			</table>

		</div>
	</form>

</body>

<script src="assets/js/popUpMessages.js"></script>

</html>