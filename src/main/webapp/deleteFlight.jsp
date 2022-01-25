<%@page import="com.ajith.daoImplement.FlightTableDaoImplement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="" href="Assets/logo.png">
<title>delete flight</title>

</head>
<body>

	<%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>

	<form action="showAllFlight.jsp">

		<% int flightNo = Integer.parseInt(request.getParameter("flightno"));
       System.out.print(flightNo);
    
       FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
       boolean flight = flightDao.deleteFlight(flightNo);
       if(flight==true) {
		//	System.out.println("delete success");
			session.setAttribute("updateflight", "delete");
			request.getRequestDispatcher("showAllFlight.jsp").forward(request,response);
			
		}
		else {
			//System.out.println(" invalid");
			session.setAttribute("updateflight", "canotdelete");
			request.getRequestDispatcher("showAllFlight.jsp").forward(request,response);
		}
			
			
    %>

	</form>


</body>
</html>