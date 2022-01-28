<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>wallet successful</title>
<style>
body {
	background-color: silver;
}

h1 {
	font-size: 40px;
	font-family: Georgia, 'Times New Roman', Times, serif;
	font-weight: bold;
	color: slateblue;
	text-align: center;
	margin-top: 18%;
}

h2, a {
	text-align: center;
	text-decoration: none;
}

span {
	color: crimson;
}
</style>

</head>
<body>
 
 <c:set var ="newUser" scope="session" value="${walletuser}"/>

	<h1>Transaction Successful</h1>
	<h2>
		Your wallet Amount : <span>${newUser.getWallet()}</span>
	</h2>
	<br>
	<br>
	<h2>
		<a href="userPage.jsp">Go To Home</a>
	</h2>
	
</body>
</html>