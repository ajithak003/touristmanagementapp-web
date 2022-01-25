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
	margin-left: 110px;
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
   
   BookingClass booking =(BookingClass) session.getAttribute("bookingsflight"); 
   
        String hotelId = request.getParameter("hotelid");
       // System.out.println(hotelId);
        
        double no = booking.getNoOfPerson();
        double noOfRoom  = Math.ceil(no/4);
       // System.out.println("no of rooms: "+noOfRoom);
        double hotelPrices = Double.parseDouble(request.getParameter("hotelprice"));
        double  hotelonePrice = hotelPrices*noOfRoom;
       // System.out.println("no of rooms price: "+hotelPrices);
        int days = Integer.parseInt(booking.getDaysPlan().substring(0, 1));
      //  System.out.println("no of rooms days: "+days);
        
       double hotelPrice = hotelonePrice * days;
        double totalPrice = booking.getTotalPrice()+hotelPrice;
      //  System.out.println(totalPrice);
        
        HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();
        HotelClass hotel = hotelDao.getSingleHotel(Integer.parseInt(hotelId));
       // System.out.println(hotel);
        session.setAttribute("singlehotel", hotel);
        String hotelRoomType = null;
        String room = null;
        if(hotelPrices==hotel.getPremiumPrice()){
        	/* hotelRoomType = "premimum room"; */
        	room = "premimum room";
        }
        else{        	
             room = "Standard Room";
        }
        
        UserClass user = (UserClass) session.getAttribute("user");
      //  System.out.println(user);
      //System.out.println(user.getWallet());
        
        PackageModeClass packages = (PackageModeClass) session.getAttribute("singlepackages");
      //  System.out.println(packages);
        
        FlightClass flight = (FlightClass) session.getAttribute("singleflight");
       // System.out.println(flight);
        
        double flightFare = (Double) session.getAttribute("flightfare");
       // System.out.println(flightFare);
       
       int noOfHotelRooms = (int) noOfRoom;
        
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
				<td><%=user.getName() %></td>

				<tr>
					<td>User Email Id :</td>
					<td><%=user.getEmail() %></td>

				</tr>

				<tr>
					<th><h2>Package Details</h2></th>
				</tr>
				<br>
				<td>Tour place :</td>
				<td><%=packages.getName() %></td>
				</tr>
				<tr>
					<td>one Day Night Price / person :</td>
					<td><%=packages.getPriceOneDays() %></td>
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
				<td><%=flight.getFlightName() %></td>
				</tr>
				<tr>
					<td>departure place :</td>
					<td><%=flight.getDepature() %></td>
				</tr>
				<tr>
					<td>destination place :</td>
					<td><%=flight.getDestination() %></td>
				</tr>
				<tr>
					<td>Departure Date And Time Name :</td>
					<td><%=flight.getDepatureDateTime().format(formatter) %></td>
				</tr>
				<tr>
					<td>Arrival Date And Time Name :</td>
					<td><%=flight.getArrivalDateTime().format(formatter) %></td>
				</tr>
				<tr>
					<td>Class :</td>
					<td><%=booking.getFlightClass() %></td>
				</tr>
				<tr>
					<td>Ticket Price :</td>
					<td><%=flightFare%></td>
				</tr>

				<tr>
					<th>
						<h2>Hotel Details</h2>
					</th>
				</tr>
				<td>Hotel Name :</td>
				<td><%=hotel.getHotelName() %></td>
				</tr>
				<tr>
					<td>Hotel Location :</td>

					<td><%=hotel.getLocation() %></td>
				</tr>
				<tr>
					<td>Room Type :</td>
					<td><%=room %></td>
				</tr>
				<tr>
					<td>Hotel One Day Night Price :</td>
					<td><%= hotelPrice %></td>
				</tr>
				<tr>
					<td>No Of Room :</td>
					<td><%=noOfHotelRooms  %> Room</td>
				</tr>
				<tr>
					<td><h3>Package Total Price</h3></td>
					<td><h3><%=totalPrice %></h3></td>
				</tr>
			</table>
			<button>Confirm Booking</button>


			<% 
 
BookingClass bookings = new BookingClass(user, packages,
			flight, hotel, booking.getNoOfPerson(),booking.getStartDate(), totalPrice,
			booking.getFlightClass(),room,booking.getDaysPlan(),booking.getPackageName(),noOfHotelRooms);
	
	session.setAttribute("confirmbooking", bookings);
	  
%>
		</div>
	</form>
</body>
</html>