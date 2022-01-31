<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>show All Places</title>

<style>
table {
	border: 2px solid;
	border-collapse: collapse;
	background-color: paleturquoise;
}

tr, td, th {
	border: 2px solid;
	text-align: center;
	padding: 10px;
}

a {
	text-decoration: none;
}

h1 {
	text-align: center;
	font-size: 50px;
	color: steelblue
}
</style>

</head>
<body>

	<h2>
		<a href="adminPage.jsp">Go To Home</a>
	</h2>
	<h1>Show All Packages</h1>

	<br>
	<br>



	<table aria-describedby="Show All packages">

		<th id="">Package Id</th>
		<th id="">Package Name</th>
		<th id="">One Day Night Price</th>
		<th id="">Season</th>
		<th id="">Protocols</th>
		<th id="">Description</th>
		<th id="">Action</th>
		<th id="">Action</th>
		
		<c:forEach items="${showalladminpackage}" var="singlePackage">
		
		<tr>
			<td>${singlePackage.getPackageId()}</td>
			<td>${singlePackage.getName()}</td>
			<td>${singlePackage.getPriceOneDays()}</td>
			<td>${singlePackage.getSeason()}</td>
			<td>${singlePackage.getProtocols()}</td>
			<td>${singlePackage.getDescription()}</td>
			<td><a
				href="updatePackage?packagname=${singlePackage.getName()}">Edit</a></td>
			<td><a
				href="deletepackage?packagname=${singlePackage.getName()}">Delete</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>