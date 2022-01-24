package com.ajith.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class BookingClass {
	
	private int bookingId;
	private int userId;
	private int packageIid;
	private int flightNo;
	private int hotelId;
	private int noOfPerson;
	private LocalDate startDate;
	private LocalDate endDate;
	private double totalPrice;
	private String status;
	private LocalDateTime bookingDate;
	private String flightClass;
	private String hotelRoomType;
	private String daysPlan;
	private String packageName;
	private String payment;
	private double noOfRoom;
	
	
	public BookingClass(int bookingId, int userId, int packageIid, int flightNo, int hotelId, int noOfPerson, LocalDate startDate, LocalDate endDate, double totalPrice, String status, LocalDateTime bookingDate,String flightClass,String hotelRoomType, String daysPlan,String packageName,String payment,double noOfRoom) {
		super();
		// TODO Auto-generated constructor stub
		this.bookingId = bookingId;
		this.userId = userId;
		this.packageIid = packageIid;
		this.flightNo = flightNo;
		this.hotelId = hotelId;
		this.noOfPerson = noOfPerson;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPrice = totalPrice;
		this.status = status;
		this.bookingDate = bookingDate;
		this.flightClass = flightClass;
		this.hotelRoomType = hotelRoomType;
		this.daysPlan = daysPlan;
		this.packageName = packageName;
		this.payment = payment;
		this.noOfRoom = noOfRoom;
		
	}


	public BookingClass(int userId, int packageIid, int flightNo, int hotelId, int noOfPerson, LocalDate startDate, double totalPrice,String flightClass,String hotelRoomType, String daysPlan,String packageName, double noOfRoom) {
		super();
		this.userId = userId;
		this.packageIid = packageIid;
		this.flightNo = flightNo;
		this.hotelId = hotelId;
		this.noOfPerson = noOfPerson;
		this.startDate = startDate;
		this.totalPrice = totalPrice;
		this.flightClass = flightClass;
		this.hotelRoomType = hotelRoomType;
		this.daysPlan = daysPlan;
		this.packageName = packageName;
		this.noOfRoom = noOfRoom;
		
	}
	
	
	
	public double getNoOfRoom() {
		return noOfRoom;
	}


	public void setNoOfRoom(double noOfRoom) {
		this.noOfRoom = noOfRoom;
	}


	public String getPayment() {
		return payment;
	}


	public void setPayment(String payment) {
		this.payment = payment;
	}


	public String getPackageName() {
		return packageName;
	}


	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}


	public String getDaysPlan() {
		return daysPlan;
	}


	public void setDaysPlan(String daysPlan) {
		this.daysPlan = daysPlan;
	}


	public String getFlightClass() {
		return flightClass;
	}


	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}


	public String getHotelRoomType() {
		return hotelRoomType;
	}


	public void setHotelRoomType(String hotelRoomType) {
		this.hotelRoomType = hotelRoomType;
	}


	public int getBookingId() {
		return bookingId;
	}


	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getPackageIid() {
		return packageIid;
	}


	public void setPackageIid(int packageIid) {
		this.packageIid = packageIid;
	}


	public int getFlightNo() {
		return flightNo;
	}


	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}


	public int getHotelId() {
		return hotelId;
	}


	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}


	public int getNoOfPerson() {
		return noOfPerson;
	}


	public void setNoOfPerson(int noOfPerson) {
		this.noOfPerson = noOfPerson;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public LocalDateTime getBookingDate() {
		return bookingDate;
	}


	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}


	
	
	

	

	@Override
	public String toString() {
		return "BookingClass \n\n Tourist Location="+packageName+"\n startDate=" + startDate + "\n endDate=" + endDate
				+ "\n totalPrice=" + totalPrice + "\n noOfPerson=" + noOfPerson + "\n status=" + status + "\n bookingDate=" + bookingDate
				+ "\n flightClass=" + flightClass + "\n hotelRoomType=" + hotelRoomType + "\n daysPlan=" + daysPlan+"\n Payment Status :  "+payment;
	}
	
	
	public String toString1(BookingClass booking) {
		return "BookingClass \n\n Tourist Location="+packageName+"\n startDate=" + startDate + "\n endDate=" + endDate
				+ "\n totalPrice=" + totalPrice + "\n noOfPerson=" + noOfPerson + "\n status=" + "confirmed" + 
				 "\n flightClass=" + flightClass + "\n hotelRoomType=" + hotelRoomType + "\n daysPlan=" + daysPlan+"\n Payment Status :  "+payment ;
	}
	
	


	public String toStringbook(UserClass user, PackageModeClass packages, FlightClass flight, HotelClass hotel) {
		
		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");  
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
		
		return "\n Booking Details \n \n \n Customer Name :  "+user.getName()+"\n \n User Email :  "+user.getEmail()+
				"\n\n\n Flight Details : \n\n Flight Name :  "+flight.getFlightName()+"\n\n Source Place :  "+flight.getDepature()+"\n\n destination Place :  "+flight.getDestination()+
				"\n\n Depature Date & Time : "+flight.getDepatureDateTime().format(dateTimeFormat)+"\n\n Arrival Date & Time :  "+flight.getArrivalDateTime().format(dateTimeFormat)+"\n\n Flight ticket Class :  "+flightClass+
				"\n\n Flight Status :  "+flight.getStatus()+"\n\n\n Hotel Details : \n\n Hotel Name :  "+hotel.getHotelName()+"\n\n Hotel Location : "+hotel.getLocation()+
				"\n\n Hotel Room Type :  "+hotelRoomType+"\n\n\n Package Details :\n\n Booking Date :  "+bookingDate.format(dateTimeFormat)+"\n\n Tourist Location :  "+packages.getName()+
				"\n\n Tour Plan Days :  "+daysPlan+"\n\n Tour Start Date : "+startDate.format(dateFormat)+"\n\n Tour End Day :  "+endDate.format(dateFormat)+"\n\n Number Of Person :  "+noOfPerson+
				"\n\n Package Total Price :  "+totalPrice+"\n\n Package Status :  "+status+"\n\n Payment Status :  "+payment;
		
		
	}


	@Override
	public int hashCode() {
		return Objects.hash(bookingDate, bookingId, daysPlan, endDate, flightClass, flightNo, hotelId, hotelRoomType,
				noOfPerson, packageIid, packageName, startDate, status, totalPrice, userId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingClass other = (BookingClass) obj;
		return Objects.equals(bookingDate, other.bookingDate) && bookingId == other.bookingId
				&& Objects.equals(daysPlan, other.daysPlan) && Objects.equals(endDate, other.endDate)
				&& Objects.equals(flightClass, other.flightClass) && flightNo == other.flightNo
				&& hotelId == other.hotelId && Objects.equals(hotelRoomType, other.hotelRoomType)
				&& noOfPerson == other.noOfPerson && packageIid == other.packageIid
				&& Objects.equals(packageName, other.packageName) && Objects.equals(startDate, other.startDate)
				&& Objects.equals(status, other.status)
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice)
				&& userId == other.userId;
	}


	public BookingClass(int bookingId, int userId, int flightNo, LocalDate startDate) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.flightNo = flightNo;
		this.startDate = startDate;
		
	}


	
	

}
