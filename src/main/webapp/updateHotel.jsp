<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>update hotels</title>
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
	height: 500px;
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
	margin-top: 10px;
	border-radius: 20px;
	background-color: gold;
	font-size: 18px;
	font-family: Georgia, 'Times New Roman', Times, serif;
	font-weight: bold;
	border: none
}
td {
	padding-top: 20px;
	padding-bottom: 20px;
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
     
     <br>
     <h3><a href="showAllHotel" id="home">Go Back</a></h3>
     
	<h1>Update Hotels</h1>
	<br>
	<br>
	<br>

	

	<form action="updatehotel" method="post">
		<div class="container">
			<div class="addpackage">
			
			<c:set var="hotel" scope="session" value="${updatehotel}" />
			
				<table aria-describedby="update hotel">
				<th id=""></th>
					<tr>
						<td><label for="Hotel Name">Hotel Name : </label></td>
						<td><input type="text" name="hotelname" id="hotelname"
							value="${hotel.getHotelName()}" required autofocus pattern="[A-Za-z0-9]{2,}"
							title="must contain and character and numbers only not allowed special character and minimum 2 character or numbers">
						</td>
					</tr>

					<tr>
						<td><label for="Hotel Location">Hotel Location : </label></td>
						<td><input type="text" name="hotellocation"
							id="hotellocation" value="${hotel.getLocation()}" required
							pattern="[A-Za-z]{2,}" title="must contain characters only minimum 2 characters"></td>
					</tr>
					<tr>
						<td><label for="Hotel Standard Room One Day Price">Standard Room One Day Price :</label></td>
						<td><input type="text" name="standardprice" placeholder="Rs. " required
							id="standardprice" value="${hotel.getMidRangePrice()}" min="600" max="200000"
							title="must contain numbers Rs. 500 minimum Rs. 100000 only">></td>
					</tr>
					<tr>
						<td><label for="Hotel Premium Room One Day Price">Premium Room One Day Price :</label></td>
						<td><input type="text" name="premiumprice" id="premiumprice"placeholder="Rs. " 
							 value="${hotel.getPremiumPrice()}" required min="600" max="200000"
							title="must contain numbers Rs. 500 minimum Rs. 100000 only"></td>
					</tr>
					
					<tr>
						<td><label for="hotel status">Status :</label></td>
						<td>
						<select name="status">
						<option value="active">active</option>
						<option value="inactive">inactive</option>
						</select>
						</td>
					</tr>
					
					<tr>
						<td><label for="Hotel image">Add Hotel Image :</label></td>
						<td><input type="file" name="hotelimage" id="hotelimage"
							value="${hotel.getImage()}" required></td>
					</tr>
				</table>
				<button name="hotelid" value="${hotel.getHotelId()}">Update
					hotel</button>
			</div>
		</div>
	</form>
</body>
</html>