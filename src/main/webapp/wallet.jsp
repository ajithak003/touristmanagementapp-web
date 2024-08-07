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
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js">
</script>
<script src="assets/js/wallet.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>

<link rel='stylesheet' href="assets/css/wallet.css">

</head>
<body>
	<c:set var="user" scope="session" value="${user}" />

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

	<form action="walletSus" method="post" >
		<h3>
			<a href="userPage.jsp">Go To Home</a>
		</h3>
		<h1>Wallet Top Up</h1>
		<div class="container">

			<h3>
				Your Wallet Balance : <span>Rs. ${user.getWallet()}</span>

			</h3>
			<br>
			<h4>Top up Wallet</h4>
			
			<fieldset>
            <legend>Credit/Debit Card Information</legend>
            
            <label for="cardNumber">Card Number:</label>
            <input type="text" id="cardNumber" name="cardNumber" maxlength="22" required 
            placeholder = 'XXXX  XXXX  XXXX  XXXX' onKeyUp = 'cardPattern()'>
            <span id="cardNumberError" class="error"></span>
            
            <label for="cardName">Name on Card:</label>
            <input type="text" id="cardName" name="cardName" required>
            
            <label for="expiryDate">ExpiryDate:</label>
            <input type="text" id="expiryDate" name="expiryDate" maxlength="5" required
            placeholder = "MM/YY" onKeyUp = 'expiryDatePattern()' >
            <span id="expiryDateError" class="error"></span>
            
            <label for="cvv">CVV:</label>
            <input type="text" id="cvv" name="cvv" maxlength="3" required
            placeholder = "XXX">
            <span id="cvvError" class="error"></span>
            
            <label for="mobileNumber">Mobile Number:</label>
            <input type="number" id="mobileNumber" name="mobileNumber" maxlength="10" required
            placeholder = "">
            <span id="mobileNumberError" class="error"></span>
                         
        </fieldset>

        <fieldset>
            <legend>Top-Up Amount</legend>
            
            <label for="amount">Amount:</label>
            <input type="number" id="amount" name="amount" required
            placeholder = "Minimum Rs. 10000">
            <span id="amountError" class="error"></span>
        </fieldset>
        
			<button onClick= "validate(event)">PROCEED TO TOPUP</button>
		</div>
	</form>
</body>
</html>