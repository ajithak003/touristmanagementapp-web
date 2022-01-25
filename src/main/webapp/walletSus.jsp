<%@page import="com.ajith.daoImplement.UserTableDaoImplement"%>
<%@page import="com.ajith.model.UserClass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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


	<%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>

	<%  
    UserClass user = (UserClass) session.getAttribute("newUser");
   UserTableDaoImplement userDao = new UserTableDaoImplement();
   String amounts = request.getParameter("amount");
   long amount = Long.parseLong(amounts);
   if(amount>0){
   long totalAmount = user.getWallet()+ amount;
   boolean wallet = userDao.addWalletAmount(user.getId(), totalAmount);
   if(wallet==true){
   UserClass newUser = userDao.getUserById(user);
   
%>
	<h1>Transaction Successful</h1>
	<h2>
		Your wallet Amount : <span><%=newUser.getWallet() %></span>
	</h2>
	<br>
	<br>
	<h2>
		<a href="UserPage.jsp">Go To Home</a>
	</h2>
	<%} 
   else{
	   %>
	<h1>Transaction failedü</h1>
	<h2>
		Your wallet Amount : <span><%=user.getWallet() %></span>
	</h2>
	<h2>
		<a href="UserPage.jsp">Go To Home</a>
	</h2>
	<%}}
   else{%>
	<h1>Enter the Correct Values</h1>
	<h2>
		<a href="UserPage.jsp">Go To Home</a>
	</h2>
	<%  
   } %>
</body>
</html>