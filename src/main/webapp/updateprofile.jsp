<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>Update Profile</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<style>
h1 {
	text-align: center;
	color: blue;
}

table {
	border: 3px solid;
	padding: 20px;
	text-align: center;
	margin-left: 38%;
	border-radius: 10px;
}

input {
	height: 30px;
	font-size: 16px;
	font-weight: bold;
}

button {
	font-size: 20px;
	font-weight: bold;
}
</style>
</head>
<body>

	<h1>Update Your Profile</h1>
	<br>
	<br>
	
	<c:set var="user" scope="session" value="${user}" />
	
	<form action="updateprofile" method="post">
		<table cellpadding="30px">
			<tr>
				<td><input type="text" placeholder="FullName" name="FullName"
					value="${user.getName()}" required autofocus
					pattern="[aa-Zz]{2,}" title="must contain characters only">
				</td>
			</tr>

			<tr>
				<td><input type="text" placeholder="Mobile No" name="regmobile"
					value="${user.getMboNo()}" required pattern="[6-9][0-9]{9}"
					title="Must contain 10 numbers only"></td>
			</tr>
			<tr></tr>
			<tr>
				<td><input type="password" placeholder="Password" name="regpsw"
					value="${user.getPassword()}" id="psw" required
					pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,15}$"
					title="Minimum eight and Minimum 8 and maximum 15 characters, at least one uppercase letter, one lowercase letter, one number and one special character">
				</td>
			</tr>
			<tr>
				<td><button class="btn btn-primary" name="regemail"
						value="${user.getEmail()}">Update Profile</button></td>
			</tr>

		</table>
	</form>
</body>
</html>