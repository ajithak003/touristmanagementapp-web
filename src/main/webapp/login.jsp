<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>Login Page</title>
<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>

<link rel='stylesheet' href="assets/css/login.css">

</head>

<body>


	<form action="login" id="login" method="post">

		<div class="loginbox">
			<h1>Login</h1>

			<div class="textbox">
				<input type="email" placeholder="Email" name="loginemail" value=""
					required pattern="[A-Za-z0-9]+[@][a-zA-Z]+[.][A-Za-z]{2,3}"
					autofocus onkeyup="remove()">
			</div>
			<div class="textbox">
				<input type="password" placeholder="Password" name="loginpsws"
					id="psw" value="" required
					pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,15}$"
					title="Minimum eight and Minimum 8 and maximum 15 characters, at least one uppercase letter, one lowercase letter, one number and one special character">

			</div>
			<div class="show">
				<input type="checkbox" onclick="showPassword()">Show
				Password
			</div>
			<br>
			<div>
				<button class="btn" type="submit">Sign in</button>
			</div>
			<div class="forget">

				<p>
					New User? <a href="register.jsp">create an account </a>
				</p>
			</div>
			<br>

		</div>

	</form>

	<script src="assets/js/popUpMessages.js"></script>

	<c:if test="${param.error!=null}">
		<script type="text/javascript">
			popupMessages('Username and Password mismach')
		</script>
	</c:if>

	<c:if test="${param.infomsg!=null}">
		<script type="text/javascript">
			popupMessages('Successfully Registered')
		</script>
	</c:if>

	<script src="assets/js/loginAndRegister.js"></script>
	
</body>

</html>