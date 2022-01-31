package com.touristMgntApp.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class BookingClass implements Serializable {
	
	private int bookingId;
	private UserClass user;
	private PackageModeClass packages;
	private FlightClass flight;
	private HotelClass hotel;
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
	
	
	public BookingClass(int bookingId, UserClass user, PackageModeClass packages, FlightClass flight, HotelClass hotel, int noOfPerson, LocalDate startDate, LocalDate endDate, double totalPrice, String status, 
			LocalDateTime bookingDate,String flightClass,String hotelRoomType, String daysPlan,String packageName,String payment,double noOfRoom) {
		super();
		this.bookingId = bookingId;
		this.user = user;
		this.packages = packages;
		this.flight = flight;
		this.hotel = hotel;
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


	public BookingClass(UserClass user, PackageModeClass packages, FlightClass flight, HotelClass hotel, int noOfPerson, LocalDate startDate, double totalPrice,String flightClass,String hotelRoomType, String daysPlan,String packageName, double noOfRoom) {
		super();
		this.user = user;
		this.packages = packages;
		this.flight = flight;
		this.hotel = hotel;
		this.noOfPerson = noOfPerson;
		this.startDate = startDate;
		this.totalPrice = totalPrice;
		this.flightClass = flightClass;
		this.hotelRoomType = hotelRoomType;
		this.daysPlan = daysPlan;
		this.packageName = packageName;
		this.noOfRoom = noOfRoom;
		
	}

	

	public int getBookingId() {
		return bookingId;
	}


	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}


	public UserClass getUser() {
		return user;
	}


	public void setUser(UserClass user) {
		this.user = user;
	}


	public PackageModeClass getPackages() {
		return packages;
	}


	public void setPackages(PackageModeClass packages) {
		this.packages = packages;
	}


	public FlightClass getFlight() {
		return flight;
	}


	public void setFlight(FlightClass flight) {
		this.flight = flight;
	}


	public HotelClass getHotel() {
		return hotel;
	}


	public void setHotel(HotelClass hotel) {
		this.hotel = hotel;
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


	public String getDaysPlan() {
		return daysPlan;
	}


	public void setDaysPlan(String daysPlan) {
		this.daysPlan = daysPlan;
	}


	public String getPackageName() {
		return packageName;
	}


	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}


	public String getPayment() {
		return payment;
	}


	public void setPayment(String payment) {
		this.payment = payment;
	}


	public double getNoOfRoom() {
		return noOfRoom;
	}


	public void setNoOfRoom(double noOfRoom) {
		this.noOfRoom = noOfRoom;
	}
	
	
	@Override
	public String toString() {
		return "BookingClass [bookingId=" + bookingId + ", user=" + user + ", packages=" + packages + ", flight="
				+ flight + ", hotel=" + hotel + ", noOfPerson=" + noOfPerson + ", startDate=" + startDate + ", endDate="
				+ endDate + ", totalPrice=" + totalPrice + ", status=" + status + ", bookingDate=" + bookingDate
				+ ", flightClass=" + flightClass + ", hotelRoomType=" + hotelRoomType + ", daysPlan=" + daysPlan
				+ ", packageName=" + packageName + ", payment=" + payment + ", noOfRoom=" + noOfRoom + "]";
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
		return Objects.hash(bookingDate, bookingId, daysPlan, endDate, flight, flightClass, hotel, hotelRoomType,
				noOfPerson, noOfRoom, packageName, packages, payment, startDate, status, totalPrice, user);
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
				&& Objects.equals(flight, other.flight) && Objects.equals(flightClass, other.flightClass)
				&& Objects.equals(hotel, other.hotel) && Objects.equals(hotelRoomType, other.hotelRoomType)
				&& noOfPerson == other.noOfPerson
				&& Double.doubleToLongBits(noOfRoom) == Double.doubleToLongBits(other.noOfRoom)
				&& Objects.equals(packageName, other.packageName) && Objects.equals(packages, other.packages)
				&& Objects.equals(payment, other.payment) && Objects.equals(startDate, other.startDate)
				&& Objects.equals(status, other.status)
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice)
				&& Objects.equals(user, other.user);
	}


	public BookingClass(int bookingId, UserClass user, FlightClass flight, LocalDate startDate) {
		super();
		this.bookingId = bookingId;
		this.user = user;
		this.flight = flight;
		this.startDate = startDate;
		
	}


	
	

}
