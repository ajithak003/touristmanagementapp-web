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


<style>
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
.show{
font-weight: bold;
}
#error{
color:red;
font-weight: bold;
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
					id="psw" value="" required
					pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,15}$"
					title="Minimum eight and Minimum 8 and maximum 15 characters, at least one uppercase letter, one lowercase letter, one number and one special character">

			</div>
			<div class="show">
				<input type="checkbox" onclick="showPassword()">Show Password
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

			<c:if test="${param.error!=null}">

				<script>

				var toastMixin = Swal.mixin({
				    toast: true,
				    icon: 'error',
				    title: 'General Title',
				    animation: false,
				    position: 'top-right',
				    showConfirmButton: false,
				    timer: 3000,
				    timerProgressBar: true,
				    didOpen: (toast) => {
				      toast.addEventListener('mouseenter', Swal.stopTimer)
				      toast.addEventListener('mouseleave', Swal.resumeTimer)
				    }
				  });
   
                  deleted();
                   function deleted(){
                    toastMixin.fire({
                    animation: true,
                    title: 'Username and Password mismach'
                   });
                  }
             </script>
            </c:if>
			<c:if test="${param.infomsg!=null}">

				<script>

				var toastMixin = Swal.mixin({
				    toast: true,
				    icon: 'success',
				    title: 'General Title',
				    animation: false,
				    position: 'top-right',
				    showConfirmButton: false,
				    timer: 3000,
				    timerProgressBar: true,
				    didOpen: (toast) => {
				      toast.addEventListener('mouseenter', Swal.stopTimer)
				      toast.addEventListener('mouseleave', Swal.resumeTimer)
				    }
				  });
   
                  deleted();
                   function deleted(){
                    toastMixin.fire({
                    animation: true,
                    title: 'Successfully Registered !\n please login'
                   });
                  }
             </script>
            </c:if>

		</div>

	</form>
	<script type="text/javascript">
		function remove() {
			console.log("enter");
			document.getElementById("error").innerHTML = "";
		}

		function showPassword() {
			var x = document.getElementById("psw");
			if (x.type === "password") {
				x.type = "text";
			} else {
				x.type = "password";
			}
		}
	</script>
</body>

</html>