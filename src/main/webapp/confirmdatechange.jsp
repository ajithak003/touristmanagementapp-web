<%@page import="com.ajith.daoImplement.BookingTableDaoImplement"%>
<%@page import="com.ajith.daoImplement.UserTableDaoImplement"%>
<%@page import="com.ajith.model.UserClass"%>
<%@page import="com.ajith.model.FlightClass"%>
<%@page import="com.ajith.daoImplement.FlightTableDaoImplement"%>
<%@page import="com.ajith.model.BookingClass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="" href="Assets/logo.png">
<title>plan date change</title>
<style>
body {
	background-color: ivory;
}

h1 {
	text-align: center;
	margin-top: 20%;
}

h2, a {
	text-align: center;
	text-decoration: none;
}
</style>

</head>
<body>

	<%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>

	<% UserClass users = (UserClass) session.getAttribute("user");
   UserTableDaoImplement userDao = new UserTableDaoImplement(); 
   UserClass user = userDao.getUserById(users);
   
   BookingClass booking = (BookingClass) session.getAttribute("datechangebookings");
   
   int singleBookingId =(Integer) session.getAttribute("datechangeid");
   

   int oldFlightbSeat = (Integer) session.getAttribute("oldflightbseats");
   //System.out.print("oldseats b"+oldFlightbSeat);
   int oldFlighteSeat = (Integer) session.getAttribute("oldflighteseats");
  
   
   String flightNoStr = request.getParameter("flightno");
   int flightNo = Integer.parseInt(flightNoStr);
   double flightFare = Double.parseDouble (request.getParameter("price"));
   
   //System.out.println("new flight price "+flightFare);
   
   double oldtotalPrice = (Double) session.getAttribute("totalPrice");
   
  // System.out.println("old tot price without flight charge"+ oldtotalPrice);
   
   double totalPrice = (flightFare*booking.getNoOfPerson()) +oldtotalPrice;
   totalPrice = totalPrice + 1000;
   //System.out.println("new booking price "+totalPrice);
  // System.out.println("old booking "+booking.getTotalPrice());
  double totalPriceBalance = totalPrice - booking.getTotalPrice();
  
  //System.out.println(totalPriceBalance);
   
   //System.out.println("original "+totalPrice);
   
   FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
   FlightClass flight = flightDao.getSingleFlight(flightNo);
   
   int newFlightbSeat = flight.getBusinessClassSeat();
   int newFlighteSeat = flight.getEconomicClassSeat();
   
   if(booking.getFlightClass().equalsIgnoreCase("business class")){
	   newFlightbSeat = flight.getBusinessClassSeat() - booking.getNoOfPerson();
   }
   else{
	   newFlighteSeat = flight.getEconomicClassSeat() - booking.getNoOfPerson();
   }
   
   
   int days = Integer.parseInt(booking.getDaysPlan().substring(0, 1));
    
   BookingTableDaoImplement bookingDao = new BookingTableDaoImplement();
   
   if(totalPriceBalance>0){
  
   if(user.getWallet()>=totalPriceBalance){
	   
	   double wallet = (user.getWallet()-totalPriceBalance);
	   
	 // System.out.println("current wallet plus  "+wallet);
	   
	   boolean change = bookingDao.dateChange(booking, wallet, days, newFlightbSeat, newFlighteSeat, oldFlightbSeat, oldFlighteSeat, flight.getFlightNo(), singleBookingId, totalPrice);
	   //System.out.println("query "+singleBookingId);
%>


	<h1>Successfully Change Your Tour Date</h1>
	<br>
	<h2>
		<a href="UserPage.jsp">Go To Home</a>
	</h2>
	<%}else {
    out.println("<script type=\"text/javascript\">");
	out.println("alert('Insufficient balance !');");
	out.println("location='wallet.jsp';");
	out.println("</script>");
}
   }
   if(totalPriceBalance<=0){
	   
       double wallet = (user.getWallet()-totalPriceBalance);
       //System.out.println("current wallet minus  "+wallet);
       
	   boolean change = bookingDao.dateChange(booking, wallet, days, newFlightbSeat, newFlighteSeat, oldFlightbSeat, oldFlighteSeat, flight.getFlightNo(), singleBookingId, totalPrice);
	   %>
	<h1>Successfully Change Your Tour Date</h1>
	<br>
	<h2>
		<a href="UserPage.jsp">Go To Home</a>
	</h2>
	<%} %>




</body>
</html>