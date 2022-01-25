<%@page import="com.ajith.daoImplement.HotelTableDaoImplement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="" href="Assets/logo.png">
<title>delete hotels</title>

</head>
<body>

	<%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>

	<form action="showAllHotel.jsp">

		<% int hotelId = Integer.parseInt(request.getParameter("hotelid"));
      // System.out.print(hotelId);
     HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();
    
       boolean hotel = hotelDao.deleteHotel(hotelId);
       if(hotel==true) {
			//System.out.println("deleted");
			session.setAttribute("hotel", "delete");
			request.getRequestDispatcher("showAllHotel.jsp").forward(request,response);
			
		}
		else {
			//System.out.println("invalid");
			session.setAttribute("hotel", "canotdelete");
			request.getRequestDispatcher("showAllHotel.jsp").forward(request,response);
		}
			
			
    %>

	</form>


</body>
</html>