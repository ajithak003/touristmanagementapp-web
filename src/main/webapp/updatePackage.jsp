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
}

.addpackage {
	border: 3px solid;
	height: 480px;
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
	text-align: center;
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
	background-color: cyan;
	font-size: 18px;
	font-family: Georgia, 'Times New Roman', Times, serif;
	font-weight: bold;
	border: none
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
    <br>
    <h3><a href="showAllAdminPackages">Go Back</a></h3>
    
	<h1>Update Tourist Package</h1>
	<br>
	<br>
	<br>

	<c:set var="packages" scope="session" value="${updatepackage}" />

	<form action="updatepackage" method="get">
		<div class="addpackage">
			<table aria-describedby="package update">
				<th id=""></th>
				<tr>
					<td><label for="location">package location : </label></td>
					<td><input type="text" name="packagename" id="packagename"
						value="${packages.getName()}" required pattern="[aa-Zz]{2,}"
						title="must contain characters only"></td>
				</tr>

				<tr>
					<td><label for="price">Package one day night price : </label></td>
					<td><input type="text" name="packageonedayprice"
						id="packageonedayprice" value=" ${packages.getPriceOneDays()}"
						required pattern="[0-9 .]{2,}" title="must contain numbers only"></td>
				</tr>
				<tr>
					<td><label for="season">current season :</label></td>
					<td><input type="text" name="season" id="season"
						value="${packages.getSeason()}" required pattern="[aa-Zz]{2,}"
						title="must contain characters only"></td>
				</tr>
				<tr>
					<td><label for="protocol">current tourist protocols :</label></td>
					<td><textarea name="protocols" id="protocols"
							value="${packages.getProtocols()}" cols="30" rows="3" required
							pattern="[aa-Zz 0-9]{2,}"
							title="must contain characters and numbers only">${packages.getProtocols()}</textarea></td>
				</tr>
				<tr>
					<td><label for="description">Tourist Place Description
							:</label></td>
					<td><textarea name="description" id="description"
							value="${packages.getDescription()}" cols="30" rows="3" required
							pattern="[aa-Zz 0-9]{2,}"
							title="must contain characters and numbers only">${packages.getDescription()}</textarea></td>
				</tr>
				<tr>
					<td><label for="image">Add Image URL :</label></td>
					<td><input type="file" name="packageimage" id="packageimage"
						required></td>
				</tr>
			</table>
			<button name="packageid" value="${packages.getPackageId()}">Update
				Package</button>
		</div>
	</form>


</body>
</html>
