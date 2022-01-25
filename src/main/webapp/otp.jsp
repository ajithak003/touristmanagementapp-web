<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="" href="Assets/logo.png">
<title>Register success</title>

<style type="text/css">
body {
	background-color: blanchedalmond
}

h2 {
	text-align: center;
	position: relative;
	top: 130px;
}

a {
	text-decoration: none:
}
</style>

</head>

<%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>

<body>

	<form name="otp" id="otp" action="otp">

		<% String success=(String)session.getAttribute("success");
            if(success!=null) {%>
		<h2><%=session.getAttribute("success") %></h2>

		<%} session.removeAttribute("success"); %>
		<h2>
			<a href="login.jsp">Login</a>
		</h2>

	</form>

</body>
</html>