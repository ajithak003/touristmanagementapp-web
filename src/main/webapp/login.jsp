<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>Login Page</title>

<style>
body {
	margin: 0;
	padding: 0;
	font-family: sans-serif;
	background: url("Assets/blure.jpg");
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
}

.loginbox h1 {
	float: left;
	font-size: 40px;
	border-bottom: 6px solid #1ef725;
	margin-bottom: 50px;
	padding: 13px 0;
}

.textbox {
	width: 100%;
	overflow: hidden;
	font-size: 20px;
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
	margin: 10px;
}

.btn {
	width: 100%;
	background: none;
	border: 2px solid #1ef725;
	color: blue;
	padding: 5px;
	font-size: 18px;
}

a {
	text-decoration: none;
	font-weight: bolder;
}
</style>
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
					value="" required
					pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,15}$"
					title="Minimum eight and Minimum 8 and maximum 15 characters, at least one uppercase letter, one lowercase letter, one number and one special character">
			</div>


			<button class="btn" type="submit">Sign in</button>

			<div class="forget">

				<p>
					New User? <a href="register.jsp">create an account </a>
				</p>
			</div>
			<br>
			
            <c:if test="${not empty error}">
				<p id="error">
					<c:out value="${error}"></c:out>
				</p>
				<c:set var="error" scope="session" value=""/>
			</c:if>
			

		</div>

	</form>
	<script type="text/javascript">
	function remove(){
		console.log("enter");
		document.getElementById("error").innerHTML="";
	}
	</script>
</body>

</html>