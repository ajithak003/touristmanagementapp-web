<%@page import="com.ajith.daoImplement.FlightTableDaoImplement"%>
<%@page import="com.ajith.model.FlightClass"%>
<%@page import="com.ajith.model.HotelClass"%>
<%@page import="java.util.List"%>
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
<title>All Hotels</title>


<style>
body {
	background-color: rgb(243, 221, 167);
}

h1 {
	text-align: center;
	font-size: 40px;
	font-family: Verdana, Geneva, Tahoma, sans-serif;
	font-weight: bold;
	color: yellowgreen;
}

.container {
	border: 3px;
	border-style: solid;
	border-radius: 30px;
	padding: 35px;
	height: 350px;
}

img {
	position: relative;
	height: 350px;
	width: 400px;
}

.name {
	position: relative;
	margin-left: 450px;
	margin-top: -325px;
}

.hotelname {
	position: relative;
	margin-left: 300px;
	margin-top: -37px;
}

.location {
	position: relative;
	margin-left: 455px;
	margin-top: 60px;
}

.locationname {
	position: relative;
	margin-left: 300px;
	margin-top: -37px;
}

.radio {
	position: relative;
	top: 50px;
	margin-left: 450px;
	font-size: 20px;
	font-weight: bold;
}

span {
	color: orangered;
}

#Premium {
	position: relative;
	left: 50px;
}

button {
	position: relative;
	top: 70px;
	margin-left: 1050px;
	height: 50px;
	width: 130px;
	background-color: royalblue;
	border-radius: 50px;
	border: none;
	font-size: 18px;
	color: white;
	font-family: monospace;
	font-weight: bold;
}
</style>
</head>
<body>

	<%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>

	<form action="booking.jsp">
		<!-- <h3><a href="UserPage.jsp">Go To Home</a></h3> -->
		<h1>Hotels</h1>
		<br>
		<br>

		<% BookingClass booking =(BookingClass) session.getAttribute("bookings"); 
    //System.out.println(booking);
        String flightNoStr = request.getParameter("flightno");
        int flightNo = Integer.parseInt(flightNoStr);
        
        double flightFare = Double.parseDouble (request.getParameter("price"));
        //System.out.println(flightFare);
        session.setAttribute("flightfare", flightFare);
        
        FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
        FlightClass flight = flightDao.getSingleFlight(flightNo);
        session.setAttribute("singleflight", flight);
        String flightClass="";
        if(flightFare==flight.getBusinessClassFare()){
        	flightClass = "business class";
        }
        else{
        	 flightClass = "economic class";
        }
       // System.out.println(flight);
       double totalPrice = (booking.getTotalPrice()+flightFare) * booking.getNoOfPerson();
       
       //System.out.println(totalPrice);
       
        session.setAttribute("flight", flight);
       
        HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();
        List<HotelClass> hotels = hotelDao.getHotelByNo(booking.getPackageName());
        
        String hotelRoomType = null;
        
for (int i = 0; i < hotels.size(); i++) {
			
			
	HotelClass hotel = hotels.get(i);
	
	//System.out.println(hotel);	
        	
    %>

		<div class="container">
			<div>
				<img src="Assets/<%=hotel.getImage()%>" alt="">
				<div class="name">
					<h3>Hotel Name :</h3>
					<h3 class="hotelname"><%=hotel.getHotelName()%></h3>
				</div>
				<div class="location">
					<h3>Location :</h3>
					<h3 class="locationname">
						<%=hotel.getLocation() %></h3>
				</div>
				<div class="radio">
					<p>
						<%  {
            	
            	
            %>
						<input type="radio" name="hotelprice" id="Normal"
							value="<%=hotel.getMidRangePrice() %>" required><label
							for="">Normal Room <span><%=hotel.getMidRangePrice()%></span></label>
						<%} 
                { 
                	 
                	
                %>
						<input type="radio" name="hotelprice" id="Premium"
							value="<%=hotel.getPremiumPrice() %>" required><label
							for="" id="Premium">Premium Room <span><%=hotel.getPremiumPrice()%></span></label>
						<%} %>
					</p>
				</div>
				<button id="button" name="hotelid" value="<%=hotel.getHotelId() %>">Book
					hotel</button>
			</div>

		</div>
		<br>
		<br>
		<%}%>
		<% 
			 
			 
			// System.out.println(totalPrice);
      BookingClass bookings = new  BookingClass( booking.getUser(),booking.getPackages(),booking.getFlight(),null,booking.getNoOfPerson(),booking.getStartDate(),totalPrice,flightClass,"",booking.getDaysPlan(),booking.getPackageName(),0); 
		session.setAttribute("bookingsflight",bookings);
		
		//System.out.println("hotelpage "+bookings); %>

	</form>
</body>
</html>