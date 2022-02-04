<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>wallet page</title>

<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>


<style>
body {
	background-color: rgb(138, 238, 238);
}

.container {
	border: 3px solid;
	width: 400px;
	text-align: center;
	margin-left: 35%;
	margin-top: 70px;
	padding: 3%;
	border-radius: 3%;
}

input {
	height: 40px;
	width: 200px;
	text-align: center;
	font-size: 18px;
	font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
	font-weight: bold;
	border: 2px solid;
}
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}	

button {
	height: 40px;
	width: 220px;
	border-radius: 25px;
	background-color: blueviolet;
	border: none;
	font-size: 15px;
	font-weight: bold;
	font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande',
		'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
	color: cornsilk;
}

a {
	text-decoration: none;
	color: blue;
}
h1{
text-align: center;
color: blue;
font-size: 40px;
}

</style>

</head>
<body>
        <c:set var="user" scope="session" value="${user}"/>
        
        <c:if test="${param.infomsg!=null}">

				<script>
				Swal.fire({
					  icon: 'error',
					  title: 'Insufficient balance !',
					  showConfirmButton: false,
					  timer: 1500})
			</script>
			</c:if>
        
	<form action="walletSus" method="post">
		<h3 >
			<a href="userPage.jsp">Go To Home</a>
		</h3>
		<h1>Wallet Top Up</h1>
		<div class="container">

			<h3 >
				Your Wallet Balance : <span>Rs. ${user.getWallet()}</span>
			
			</h3>
			<br>
			<h4>Topup Wallet</h4>
			<br> <input type="number" name="amount" id="amount"
				placeholder="Rs.  Enter amount" required min="10000" autofocus
				pattern="[0-9]{3,}" title="must contain numbers only">
			<p>Minimum Rs. 10000</p>
			<br>
			<br>
			<br>
			<button>PROCEED TO TOPUP</button>
		</div>
	</form>
</body>
</html>