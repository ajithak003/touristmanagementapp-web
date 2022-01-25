<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.ajith.daoImplement.FlightTableDaoImplement"%>
<%@page import="com.ajith.model.FlightClass"%>
<%@page import="java.util.List"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.ajith.model.BookingClass"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>All flight</title>
<style>
body {
	background-color: aliceblue;
}

h1 {
	color: darkred;
	text-align: center;
	font-size: 50px;
	font-weight: bold;
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
}

.container {
	border: 3px solid;
	border-radius: 20px;
	height: 350px;
}

h2 {
	color: blue;
	margin-left: 250px;
	margin-top: 20px;
	font-size: 40px;
}

h3 {
	font-size: 24px;
}

img {
	width: 300px;
	height: 100px;
	margin-left: 490px;
	margin-top: -10px;
}

.depature {
	margin-left: 20px;
	position: relative;
	top: -70px;
}

.place {
	position: relative;
	top: 22pxpx;
}

.date {
	margin-left: 160px;
	margin-top: -50px;
	word-spacing: 15px;
	color: rgba(255, 217, 0, 0.925);
}

.destinations {
	margin-left: 900px;
	position: relative;
	top: -120px;
}

#button {
	margin-left: 1050px;
	width: 150px;
	height: 40px;
	border-radius: 30px;
	border: none;
	background-color: blue;
	color: white;
	font-size: 20px;
	font-weight: bold;
	position: relative;
	top: -100px;
}

.price {
	position: relative;
	top: -100px;
	margin-left: 50px;
	font-size: 20px;
	font-weight: bold;
}

span {
	color: darkorange;
}

#Economic {
	position: relative;
	left: 30px;
}

.flightno {
	visibility: hidden;
}

.noflight {
	color: darkred;
	text-align: center;
	color: black;
	font-size: 40px;
	font-weight: bold;
}
</style>


</head>
<body>

	<%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>

	<form action="hotels.jsp">
		<!-- <h3><a href="UserPage.jsp">Go To Home</a></h3> -->
		<div>

			<h1>Flights</h1>

			<% 
     DateTimeFormatter formatter =
     DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
     DateTimeFormatter format =
    	     DateTimeFormatter.ofPattern("dd-MM-yyyy");
     
     BookingClass booking =(BookingClass) session.getAttribute("booking");
   
    String depDate = request.getParameter("startdate") ;
     
		LocalDate depatureTimeDate = LocalDate.parse(depDate);
        String daysPlane = request.getParameter("noofdays");
		//System.out.println(daysPlane);
		
	int noOfPerson =Integer.parseInt( request.getParameter("noofperson"));
	//System.out.println(noOfPerson);
	
	int days = Integer.parseInt(daysPlane.substring(0, 1));
	//System.out.println(days);
	double totalPrice = booking.getTotalPrice() * days;
	//System.out.println(totalPrice);
	
	String flightClass = null;
	
        //FlightClass showAllFlight = new FlightClass();
		FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
		//System.out.println(booking.getPackageName());
		List<FlightClass> flights = flightDao.getFlightByNo(booking.getPackageName(),depatureTimeDate); 
		
		if(flights.isEmpty()){%>
			<br>
			<br>
			<p class="noflight">No Flights Available
			<p>
				<% 	}
		
		
		else
		{
		for (int i = 0; i < flights.size(); i++) {
			
			
			FlightClass flight = flights.get(i);
			if(flight.getBusinessClassSeat()>=noOfPerson || flight.getEconomicClassSeat()>=noOfPerson){	
		%>
			
			<div class="container">
				<h2><%=flight.getFlightName()%></h2>
				<div>
					<img src="https://pngimg.com/uploads/plane/plane_PNG5248.png"
						alt="">
				</div>
				<div class="depature">

					<h3 class="place"><%=flight.getDepature()%></h3>
					<%/*  LocalDate startDate = LocalDate.parse(flight.getDepatureDateTime().format(format));*/ %>
					<h3 class="date"><%=flight.getDepatureDateTime().format(formatter) %></h3>
				</div>
				<div class="destinations">
					<%String destination = flight.getDestination(); %>
					<h3 class="place" name="destination"><%=flight.getDestination() %></h3>
					<h3 class="date"><%=flight.getArrivalDateTime().format(formatter) %></h3>
				</div>
				<div class="price">

					<p>
						<% if(flight.getBusinessClassSeat()>=noOfPerson) {
            	
            	 
            %>
						<input type="radio" name="price" id="Business"
							value="<%=flight.getBusinessClassFare() %>" required
							title="please select one"><label for="">Business
							Class <span><%=flight.getBusinessClassFare() %></span>
						</label>
						<%} 
                if(flight.getEconomicClassSeat()>=noOfPerson){ 
                	 
                	
                %>

						<input type="radio" name="price" id="Economic"
							value="<%=flight.getEconomicClassFare() %>" required
							title="please select one"><label for="" id="Economic">Economic
							Class <span><%=flight.getEconomicClassFare() %></span>
						</label>
						<%} %>
					</p>

				</div>
				<div class="btn">


					<!-- <input type="button" value="Book" id="button"> -->
					<button id="button" name="flightno"
						value="<%=flight.getFlightNo()%>">Book flight</button>
				</div>

			</div>
			<br>
			<br>
		</div>

		<% } }
		}
		%>
		<% 
      
      BookingClass bookings = new  BookingClass( booking.getUser(),booking.getPackages(),null,null,noOfPerson,depatureTimeDate,totalPrice,flightClass,"",daysPlane,booking.getPackageName(),0); 
		session.setAttribute("bookings",bookings);
		
		//System.out.println("allflights "+bookings); 
		 %>
	</form>
</body>
</html>