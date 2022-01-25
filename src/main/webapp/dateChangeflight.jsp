<%@page import="com.ajith.model.UserClass"%>
<%@page import="com.ajith.daoImplement.UserTableDaoImplement"%>
<%@page import="com.ajith.model.FlightClass"%>
<%@page import="java.util.List"%>
<%@page import="com.ajith.daoImplement.FlightTableDaoImplement"%>
<%@page import="com.ajith.model.BookingClass"%>
<%@page import="com.ajith.daoImplement.BookingTableDaoImplement"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>date change feature plane</title>
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
</style>

</head>
<body>

	<%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>

	<form action="confirmdatechange.jsp">
		<div>
			<h1>Flights</h1>
			<%
      
DateTimeFormatter formatter =
	            DateTimeFormatter.ofPattern("yyyy-MM-dd");
      
    BookingTableDaoImplement book = new BookingTableDaoImplement();
    
    UserClass user = (UserClass) session.getAttribute("user");
   
    //int bookingId = Integer.parseInt(request.getParameter("bookingid"));
    int bookingId =(Integer) session.getAttribute("datechangeid");
  //  System.out.println("date change page "+bookingId);
    //int bookingId = Integer.parseInt(bookingIds);
    
    BookingClass bookingpackage = 	book.getSingleBookingById(bookingId);
    
    String date = request.getParameter("changedate");
    LocalDate startDate = LocalDate.parse(date);
    //System.out.println(startDate);

	FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
	
	//FlightClass singleFlight = flightDao.getSingleFlight(bookingpackage.getFlightNo());
	double oldFlightPrice = 0.0;
	int bseats = bookingpackage.getFlight().getBusinessClassSeat();
	//System.out.println("bseats"+singleFlight.getBusinessClassSeat()+""+singleFlight.getFlightNo());
	int eseats =bookingpackage.getFlight().getEconomicClassSeat();
	
	if(bookingpackage.getFlightClass().equalsIgnoreCase("business class")){
		oldFlightPrice =  bookingpackage.getFlight().getBusinessClassFare()*bookingpackage.getNoOfPerson();
		bseats = bookingpackage.getFlight().getBusinessClassSeat()+bookingpackage.getNoOfPerson();
		//System.out.println("bseats"+bseats);
	}
	else if(bookingpackage.getFlightClass().equalsIgnoreCase("economic class")){
		oldFlightPrice = bookingpackage.getFlight().getEconomicClassFare()*bookingpackage.getNoOfPerson();
		eseats = bookingpackage.getFlight().getEconomicClassSeat()+bookingpackage.getNoOfPerson();
		//System.out.println("eseats"+eseats);
	}
	
	//System.out.println("old flight "+singleFlight.getBusinessClassFare());
	double totalPrice = bookingpackage.getTotalPrice()-oldFlightPrice;
	session.setAttribute("totalPrice",totalPrice );
	
	session.setAttribute("oldflightbseats", bseats);
	session.setAttribute("oldflighteseats", eseats);
	
		List<FlightClass> flights =flightDao.getFlightByNo(bookingpackage.getPackageName(), startDate);
		for (int i = 0; i < flights.size(); i++) {
			
			FlightClass flight = flights.get(i);
			
			if(flight.getBusinessClassSeat()>=bookingpackage.getNoOfPerson() || flight.getEconomicClassSeat()>=bookingpackage.getNoOfPerson()){	
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
						<% if(bookingpackage.getFlightClass().equalsIgnoreCase("business class")){
            
            if(flight.getBusinessClassSeat()>=bookingpackage.getNoOfPerson()) {            %>
						<input type="radio" name="price" id="Business"
							value="<%=flight.getBusinessClassFare() %>" required><label
							for="">Business Class <span><%=flight.getBusinessClassFare() %></span></label>
						<%} } %>
					</p>

					<p>
						<% if(bookingpackage.getFlightClass().equalsIgnoreCase("economic class")){
            
            if(flight.getBusinessClassSeat()>=bookingpackage.getNoOfPerson()) {            %>
						<input type="radio" name="price" id="Business"
							value="<%=flight.getEconomicClassFare()%>" required><label
							for="">Economic Class <span><%=flight.getEconomicClassFare() %></span></label>
						<%} } %>
					</p>

				</div>
				<div class="btn">
					<button id="button" name="flightno"
						value="<%=flight.getFlightNo()%>">Book flight</button>
				</div>

			</div>
			<br>
			<br>
		</div>

		<% }
		}	 %>
		<% 
      
      BookingClass bookings = new  BookingClass( bookingpackage.getUser(),bookingpackage.getPackages(),bookingpackage.getFlight(),bookingpackage.getHotel(),bookingpackage.getNoOfPerson(),
    		  startDate,bookingpackage.getTotalPrice(),bookingpackage.getFlightClass(),bookingpackage.getHotelRoomType(),bookingpackage.getDaysPlan(),bookingpackage.getPackageName(),bookingpackage.getNoOfRoom()); 
		session.setAttribute("datechangebookings",bookings); 
		
		//System.out.println("allflights "+bookings); %>
	</form>

</body>
</html>