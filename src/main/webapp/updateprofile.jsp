<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>Update Profile</title>

<link rel='stylesheet' href="assets/css/addFlight.css">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<link rel='stylesheet' href="assets/css/updateProfile.css">

</head>
<body>

	<h1>Update Your Profile</h1>
	<br>
	<br>
	
	<c:set var="user" scope="session" value="${user}" />
	
	<form action="updateprofile" method="post">
		<table aria-describedby="update profile">
			<tr>
			    <td><label id="lable">Full Name : </label></td>
				<td><input type="text" placeholder="FullName" name="FullName"
					value="${user.getName()}" required autofocus
					pattern="[A-Za-z]{2,}" title="must contain numbers only minimum 2 characters">
				</td>
			</tr>

			<tr>
			 <td><label id="lable">Mobile No : </label></td>
				<td><input type="text" placeholder="Mobile No" name="regmobile"
					value="${user.getMboNo()}" required pattern="[6-9][0-9]{9}"
					title="Must contain 10 numbers only and starting with 6-9"></td>
			</tr>
			<tr></tr>
			<tr>
			     <td><label id="lable">Password : </label></td>
				<td><input type="password" placeholder="Password" name="regpsw"
					value="${user.getPassword()}" id="psw" required
					pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,15}$"
					title="Minimum eight and Minimum 8 and maximum 15 characters, at least one uppercase letter, one lowercase letter, one number and one special character">
				</td>
			</tr>
			
			<tr>
			<td></td>
				<td><button class="btn btn-primary" name="regemail"
						value="${user.getEmail()}">Update Profile</button></td>
			</tr>
<th id=""></th>
		</table>
		
	</form>
</body>
</html>