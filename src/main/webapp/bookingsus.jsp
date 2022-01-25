<%@page import="com.ajith.daoImplement.UserTableDaoImplement"%>
<%@page import="com.ajith.daoImplement.BookingTableDaoImplement"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.ajith.model.FlightClass"%>
<%@page import="com.ajith.model.PackageModeClass"%>
<%@page import="com.ajith.model.UserClass"%>
<%@page import="com.ajith.model.HotelClass"%>
<%@page import="com.ajith.daoImplement.HotelTableDaoImplement"%>
<%@page import="com.ajith.model.BookingClass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel = "icon" type = "" href = "Assets/logo.png">
<title>successfully BOOKED</title>
<style>
body{
 background-color:ivory;
}
h1{
    font-size: 40px;
    font-family: Georgia, 'Times New Roman', Times, serif;
    font-weight: bold;
    color:rgb(25, 141, 25);
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
UserClass users = (UserClass) session.getAttribute("user");
UserTableDaoImplement userDao = new UserTableDaoImplement(); 
UserClass user = userDao.getUserById(users);


BookingClass booking = (BookingClass) session.getAttribute("confirmbooking");
FlightClass flight = (FlightClass) session.getAttribute("singleflight");

int days = Integer.parseInt(booking.getDaysPlan().substring(0, 1));
//System.out.println(days);

//  System.out.println(user.getWallet() );
  
  
if (user.getWallet() >=booking.getTotalPrice() ) {
	BookingTableDaoImplement bookDao = new BookingTableDaoImplement();
	BookingClass bookings = null;
	
	BookingClass confirmBooking = new BookingClass(user, booking.getPackages(),
			booking.getFlight(), booking.getHotel(), booking.getNoOfPerson(),booking.getStartDate(), booking.getTotalPrice(),
			booking.getFlightClass(),booking.getHotelRoomType(),booking.getDaysPlan(),booking.getPackageName(),booking.getNoOfRoom());
	//System.out.println(booking.toString1(booking));
	  int businessClassSeats = flight.getBusinessClassSeat();
	  int economicClassSeats = flight.getEconomicClassSeat();
	  if(booking.getFlightClass().equalsIgnoreCase("business class")){
		  businessClassSeats = flight.getBusinessClassSeat() - booking.getNoOfPerson();
	  }
	  else{
		  economicClassSeats= flight.getEconomicClassSeat() - booking.getNoOfPerson();
	  }
	
	boolean book = bookDao.insertbooking(booking, days,businessClassSeats,economicClassSeats);

	long wallet = userDao.showWalletAmount(user);
	wallet = (long) (wallet - booking.getTotalPrice());
	userDao.addWalletAmount(user.getId(), wallet);
	if (book == true) {
		//System.out.println("\n \n successfully booked \n\n" + "get a amazing trip");
	}

}

else {
        
	out.println("<script type=\"text/javascript\">");
	out.println("alert('Insufficient balance !');");
	out.println("location='wallet.jsp';");
	out.println("</script>");
	}

%>
        <h1>Booking Successful !</h1>
        <h2><a href="UserPage.jsp">GoTo Home</a></h2>
        
</body>
</html>