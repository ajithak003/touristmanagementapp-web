package com.ajith.controler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.ajith.daoImplement.BookingTableDaoImplement;
import com.ajith.daoImplement.FlightTableDaoImplement;
import com.ajith.daoImplement.HotelTableDaoImplement;
import com.ajith.daoImplement.PackageModeClassDaoImplement;
import com.ajith.daoImplement.UserTableDaoImplement;
import com.ajith.model.BookingClass;
import com.ajith.model.FlightClass;
import com.ajith.model.HotelClass;
import com.ajith.model.PackageModeClass;
import com.ajith.model.UserClass;

public class BookingMain {

	static Scanner sc = new Scanner(System.in);

	public static void bookingInsert(UserClass user) {

		try {
			// System.out.println(user);
			UserTableDaoImplement userDao = new UserTableDaoImplement();
			UserClass userDetails = userDao.getUserById(user);
			// System.out.println(userDetails);

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			packageMain packages = new packageMain();
			List<PackageModeClass> showALLPackage = packages.showAllUserPackage();
			for (int i = 0; i < showALLPackage.size(); i++) {
				System.out.println(showALLPackage.get(i));
			}

			System.out.println("\n enter the location");
			String location = sc.nextLine();

			System.out.println("\n enter the planning date enter ");
			String planningDate = sc.nextLine(); // "2021-12-21 05:30";
			LocalDate startDate = LocalDate.parse(planningDate, formatter);

			PackageModeClass singlePackage = null;
			for (PackageModeClass p : showALLPackage) {
				if (p.getName().equalsIgnoreCase(location)) {
					singlePackage = p;
				}
			}
			System.out.println(singlePackage);
			double totalPrice = 0.0;
			
				System.out.println(
						"\n enter the days in night");
				int daysPlan = Integer.parseInt(sc.nextLine());
				String days =daysPlan+" days night";
				

					totalPrice = totalPrice + singlePackage.getPriceOneDays()*daysPlan;

			// System.out.println(totalPrice);

			FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
			List<FlightClass> flights = flightDao.getFlightByNo(location, startDate);
			for (int i = 0; i < flights.size(); i++) {

				System.out.println(flights.get(i));

			}

			System.out.println("\n choose your depature location given below available flights");
			String depatureLocation = sc.nextLine();

			FlightClass singleFlight = null;
			for (FlightClass f : flights) {
				if (f.getDepature().equalsIgnoreCase(depatureLocation)) {
					singleFlight = f;
				}
			}

			System.out.println(singleFlight);

			String flightClass = null;
			System.out.println("\n enter the 1. business class 2.economic class");
			int flightClassRate = Integer.parseInt(sc.nextLine());
            String seats=null;
			if (flightClassRate == 1) {
				flightClass = "business class";
				totalPrice = totalPrice + singleFlight.getBusinessClassFare();
				seats = "business";

			} else if (flightClassRate == 2) {
				flightClass = "economic class";
				totalPrice = totalPrice + singleFlight.getEconomicClassFare();
				seats = "economic";

			} else {
				System.out.println("please enter correct value");
			}

			// System.out.println(totalPrice);

			HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();
			List<HotelClass> hotels = hotelDao.getHotelByNo(location);
			for (int i = 0; i < hotels.size(); i++) {

				System.out.println(hotels.get(i));
			}

			System.out.println("choose the hotel name");
			String hotelName = sc.nextLine();

			HotelClass singleHotel = null;
			for (HotelClass h : hotels) {
				if (h.getHotelName().equalsIgnoreCase(hotelName) && h.getLocation().equalsIgnoreCase(location)) {
					singleHotel = h;
				}
			}

			System.out.println(singleHotel);

			String hotelRoom = null;
			boolean roomType = true;
			do {
				System.out.println("\n enter the room type 1.mid range\n 2. premium");
				int hotelRoomType = Integer.parseInt(sc.nextLine());

				if (hotelRoomType == 1) {
					hotelRoom = "mid range room";
					totalPrice = totalPrice + singleHotel.getMidRangePrice();
					roomType = false;

				} else if (hotelRoomType == 2) {
					hotelRoom = " premimum room";
					totalPrice = totalPrice + singleHotel.getPremiumPrice();
					roomType = false;
				} else {
					System.out.println("enter the correct value");
				}

			} while (roomType);

			System.out.println("total amount of 2 adult:   " + totalPrice);

			System.out.println("\n enter the number of person (above 2 person the total amount is increse)!");
			int noOfPerson = Integer.parseInt(sc.nextLine());

			if (noOfPerson > 2) {

				double price = totalPrice / 2;

				totalPrice = price * noOfPerson;
				System.out.println(noOfPerson + " total amount " + totalPrice);
			}
			 int businessClassSeats = singleFlight.getBusinessClassSeat();
	            int economicClassSeats = singleFlight.getEconomicClassSeat();
			if(seats=="business") {
				businessClassSeats = businessClassSeats-noOfPerson;
			}
			else {
				economicClassSeats = economicClassSeats - noOfPerson;
			}
			//UserTableDaoImplement userWalletDao = new UserTableDaoImplement();
		//	long currentWallet = userDao.showWalletAmount(user);

			if (userDetails.getWallet() >= totalPrice) {

				BookingTableDaoImplement bookDao = new BookingTableDaoImplement();
				BookingClass booking = null;
				
				booking = new BookingClass(userDetails.getId(), singlePackage.getPackageId(),
						singleFlight.getFlightNo(), singleHotel.getHotelId(), noOfPerson, startDate, totalPrice,
						flightClass, hotelRoom, days, location,0);
				System.out.println(booking.toString1(booking));
				boolean book = bookDao.insertbooking(booking, daysPlan,businessClassSeats,economicClassSeats);

				long wallet = userDao.showWalletAmount(userDetails);
				wallet = (long) (wallet - totalPrice);
				userDao.addWalletAmount(userDetails.getId(), wallet);
				if (book == true) {
					System.out.println("\n \n successfully booked \n\n" + "get a amazing trip");
				} else {

					System.out.println("\n unable to booking \n please try again");
				}
			}

			else {
				long wallets = userDao.showWalletAmount(userDetails);
				System.out.println(
						" Sorry! insufficient balance please add amount on your wallent \n Your Wallet Amount :  "
								+ wallets);
				System.out.println("do you want to add wallet amount 1.yes or 2.no");
				int choice = Integer.parseInt(sc.nextLine());
				if (choice == 1) {
					BookingMain.wallet(userDetails, wallets);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void wallet(UserClass userDetails, long wallet) {

		UserTableDaoImplement userDao = new UserTableDaoImplement();

		System.out.println("enter the added amount:");
		long add = Long.parseLong(sc.nextLine());
		if (add > 0) {
			long totalWalletAmount = wallet + add;

			boolean walletAdd = userDao.addWalletAmount(userDetails.getId(), totalWalletAmount);
			if (walletAdd) {
				System.out.println("transaction successfully");
				long wallets = userDao.showWalletAmount(userDetails);
				System.out.println("Your Wallet Amount :  " + wallets);
			} else {
				System.out.println("transaction failed");
			}
			System.out.println("1.go to the booking page \n 2.logout");
			int again = Integer.parseInt(sc.nextLine());
			if (again == 1) {
				BookingMain.bookingInsert(userDetails);
			}

		} else {
			System.out.println("please enter a valid amount");
		}
	}

}
