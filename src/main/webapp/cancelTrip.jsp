<%@page import="com.ajith.model.FlightClass"%>
<%@page import="com.ajith.daoImplement.FlightTableDaoImplement"%>
<%@page import="com.ajith.model.UserClass"%>
<%@page import="com.ajith.daoImplement.UserTableDaoImplement"%>
<%@page import="com.ajith.model.BookingClass"%>
<%@page import="com.ajith.daoImplement.BookingTableDaoImplement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel = "icon" type = "" href = "Assets/logo.png">
    <title>cancel Booking</title>
<style>
body{
    background-color: silver;
}
h1{
    font-size: 40px;
    font-family: Georgia, 'Times New Roman', Times, serif;
    font-weight: bold;
    color: slateblue;
    text-align: center;
    margin-top: 18%;
}
h2,a{
    text-align: center;
    text-decoration: none;
}

</style>

</head>
<body>


<%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
  
      <%
      
       String bookingid  = request.getParameter("bookingid");
      
       //System.out.print(bookingid);
       int bookingId  = Integer.parseInt(bookingid);
       BookingTableDaoImplement cancel = new BookingTableDaoImplement();
	   BookingClass book = cancel.getSingleBookingById(bookingId);
	   	    
	    UserTableDaoImplement userDao = new UserTableDaoImplement(); 
	    UserClass  userDetails= (UserClass) session.getAttribute("user");
	    UserClass user = userDao.getUserById(userDetails);
		//System.out.println(user);
	
		if(book.getStatus().equalsIgnoreCase("cancel")) {
			//System.out.println("this package already canceled");
			%><h1><%="Your Booking Already Canceled" %></h1>
			<h2><%="please wait! Your Payment Refund within 3 working days "%></h2>
			<h2><a href="showAllBooking.jsp">Go To My Booking</a></h2>
			<%
		}
		else {
		
			double fine = (book.getTotalPrice()/100)*10;
			double refund = book.getTotalPrice() - fine ;
		double refundPrice =  user.getWallet()+ refund;
		//refundPrice = (refundPrice/100)*10;
		
		FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
	    FlightClass flight = flightDao.getSingleFlight(book.getFlightNo());
	 
	    int businessSeats = flight.getBusinessClassSeat() ;
	    int economicSeats =flight.getEconomicClassSeat();
	    if(book.getFlightClass().equalsIgnoreCase("business class")) {
	    	businessSeats += book.getNoOfPerson();
	    }
	    else {
	    	economicSeats += +book.getNoOfPerson();
	    }
	    
		boolean cancelBooking = cancel.updatebooking(user.getId(),book.getStartDate(),refundPrice,businessSeats,economicSeats,book.getFlightNo(),book.getBookingId());
		
		
		if(cancelBooking==true) {
			
		//	System.out.println("successfully canceled");
			%><h1><%="Cancel Successful"%></h1>
			<h2><%="Your Payment Refund within 3 working days"%></h2>
			<h2><a href="showAllBooking.jsp">Go To My Booking</a></h2>
			 <%
			
		}
		else {
			//System.out.println("unable to cancel your booking please try again later");
		}
		}%>
	
    
    
</body>
 

</html>