package com.ajith.controler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.ajith.daoImplement.FlightTableDaoImplement;
import com.ajith.model.FlightClass;


public class FlightMain {
	
	public void flights() {
	
	do {	
	Scanner sc = new Scanner (System.in);
	System.out.println("enter your choice 1.add flight 2.update flight 3.delete flight 4.show all flight 5.logout");
	int choice = Integer.parseInt(sc.nextLine());
	
	switch(choice) {
	
	
	//public void flightInsert() {
	case 1:	
		try {
		
		DateTimeFormatter formatter =
	            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		System.out.println("enter flight name ");
		String flightName = sc.nextLine();
		System.out.println("enter flight depature place ");
		String depature = sc.nextLine();
		System.out.println("enter flight destination place ");
		String destination = sc.nextLine();
		System.out.println("enter flight depature date time place ");
		String depDate = sc.nextLine(); //"2021-12-21 05:30";
		LocalDateTime depatureTimeDate = LocalDateTime.parse(depDate, formatter);
		
		System.out.println("enter flight arrival date time place ");
		String desDate =sc.nextLine() ;//"2021-12-26 03:45"
		LocalDateTime arrivalTimeDate = LocalDateTime.parse(desDate, formatter);
		
		System.out.println("enter the business class fare");
		double businessClassFare = Double.parseDouble(sc.nextLine());
		System.out.println("enter the economic class fare");
		double economicClassFare = Double.parseDouble(sc.nextLine());
		System.out.println("enter status");
		String status = sc.nextLine();
		System.out.println("enter business class seats no:");
		int businessClassSeats = Integer.parseInt(sc.nextLine());
		System.out.println("enter economic class seats no:");
		int economicClassSeats = Integer.parseInt(sc.nextLine());
		
		FlightClass flight = new FlightClass(flightName,depature,destination,depatureTimeDate,arrivalTimeDate,businessClassFare,economicClassFare,status,businessClassSeats,economicClassSeats);
		//System.out.println(flight.getArrivalDateTime());
		FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
		boolean insert = flightDao.insertFlight(flight);
		if(insert==true) {
			System.out.println("insert successfully");
		}
		else {
			System.out.println("enter the correct values");
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		break;
	//}
	
	//public void flightUpdate(){
	case 2:
		
		try {
			
			DateTimeFormatter formatter =
		            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			System.out.println("enter the flight no");
			int flightNo = Integer.parseInt(sc.nextLine());
			System.out.println("enter flight name ");
			String flightName = sc.nextLine();
			System.out.println("enter flight depature place ");
			String depature = sc.nextLine();
			System.out.println("enter flight destination place ");
			String destination = sc.nextLine();
			System.out.println("enter flight depature date time place ");
			String depDate = sc.nextLine(); //"2021-12-21 05:30";
			LocalDateTime depatureTimeDate = LocalDateTime.parse(depDate, formatter);
			
			System.out.println("enter flight arrival date time place ");
			String desDate =sc.nextLine() ;//"2021-12-26 03:45"
			LocalDateTime arrivalTimeDate = LocalDateTime.parse(desDate, formatter);
			
			System.out.println("enter the business class fare");
			double businessClassFare = Double.parseDouble(sc.nextLine());
			System.out.println("enter the economic class fare");
			double economicClassFare = Double.parseDouble(sc.nextLine());
			System.out.println("enter status");
			String status = sc.nextLine();
			System.out.println("enter business class seats no:");
			int businessClassSeats = Integer.parseInt(sc.nextLine());
			System.out.println("enter economic class seats no:");
			int economicClassSeats = Integer.parseInt(sc.nextLine());
			
			FlightClass flight = new FlightClass(flightName,depature,destination,depatureTimeDate,arrivalTimeDate,businessClassFare,economicClassFare,status,businessClassSeats,economicClassSeats);
			//System.out.println(flight.getArrivalDateTime());
			FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
			boolean update = flightDao.updateFlight(flight);
			if(update==true) {
				System.out.println("update successfully");
			}
			else {
				System.out.println("enter the correct values");
			}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		break;
	//}
	
	//public void deleteFlight() {
case 3:
		
		try {
			System.out.println("enter the flight no ");
			int flightNo = Integer.parseInt(sc.nextLine());
		        
			FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
			boolean delete = flightDao.deleteFlight(flightNo);
			if(delete==true){
				System.out.println("delete successfull");
			}
			else {
				System.out.println("please enter the correct value");
			}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		break;
	//}
	
//	public void showAllFlights() {
	case 4:
		
		try {
			
			FlightClass showAllFlight = new FlightClass();
			FlightTableDaoImplement flightDao = new FlightTableDaoImplement();

			List<FlightClass> flights = flightDao.getAllFlight();
			
			LocalDateTime datetime1 = LocalDateTime.now();  
		    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");  
		     
		    
			// System.out.println("second");
			for (int i = 0; i < flights.size(); i++) {

				System.out.println(flights.get(i));
				//System.out.println(flights.g);

			}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		break;
	case 5:
		System.exit(0);
		//}
	}
	}while(true);
	}
	}
	


