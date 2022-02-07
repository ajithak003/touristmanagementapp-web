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

<link rel='stylesheet' href="assets/css/updatePackages.css">

</head>
<body>
    <br>
    <h3><a href="showAllAdminPackages" id="home">Go Back</a></h3>
    
	<h1>Update Tourist Package</h1>
	<br>
	<br>
	<br>

	<c:set var="packages" scope="session" value="${updatepackage}" />

	<form action="updatepackage" method="post">
		<div class="addpackage">
			<table aria-describedby="package update">
				<th id=""></th>
				<tr>
					<td><label for="location">package location : </label></td>
					<td><input type="text" name="packagename" id="packagename" aria-label="location"
						value="${packages.getName()}" required pattern="[A-Za-z]{2,}"
						title="must contain characters only minimum 2 characters"></td>
				</tr>

				<tr>
					<td><label for="Package one day night price per person">Package one day night price : </label></td>
					<td><input type="text" name="packageonedayprice" placeholder="Rs. " id="packageonedayprice" required
						 aria-label="Package one day night price per person" value=" ${packages.getPriceOneDays()}" min="500" 
						 max="50000" title="must contain numbers only minimum Rs. 500 and maximum Rs. 50000"></td>
				</tr>
				<tr>
					<td><label for="season">current season :</label></td>
					<td><input type="text" name="season" id="season" aria-label="season"
						value="${packages.getSeason()}" required pattern="[A-Za-z]{2,}"
						 title="must contain characters only minimum 2 characters"></td>
				</tr>
				<tr>
					<td><label for="protocol">current tourist protocols :</label></td>
					<td><textarea name="protocols" id="protocols" cols="30" rows="3" aria-label="protocol"
							value="${packages.getProtocols()}"  required  pattern="[A-Za-z0-9]{5,}"
							title="must contain 5 characters and numbers only ">${packages.getProtocols()}</textarea></td>
				</tr>
				<tr>
					<td><label for="description">Tourist Place Description
							:</label></td>
					<td><textarea name="description" id="description"
							value="${packages.getDescription()}" cols="30" rows="3" 
						    required aria-label="description" pattern="[A-Za-z0-9]{5,}"
							title="must contain 5 characters and numbers only ">${packages.getDescription()}</textarea></td>
				</tr>
				
				<tr>
						<td><label for="package status" aria-label="package status">Status :</label></td>
						<td>
						<select name="status">
						<option value="active">active</option>
						<option value="inactive">inactive</option>
						</select>
						</td>
					</tr>
				
				<tr>
					<td><label for="Tourist place image">Add Image :</label></td>
					<td><input type="file" name="packageimage" id="packageimage"
						required aria-label="Tourist place image"></td>
				</tr>
			</table>
			<button name="packageid" value="${packages.getPackageId()}">Update
				Package</button>
		</div>
	</form>


</body>
</html>
