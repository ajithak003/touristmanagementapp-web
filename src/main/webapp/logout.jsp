<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="" href="Assets/logo.png">
<title>Insert title here</title>
</head>
<body>
	<%        request.getSession().invalidate();
 
	       response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
	      
	       response.sendRedirect("index.jsp");
	       %>
</body>
</html>