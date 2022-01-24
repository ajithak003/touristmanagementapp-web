package com.ajith.controler;

import java.util.List;
import java.util.Scanner;

import com.ajith.daoImplement.HotelTableDaoImplement;
import com.ajith.model.HotelClass;

public class HotelMain {
	
	
	public void hotels() {
		
		do {	
		Scanner sc = new Scanner (System.in);
		System.out.println("enter your choice 1.add hotel 2.update hotel 3.delete hotel 4.show all hotels 5.logout");
		int choice = Integer.parseInt(sc.nextLine());
		
		switch(choice) {
		
		
		//public void flightInsert() {
		case 1:	
			try {
			
			System.out.println("enter hotels name ");
			String hotelName = sc.nextLine();
			System.out.println("enter hotel location ");
			String location = sc.nextLine();
			System.out.println("enter hotel room mid range price ");
			double midRangePrice =Double.parseDouble(sc.nextLine());
			System.out.println("enter hotel room primium range price");
			double premiumRangePrice = Double.parseDouble(sc.nextLine());
			
			HotelClass hotel = new HotelClass(location,hotelName,midRangePrice,premiumRangePrice,null);
			//System.out.println(hotel);
			HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();
			boolean insert = hotelDao.insertHotel(hotel);
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
				System.out.println("enter the hotel id");
				int hotelId = Integer.parseInt(sc.nextLine());
				System.out.println("enter hotels name ");
				String hotelName = sc.nextLine();
				System.out.println("enter hotel location ");
				String location = sc.nextLine();
				System.out.println("enter hotel room mid range price ");
				double midRangePrice =Double.parseDouble(sc.nextLine());
				System.out.println("enter hotel room primium range price");
				double primiumRangePrice = Double.parseDouble(sc.nextLine());
				
				HotelClass hotel = new HotelClass(hotelId,hotelName,location,midRangePrice,primiumRangePrice,null);
				
				HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();
				boolean insert = hotelDao.updateHotel(hotel);
				if(insert==true) {
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
				System.out.println("enter the hetel id ");
				int hetelId = Integer.parseInt(sc.nextLine());
			        
				HotelTableDaoImplement hetelDao = new HotelTableDaoImplement();
				boolean delete = hetelDao.deleteHotel(hetelId);
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
		
//		public void showAllFlights() {
		case 4:
			
			try {
				
				HotelClass showAllFlight = new HotelClass();
				HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();

				List<HotelClass> hotel = hotelDao.getAllHotel();

				for (int i = 0; i < hotel.size(); i++) {
			

					System.out.println(showAllFlight.usertoString(hotel.get(i)));

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
