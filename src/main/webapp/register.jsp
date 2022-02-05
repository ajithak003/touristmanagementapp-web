
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>
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

<Style>
body {
	margin: 0;
	padding: 0;
	font-family: sans-serif;
	background: url("assets/images/blure.jpg");
	background-size: cover;
}

.loginbox {
	border: 2px solid;
	background-color: cornsilk;
	border-radius: 20px;
	padding: 30px;
	width: 290px;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	color: black;
	padding-left: 40px;
	padding-right: 40px;
}

.loginbox h1 {
	float: left;
	font-size: 35px;
	border-bottom: 6px solid #1ef725;
	margin-bottom: 30px;
	padding: 10px 0;
}

.textbox {
	width: 100%;
	overflow: hidden;
	font-size: 16px;
	padding: 8px 0;
	margin: 8px 0;
	border-bottom: 1px solid #1ef725;
}

.textbox input {
	border: none;
	outline: none;
	background: none;
	color: whiye;
	font-size: 18px;
	width: 80%;
	float: left;
	margin: 6px;
}

.btn {
	width: 100%;
	background: none;
	border: 2px solid #1ef725;
	color: blue;
	padding: 5px;
	font-size: 18px;
}
</Style>
</head>
<body>

	<form action="register" id="register" method="post">
		<div class="loginbox">
			<h1>Register</h1>
			<div class="textbox">
				<input type="text" placeholder="FullName" name="FullName" value=""
					required autofocus onkeyup="remove()" pattern="[A-Za-z]{2,}"
					title="must contain numbers only minimum 2 characters">
			</div>
			<div class="textbox">
				<input type="email" placeholder="Email" name="regemail" value=""
					required pattern="[A-Za-z0-9]+[@][a-zA-Z]+[.][A-Za-z]{2,3}"
					title="follow this pattern 'abc@xyz.com'">
			</div>
			<div class="textbox">
				<input type="text" placeholder="Mobile No" name="regmobile" value=""
					required pattern="[6-9][0-9]{9}"
					title="Must contain 10 numbers only and starting 6-9 only">
			</div>

			<div class="textbox">
				<input type="password" placeholder="Password" name="regpsw" value=""
					id="psw" onkeyup="checkpattern()" required
					pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,15}$"
					title="follow this pattern Ex: 'Abcd@123' or 'abCd234$'">
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
