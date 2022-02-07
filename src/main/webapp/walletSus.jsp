<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>wallet successful</title>

<link rel='stylesheet' href="assets/css/walletSus.css">

</head>
<body>

	<c:set var="newUser" scope="session" value="${user}" />

	<h1>Transaction Successful</h1>
	<h2>
		Your wallet Balance : <span>Rs. ${newUser.getWallet()}</span>
	</h2>
	<br>
	<h2>
		<a href="userPage.jsp">Go To Home</a>
	</h2>

</body>
</html>