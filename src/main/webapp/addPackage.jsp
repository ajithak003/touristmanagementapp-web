<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>

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

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	text-decoration: none;
	font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS',
		sans-serif;
}

body {
	background-color: aquamarine;
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
	width: 170px;
	margin-left: 65%;
	margin-top: 20px;
	border-radius: 20px;
	background-color: orange;
	font-size: 18px;
	font-family: Georgia, 'Times New Roman', Times, serif;
	font-weight: bold;
	border: none
}

td {
	padding-top: 13px;
	padding-bottom: 13px;
}

a {
	color: blue;
}
</style>

</head>
<body>

	<form action="addpackage" method="post">
		<h1>Add Tourist Package</h1>
		<h2>
			<a href="adminPage.jsp">Go To Home</a>
		</h2>
		<br> <br> <br>

		<div class="addpackage">
			<table aria-describedby="Show All package">
				<th id=""></th>
				<tr>
					<td><label for="location">package location : </label></td>
					<td><input type="text" name="packagename" id="packagename"
						required autofocus pattern="[A-Za-z]{2,}"
						title="must contain characters only minimum 2 characters"></td>
				</tr>

				<tr>
					<td><label for="Package one day night price">Package
							one day night price/person : </label></td>
					<td><input type="number" name="packageonedayprice"
						placeholder="Rs" id="packageonedayprice" required min="500"
						max="50000"
						title="must contain numbers only minimum Rs. 500 and maximum Rs. 50000"></td>
				</tr>
				<tr>
					<td><label for="season">current season :</label></td>
					<td><input type="text" name="season" id="season" required
						pattern="[A-Za-z]{2,}"
						title="must contain characters only minimum 2 characters"></td>
				</tr>
				<tr>
					<td><label for="protocol">current tourist protocols :</label></td>
					<td><textarea name="protocol" id="" cols="30" rows="3"
							required pattern="[A-Za-z0-9]{5,}"
							title="must contain 5 characters and numbers only "></textarea></td>
				</tr>
				<tr>
					<td><label for="description">Tourist Place Description :</label></td>
					<td><textarea name="description" id="description" cols="30"
							rows="3" required pattern="[A-Za-z0-9]{5,}"
							title="must contain 5 characters and numbers only "></textarea></td>
				</tr>
				<tr>
					<td><label for=" Tourist place image">Add Images : </label></td>
					<td><input type="file" name="packageimage" id="packageimage"
						required></td>
				</tr>
			</table>
			<button>Add Package</button>
		</div>
	</form>

	<script src="assets/js/popUpMessages.js"></script>

	<c:if test="${param.error!=null}">
		<script type="text/javascript">
			popupMessages('This Package Already Added!')
		</script>
	</c:if>
	<c:if test="${param.infomsg!=null}">
		<script type="text/javascript">
			popupMessages('Successfully Added')
		</script>
	</c:if>



</body>
</html>