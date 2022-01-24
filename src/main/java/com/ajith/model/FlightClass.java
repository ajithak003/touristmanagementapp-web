package com.ajith.model;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class FlightClass {

	
	private int flightNo;
	private String flightName;
	private String depature;
	private String destination;
	private LocalDateTime depatureDateTime;
	private LocalDateTime arrivalDateTime;
	private double businessClassFare;
	private double economicClassFare;
	private String status;
	private int businessClassSeat;
	private int economicClassSeat;
	
	public FlightClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlightClass(int flightNo, String flightName, String depature, String destination, LocalDateTime depatureDateTime,
			LocalDateTime arrivalDateTime, double businessClassFare, double economicClassFare, String status,int businessClassSeat, int economicClassSeat) {
		super();
		this.flightNo = flightNo;
		this.flightName = flightName;
		this.depature = depature;
		this.destination = destination;
		this.depatureDateTime = depatureDateTime;
		this.arrivalDateTime = arrivalDateTime;
		this.businessClassFare = businessClassFare;
		this.economicClassFare = economicClassFare;
		this.status = status;
		this.businessClassSeat = businessClassSeat;
		this.economicClassSeat = economicClassSeat;
	}

	public FlightClass(String flightName, String depature, String destination, LocalDateTime depatureDateTime,
			LocalDateTime arrivalDateTime, double businessClassFare, double economicClassFare, String status,int businessClassSeat, int economicClassSeat) {
		super();
		this.flightName = flightName;
		this.depature = depature;
		this.destination = destination;
		this.depatureDateTime = depatureDateTime;
		this.arrivalDateTime = arrivalDateTime;
		this.businessClassFare = businessClassFare;
		this.economicClassFare = economicClassFare;
		this.status = status;
		this.businessClassSeat = businessClassSeat;
		this.economicClassSeat = economicClassSeat;
	}
	
	
	

	public int getBusinessClassSeat() {
		return businessClassSeat;
	}

	public void setBusinessClassSeat(int businessClassSeat) {
		this.businessClassSeat = businessClassSeat;
	}

	public int getEconomicClassSeat() {
		return economicClassSeat;
	}

	public void setEconomicClassSeat(int economicClassSeat) {
		this.economicClassSeat = economicClassSeat;
	}

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getDepature() {
		return depature;
	}

	public void setDepature(String depature) {
		this.depature = depature;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDateTime getDepatureDateTime() {
		return depatureDateTime;
	}

	public void setDepatureDateTime(LocalDateTime depatureDateTime) {
		this.depatureDateTime = depatureDateTime;
	}

	public LocalDateTime getArrivalDateTime() {
		return arrivalDateTime;
	}

	public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}

	public double getBusinessClassFare() {
		return businessClassFare;
	}

	public void setBusinessClassFare(double businessClassFare) {
		this.businessClassFare = businessClassFare;
	}

	public double getEconomicClassFare() {
		return economicClassFare;
	}

	public void setEconomicClassFare(double economicClassFare) {
		this.economicClassFare = economicClassFare;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		
		
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");  
	        
		
		return "FlightClass \n flightName=" + flightName + ",\n depature=" + depature
				+ ",\n destination=" + destination + ",\n depatureDateTime=" + depatureDateTime.format(format) + ",\n arrivalDateTime="
				+ arrivalDateTime.format(format) + ",\n businessClassFare=" + businessClassFare + ",\n economicClassFare="
				+ economicClassFare + ",\n status=" + status+"\n business class seat availability= "+businessClassSeat+"\n economic class seat availablity="+economicClassSeat ;
	}

	@Override
	public int hashCode() { 
		
		return Objects.hash(arrivalDateTime, businessClassFare, depature, depatureDateTime, destination,
				economicClassFare, flightName, flightNo, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightClass other = (FlightClass) obj;
		return Objects.equals(arrivalDateTime, other.arrivalDateTime)
				&& Double.doubleToLongBits(businessClassFare) == Double.doubleToLongBits(other.businessClassFare)
				&& Objects.equals(depature, other.depature) && Objects.equals(depatureDateTime, other.depatureDateTime)
				&& Objects.equals(destination, other.destination)
				&& Double.doubleToLongBits(economicClassFare) == Double.doubleToLongBits(other.economicClassFare)
				&& Objects.equals(flightName, other.flightName) && flightNo == other.flightNo
				&& Objects.equals(status, other.status);
	}

	
    
	
	
	
	
}
