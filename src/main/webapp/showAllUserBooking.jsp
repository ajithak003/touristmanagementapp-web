<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.ajith.model.HotelClass"%>
<%@page import="com.ajith.daoImplement.HotelTableDaoImplement"%>
<%@page import="com.ajith.model.UserClass"%>
<%@page import="com.ajith.daoImplement.UserTableDaoImplement"%>
<%@page import="com.ajith.model.BookingClass"%>
<%@page import="java.util.List"%>
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
    <title>Show All Bookings</title>

<style>
    table{
        border: 2px solid;
        border-collapse: collapse;
        background-color:mintcream;
       
    }
    tr,td,th{
        border: 2px solid;
        text-align: center;
        padding: 10px;
    }
    a{
        text-decoration: none;
    }
    h1{
        text-align: center;
        font-size: 50px;
        color:steelblue
    }

   h2{
       margin-left: 20px;
       
   }
</style>

</head>
<body>

<%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
  <h2><a href="AdminPage.jsp">Go To Home</a></h2>

    <h1>Show All Booking</h1> 
  
    <br><br>
    
    
    <table cellpading="30px" cellspacing="30px">

        <th>User Id</th>
        <th>User Name</th>
        <th>Package Name</th>
        <th>Tour Start Date</th>
        <th>Tour End Date</th>
        <th>Number Of Person</th>
        <th>No Of Days In Night</th>
        <th>Booking Date</th>
        <th>Flight Seat Class</th>
        <th>Hotel Name</th>
        <th>Hotel Room Type</th>
        <th>Total Price</th>
        <th>Payment Details</th>
        <th>Booking Status</th>


<%   DateTimeFormatter formatter =
DateTimeFormatter.ofPattern("dd-MM-yy");

       BookingTableDaoImplement bookingDao = new BookingTableDaoImplement();
       List<BookingClass> bookings = bookingDao.getAllUserBooking();
       
       for(int i=0; i<bookings.size(); i++){
         
    	   BookingClass booking = bookings.get(i); 
    	   
    	   /* UserTableDaoImplement userDao = new UserTableDaoImplement(); 
    	   UserClass user = userDao.getSingleUserById(booking.getUser().getId()); */
           
    	   /* HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();
           HotelClass hotel = hotelDao.getSingleHotel(booking.getHotel().getHotelId()); */
           
    %>
    


        <tr>
            <td><%=booking.getUser().getId() %></td>
            <td><%=booking.getUser().getName() %></td>
            <td><%=booking.getPackageName() %></td>
            <td><%=booking.getStartDate() %></td>
            <td><%=booking.getEndDate() %></td>
            <td><%=booking.getNoOfPerson() %></td>
            <td><%=booking.getDaysPlan() %></td>
            <td><%=booking.getBookingDate()		.format(formatter) %></td>
            <td><%=booking.getFlightClass() %></td>
            <td><%=booking.getHotel().getHotelName() %></td>
            <td><%=booking.getHotelRoomType() %></td>
            <td><%=booking.getTotalPrice() %></td>
            <td><%=booking.getPayment() %></td>
            <td><%=booking.getStatus() %></td>
        </tr>
        <%} %>
    </table>
</body>
</html>