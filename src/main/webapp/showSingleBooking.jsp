<%@page import="com.ajith.daoImplement.FlightTableDaoImplement"%>
<%@page import="com.ajith.daoImplement.PackageModeClassDaoImplement"%>
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
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>Confirm Booking</title>

<style>
body {
	background-color: rgb(252, 250, 250);
}

.container {
	margin-left: 33%;
	height: 1550px;
}

h1 {
	text-align: center;
	color: brown;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	font-weight: bold;
}

h2 {
	color: rgb(26, 87, 202);
	font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS',
		sans-serif;
}

td {
	font-weight: bold;
	font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',
		'Lucida Sans', Arial, sans-serif;
}

h3 {
	color: darkgreen;
}

button {
	width: 200px;
	height: 40px;
	background-color: red;
	color: rgb(252, 250, 250);
	border-radius: 25px;
	font-size: 16px;
	font-weight: bold;
	font-family: Verdana, Geneva, Tahoma, sans-serif;
	border: none;
	margin-left: 350px;
	margin-top: 20px;
}
</style>

</head>
<body>
	<%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>

	<form action="bookingsus.jsp">

		<h1>Booking Details</h1>

		<%  DateTimeFormatter formatter =
		     DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
   
   int bookingId = Integer.parseInt( request.getParameter("bookingid"));
   BookingTableDaoImplement bookingDao = new BookingTableDaoImplement();
   BookingClass booking = bookingDao.getSingleBookingById(bookingId); 
   
       
        
       /*  HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();
        HotelClass hotel = hotelDao.getSingleHotel(booking.getHotelId());*/
        double hotelfare = 0.0;
        if(booking.getHotelRoomType().equalsIgnoreCase("premimum room")){
        	hotelfare = booking.getHotel().getPremiumPrice();
        }
        else{
        	hotelfare = booking.getHotel().getMidRangePrice();
        }
      
        /* UserTableDaoImplement userDao = new UserTableDaoImplement();
        UserClass user = userDao.getSingleUserById(booking.getUser()); */
      //  System.out.println(user);
      //System.out.println(user.getWallet());
        //PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();
       // PackageModeClass packages = packageDao.getPackageByNo(booking.getPackageName());
      //  System.out.println(packages);
        //FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
        //FlightClass flight = flightDao.getSingleFlight(booking.getFlightNo());
       // System.out.println(flight);
      double flightfare =0.0;
       if(booking.getFlightClass().equalsIgnoreCase("economic class")){
    	   flightfare = booking.getFlight().getEconomicClassFare();
       }
       else{
    	   flightfare = booking.getFlight().getBusinessClassFare();
       }
       
       int noOfHotelRooms = (int) booking.getNoOfRoom();
        
        %>



		<div class="container">
			<table cellpadding="10px" cellspacing="10px">
				<tr>
					<th>
						<h2>User Details</h2>
					</th>
				</tr>
				<br>

				<td>User Name :</td>
				<td><%=booking.getUser().getName() %></td>

				<tr>
					<td>User Email Id :</td>
					<td><%=booking.getUser().getEmail() %></td>

				</tr>

				<tr>
					<th><h2>Package Details</h2></th>
				</tr>
				<br>
				<td>Tour place :</td>
				<td><%=booking.getPackages().getName() %></td>
				</tr>
				<tr>
					<td>one Day Night Price / person :</td>
					<td><%=booking.getPackages().getPriceOneDays() %></td>
				</tr>
				<tr>
					<td>No Of Person :</td>
					<td><%=booking.getNoOfPerson() %></td>
				</tr>
				<tr>
					<td>No Of Days in Night :</td>
					<td><%=booking.getDaysPlan() %></td>
				</tr>
				<tr>
					<td>Tour Start Date :</td>
					<td><%=booking.getStartDate() %></td>
				</tr>

				<tr>
					<th>
						<h2>Flight Details</h2>
					</th>
				</tr>
				<br>
				<td>Flight Name :</td>
				<td><%=booking.getFlight().getFlightName() %></td>
				</tr>
				<tr>
					<td>departure place :</td>
					<td><%=booking.getFlight().getDepature() %></td>
				</tr>
				<tr>
					<td>destination place :</td>
					<td><%=booking.getFlight().getDestination() %></td>
				</tr>
				<tr>
					<td>Departure Date And Time Name :</td>
					<td><%=booking.getFlight().getDepatureDateTime().format(formatter) %></td>
				</tr>
				<tr>
					<td>Arrival Date And Time Name :</td>
					<td><%=booking.getFlight().getArrivalDateTime().format(formatter) %></td>
				</tr>
				<tr>
					<td>Class :</td>
					<td><%=booking.getFlightClass() %></td>
				</tr>
				<tr>
					<td>Ticket Price :</td>
					<td><%=flightfare%></td>
				</tr>

				<tr>
					<th>
						<h2>Hotel Details</h2>
					</th>
				</tr>
				<td>Hotel Name :</td>
				<td><%=booking.getHotel().getHotelName() %></td>
				</tr>
				<tr>
					<td>Hotel Location :</td>

					<td><%=booking.getHotel().getLocation() %></td>
				</tr>
				<tr>
					<td>Room Type :</td>
					<td><%=booking.getHotelRoomType() %></td>
				</tr>
				<tr>
					<td>Hotel One Day Night Price :</td>
					<td><%=hotelfare %></td>
				</tr>
				<tr>
					<td>No Of Room :</td>
					<td><%=noOfHotelRooms %> Room</td>
				</tr>
				<tr>
					<td><h3>Package Total Price</h3></td>
					<td><h3><%=booking.getTotalPrice() %></h3></td>
				</tr>
			</table>


		</div>
	</form>
</body>
</html>