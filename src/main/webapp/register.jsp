<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="" href="Assets/logo.png">
<title>register Form</title>
<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>

<link rel='stylesheet' href="assets/css/register.css">

</head>
<body>

	<form action="register" id="register" method="post">
		<div class="loginbox">
			<h1>Register</h1>
			<div class="textbox">
				<input type="text" placeholder="FullName" name="FullName" value=""
					id="" required autofocus onkeyup="remove()" pattern="[A-Za-z]{2,}"
					title="must contain numbers only minimum 2 characters"
					aria-label="FullName">
			</div>
			<div class="textbox">
				<input type="email" placeholder="Email" name="regemail" value=""
					id="" required pattern="[A-Za-z0-9]+[@][a-zA-Z]+[.][A-Za-z]{2,3}"
					title="follow this pattern 'abc@xyz.com'" aria-label="Email id">
			</div>
			<div class="textbox">
				<input type="text" placeholder="Mobile No" name="regmobile" value=""
					id="" required pattern="[6-9][0-9]{9}"
					title="Must contain 10 numbers only and starting 6-9 only"
					aria-label="Mobile No">
			</div>

			<div class="textbox">
				<input type="password" placeholder="Password" name="regpsw" value=""
					id="psw" onkeyup="checkpattern()" required
					pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,15}$"
					title="follow this pattern Ex: 'Abcd@123' or 'abCd234$'"
					aria-label="Password">
			</div>

			<div>
				<ul>
					<li id="upper">At least one upper case[A-Z]</li>
					<li id="lower">At least one lower case [a-z]</li>
					<li id="number">At least one number [0-9]</li>
					<li id="special">At least one special character [@$!%*?&]</li>
					<li id="char">At least 8 character</li>
				</ul>
			</div>

			<button class="btn" type="submit">Sign up</button>
			<br>

		</div>
	</form>

	<script src="assets/js/popUpMessages.js"></script>

	<c:if test="${param.notallow!=null}">
		<script type="text/javascript">
			popupMessages('Not allowed')
		</script>
	</c:if>

	<c:if test="${param.errormsg!=null}">
		<script type="text/javascript">
			popupMessages('This email id already registered')
		</script>
	</c:if>

	<script src="assets/js/loginAndRegister.js"></script>

</body>

</html>
