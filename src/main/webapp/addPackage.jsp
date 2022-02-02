<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>add package</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	text-decoration: none;
	font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS',
		sans-serif;
	background-color: aquamarine;
}

h1 {
	text-align: center;
	color:blue;
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
	background-color: cyan;
	font-size: 18px;
	font-family: Georgia, 'Times New Roman', Times, serif;
	font-weight: bold;
	border: none
}
td {
	padding-top: 13px;
	padding-bottom: 13px;
}
</style>

</head>
<body>

	<form action="addpackage" method="post">
		<h1>Add Tourist Package</h1>
		<h2>
			<a href="adminPage.jsp">Go To Home</a>
		</h2>
		<br>
		<br>
		<br>


		<c:if test="${param.error!=null}">
			<script type="text/javascript">
     alert("This Package Already Added");
     </script>

		</c:if>
		<c:if test="${param.infomsg!=null}">
			<script type="text/javascript">
     alert("successfully added");
     </script>

		</c:if>



		<div class="addpackage">
			<table aria-describedby="Show All package">
			<th id=""></th>
				<tr>
					<td><label for="location">package location : </label></td>
					<td><input type="text" name="packagename" id="packagename"
						required autofocus pattern="[Aa-Zz]{2,}"
						title="must contain characters only"></td>
				</tr>

				<tr>
					<td><label for="price">Package one day night price : </label></td>
					<td><input type="number" name="packageonedayprice" placeholder="Rs"
						id="packageonedayprice" required pattern="[0-9]{2,}"
						title="must contain numbers only"></td>
				</tr>
				<tr>
					<td><label for="season">current season :</label></td>
					<td><input type="text" name="season" id="season" required
						pattern="[Aa-Zz]{2,}" title="must contain characters only"></td>
				</tr>
				<tr>
					<td><label for="protocol">current tourist protocols :</label></td>
					<td><textarea name="protocol" id="" cols="30" rows="3"
							required pattern="[Aa-Zz0-9]{5,}"
							title="must contain 5 characters only"></textarea></td>
				</tr>
				<tr>
					<td><label for="description">Tourist Place Description
							:</label></td>
					<td><textarea name="description" id="description" cols="30"
							rows="3" required pattern="[Aa-Zz0-9]{5,}"
							title="must contain 5 characters only"></textarea></td>
				</tr>
				<tr>
					<td><label for="image">Add Images URL : </label></td>
					<td><input type="file" name="packageimage" id="packageimage"
						required></td>
				</tr>
			</table>
			</div>
			<button>Add Package</button>
	</form>

</body>
</html>