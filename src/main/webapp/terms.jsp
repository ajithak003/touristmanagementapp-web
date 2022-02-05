<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>terms and condition</title>
<style>
body {
	background-color: ivory;
}

.box {
	text-align: center;
	margin-top: 100px;
	font-size: 20px;
}

.btn {
	height: 40px;
	width: 70px;
	background-color: rgb(99, 99, 243);
	font-size: 20px;
	color: white;
	border-radius: 20px;
	border: none;
}
</style>
</head>
<body>

	<form action="dateChangeflight">
		
		<div class="box">
			<h4>Notes : if you want to change tour date Rs. 1000 will be
				detected</h4>

			<h4>
				<input type="checkbox" name="yes" id="yes" value="accept" required>accept
				terms and policy
			</h4>
			<h3>
				change Date : <input type="date" name="changedate" id="date"
					required>
			</h3>
			<button class="btn" id="btn">OK</button>
		</div>
	</form>
	
	<script src="assets/js/popUpMessages.js"></script>
	
</body>


</html>