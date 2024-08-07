package com.touristmgntapp.controller;

import java.time.format.DateTimeFormatter;

import com.touristmgntapp.dao.Impl.BookingTableDaoImplement;
import com.touristmgntapp.model.BookingClass;

public class EmailContent {
	
	public String getEmailContent(int bookingId) {
			
		BookingTableDaoImplement bookingDao = new BookingTableDaoImplement();
		BookingClass booking = bookingDao.getSingleBookingById(bookingId);

		double hotelfare;
		if (booking.getHotelRoomType().equalsIgnoreCase("premimum room")) {
			hotelfare = booking.getHotel().getPremiumPrice();
		} else {
			hotelfare = booking.getHotel().getMidRangePrice();
		}


		double flightfare;
		if (booking.getFlightClass().equalsIgnoreCase("economic class")) {
			flightfare = booking.getFlight().getEconomicClassFare();
		} else {
			flightfare = booking.getFlight().getBusinessClassFare();
		}
		int noOfHotelRooms = (int) booking.getNoOfRoom();
		
		EmailContent email = new EmailContent();
		String htmlContent = email.PrepareEmailContent(booking,hotelfare,flightfare,noOfHotelRooms);
		
		return htmlContent;
		
	}
	
	public String PrepareEmailContent(BookingClass booking, double hotelfare, double flightfare, int noOfHotelRooms) {
		
	
		StringBuilder htmlContent = new StringBuilder();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		String depatureDateTime = booking.getFlight().getDepatureDateTime().format(formatter);
		String arrivalDateTime = booking.getFlight().getArrivalDateTime().format(formatter);
		String bookingDate = booking.getBookingDate().format(formatter);

		htmlContent.append("</head>").append("\n")
		    .append("<body style =\" background-color: rgb(252, 250, 250);\">").append("\n")
		    .append("<form action=\"\">").append("\n")
		    .append("<h1 style =\"margin-left: 20%;color: brown; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif"
		    		+ ";font-weight: bold;\">Your Dream Trip Details</h1>").append("\n")
		    .append("<div class=\"container\" style =\" margin-left: 20%;height: 800px;\">").append("\n")
		    .append("<table aria-describedby=\"single booking details\">").append("\n")
		    .append("<tr>").append("\n")
		    .append("<th id=\"\">").append("\n")
		    .append("<h2 style =\"color: rgb(26, 87, 202);font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS',\r\n"
		    		+ "		sans-serif; \">User Details</h2>").append("\n")
		    .append("</th>").append("\n")
		    .append("</tr>").append("\n")
		    .append("<td style =\" \font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\r\n"
		    		+ "		'Lucida Sans', Arial, sans-serif\">User Name :</td>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">"+booking.getUser().getName()+"</td>").append("\n")
		    .append("<tr>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">User Email Id :</td>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">"+booking.getUser().getEmail()+"</td>").append("\n")
		    .append("</tr>").append("\n")
		    .append("<tr>").append("\n")
		    .append("<th id=\"\"><h2 style =\"color: rgb(26, 87, 202);font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS',sans-serif; \">Package Details</h2></th>").append("\n")
		    .append("</tr>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">Tour place :</td>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">"+booking.getPackages().getName()+"</td>").append("\n")
		    .append("</tr>").append("\n")
		    .append("<tr>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">one Day Night Price / person :</td>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">Rs. "+booking.getPackages().getPriceOneDays()+"</td>").append("\n")
		    .append("</tr>").append("\n")
		    .append("<tr>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">No Of Person :</td>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">"+booking.getNoOfPerson()+"</td>").append("\n")
		    .append("</tr>").append("\n")
		    .append("<tr>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">No Of Days in Night :</td>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">"+booking.getDaysPlan()+"</td>").append("\n")
		    .append("</tr>").append("\n")
		    .append("<tr>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">Tour Start Date :</td>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">"+booking.getStartDate()+"</td>").append("\n")
		    .append("</tr>").append("\n")
		    .append("<tr>").append("\n")
		    .append("<th id=\"\">").append("\n")
		    .append("<h2 style =\"color: rgb(26, 87, 202);font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS',sans-serif; \">Flight Details</h2>").append("\n")
		    .append("</th>").append("\n")
		    .append("</tr>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">Flight Name :</td>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">"+booking.getFlight().getFlightName()+"</td>").append("\n")
		    .append("</tr>").append("\n")
		    .append("<tr>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">departure place :</td>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">"+booking.getFlight().getDepature()+"</td>").append("\n")
		    .append("</tr>").append("\n")
		    .append("<tr>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">destination place :</td>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">"+booking.getFlight().getDestination()+"</td>").append("\n")
		    .append("</tr>").append("\n")
		    .append("<tr>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">Departure Date And Time Name :</td>").append("\n")

		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">"+depatureDateTime+"</td>").append("\n")
		    .append("</tr>").append("\n")
		    .append("<tr>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">Arrival Date And Time Name :</td>").append("\n")
		  
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">"+arrivalDateTime+"</td>").append("\n")
		    .append("</tr>").append("\n")
		    .append("<tr>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">Class :</td>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">"+booking.getFlightClass()+"</td>").append("\n")
		    .append("</tr>").append("\n")
		    .append("<tr>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">Ticket Price :</td>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">Rs. "+flightfare+"</td>").append("\n")
		    .append("</tr>").append("\n")
		    .append("<tr>").append("\n")
		    .append("<th id=\"\">").append("\n")
		    .append("<h2 style =\"color: rgb(26, 87, 202);font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS',sans-serif; \">Hotel Details</h2>").append("\n")
		    .append("</th>").append("\n")
		    .append("</tr>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">Hotel Name :</td>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">"+booking.getHotel().getHotelName()+"</td>").append("\n")
		    .append("</tr>").append("\n")
		    .append("<tr>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">Hotel Location :</td>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">"+booking.getHotel().getLocation()+"</td>").append("\n")
		    .append("</tr>").append("\n")
		    .append("<tr>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">Room Type :</td>").append("\n")
		    .append("<td style =\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\">"+booking.getHotelRoomType()+"</td>").append("\n")
		    .append("</tr>").append("\n")
		    .append("<tr>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">Hotel One Day Night Price :</td>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">Rs. "+hotelfare+"</td>").append("\n")
		    .append("</tr>").append("\n")
		    .append("<tr>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">No Of Room :</td>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">"+noOfHotelRooms+" Room</td>").append("\n")
		    .append("</tr>").append("\n")
		    .append("<tr>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">Booking Date :</td>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\">"+bookingDate+"</td>").append("\n")
		    .append("</tr>").append("\n")
		    .append("<tr>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\"><h3 style =\"color: darkgreen;\">Package Total Price</h3></td>").append("\n")
		    .append("<td style =\\\" \\font-weight: bold;font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',\\r\\n\"\r\n"
		    		+ "		    		+ \"		'Lucida Sans', Arial, sans-serif\\\"><h3 style =\"color: darkgreen;\">Rs. "+booking.getTotalPrice()+"</h3></td>").append("\n")
		    .append("</tr>").append("\n")
		    .append("</table>").append("\n")
		    .append("</div>").append("\n")
		    .append("</form>").append("\n")
		    .append("</body>").append("\n")
		    .append("</html>");

		
		return htmlContent.toString();
	}

}
