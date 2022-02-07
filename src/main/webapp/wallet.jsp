<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

<link rel='stylesheet' href="assets/css/wallet.css">

</head>
<body>
        <c:set var="user" scope="session" value="${user}"/>
        
        <script src="assets/js/popUpMessages.js"></script>
        
        <c:if test="${param.infomsg!=null}">
       <script type="text/javascript">
			popupMessages('Insufficient balance')
		</script>
		</c:if>
		
		<c:if test="${param.error!=null}">
       <script type="text/javascript">
			popupMessages('Transaction failed')
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
			<br> <input type="number" name="amount" id="amount" aria-label="topup amount"
				placeholder="Rs.  Enter amount" required min="10000" autofocus
				pattern="[0-9]{3,}" title="must contains numbers minimum Rs. 10000">
			<p>Minimum Rs. 10000</p>
			<br>
			<br>
			<br>
			<button>PROCEED TO TOPUP</button>
		</div>
	</form>
</body>
</html>