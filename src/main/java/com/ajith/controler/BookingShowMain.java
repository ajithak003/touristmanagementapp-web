	package com.ajith.controler;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.ajith.daoImplement.AdminTableDaoImplement;
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

public class BookingShowMain {
	
	static Scanner sc = new Scanner(System.in);
	
	public void show(UserClass user) {
		try {
		UserTableDaoImplement userDao = new UserTableDaoImplement(); 
			UserClass userDetails = userDao.getUserById(user);
			//System.out.println(user);
		System.out.println("enter the tour starting date : ");
		String startDatestr = sc.nextLine();
		LocalDate startDate = LocalDate.parse(startDatestr);
		BookingClass booking =null;
		BookingTableDaoImplement book = new BookingTableDaoImplement();
		booking = book.getbookingById(userDetails.getId(), startDate);
		//System.out.println(booking);
		
		PackageModeClassDaoImplement pack = new PackageModeClassDaoImplement();
		PackageModeClass pakages =pack.getSinglePackage(booking.getPackageName());
		//System.out.println(pakages);
		
		FlightTableDaoImplement flights = new FlightTableDaoImplement();
		FlightClass flight = flights.getSingleFlight(booking.getFlightNo());
		//System.out.println(flight);
		
		HotelTableDaoImplement hotels = new HotelTableDaoImplement();
		HotelClass hotel = hotels.getSingleHotel(booking.getHotelId());
		//System.out.println(hotel);
		
		System.out.println(booking.toStringbook(userDetails, pakages, flight, hotel));
		
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	public void cancelBooking(UserClass user) {
		
		try {
			
			System.out.println("do you want to cancel your Tourist Package 1.yes 2.no\n"
					+ "Notes : if you cancel your package 10% of totoal price dected and balance amount refunded 2-3 working days");
			int cancels = Integer.parseInt(sc.nextLine());
			if(cancels==1) {
			UserTableDaoImplement userDao = new UserTableDaoImplement(); 
				UserClass userDetails = userDao.getUserById(user);
				
				System.out.println("enter the tour starting date : ");
				String startDatestr = sc.nextLine();
				LocalDate startDate = LocalDate.parse(startDatestr);
				
				BookingTableDaoImplement cancel = new BookingTableDaoImplement();
				BookingClass book = cancel.getbookingById(user.getId(), startDate);
				if(book.getStatus().equalsIgnoreCase("cancel")) {
					System.out.println("this package already canceled");
				}
				else {
				
				double refundPrice =  user.getWallet()+ book.getTotalPrice();
				refundPrice = (refundPrice/100)*10;
				FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
			    FlightClass flight = flightDao.getSingleFlight(book.getFlightNo());
			    int businessSeats = flight.getBusinessClassSeat() ;
			    int economicSeats =flight.getEconomicClassSeat();
			    if(book.getFlightClass().equalsIgnoreCase("business class")) {
			    	businessSeats += book.getNoOfPerson();
			    }
			    else {
			    	economicSeats += +book.getNoOfPerson();
			    }
			    
				boolean cancelBooking = cancel.updatebooking(user.getId(), startDate,refundPrice,businessSeats,economicSeats,book.getFlightNo(),book.getBookingId());
				
				
				if(cancelBooking==true) {
					System.out.println("successfully canceled");
				}
				else {
					System.out.println("unable to cancel your booking please try again later");
				}
			}
			}
				
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public void showAllBooking(UserClass user) {
		
		UserTableDaoImplement userDao = new UserTableDaoImplement(); 
		try {
			UserTableDaoImplement userDao1 = new UserTableDaoImplement();
			UserClass userDetails = userDao1.getUserById(user);
			BookingTableDaoImplement showAllBooking = new BookingTableDaoImplement();
			
            List<BookingClass> booking = showAllBooking.getAllbooking(userDetails);
           
            
            if(booking==null) {
            	System.out.println("no booking this particular date");
            }
            
            else if(booking!=null) {
			
			for (int i = 0; i < booking.size(); i++) {

				System.out.println("user name : "+userDetails.getName()+"\n"+booking.get(i));
			}
			
			System.out.println("choose 1. if your want to see particular booking in full details 2. exit programe");
			int choice = Integer.parseInt(sc.nextLine());
			if(choice==1) {
				BookingShowMain details = new BookingShowMain();
				details.show(userDetails);
			}
			else {
				System.exit(0);
			}
			
			System.out.println("do you want to change tour date plane 1.yes 2.No");
			int dateChange = Integer.parseInt(sc.nextLine());
			if(dateChange==1) {
				UserTableDaoImplement userDao2 = new UserTableDaoImplement();
				UserClass currentUser = userDao2.getUserById(user);
				
				//BookingShowMain.dateChange(currentUser);
			}
				
			
            }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(user);
	
		
	}
	
	public void showAllUserBookings() {
		
		BookingTableDaoImplement showAllBooking = new BookingTableDaoImplement();
		
        List<BookingClass> booking = showAllBooking.getAllUserBooking();
        
        try {
		for (BookingClass b:booking) {
             
			int userId=b.getUserId();
			AdminTableDaoImplement admin =new AdminTableDaoImplement();
			//System.out.println(userId);
		    UserClass user = admin.getUserById(userId);
			
				System.out.println("BookingClass \n\nUserName :  "+user.getName()+"\n User Email id :  "+user.getEmail()+"\n Tourist Location="+b.getPackageName()+"\n Booking Date :  "
				+b.getBookingDate()+"\n startDate=" + b.getStartDate() + "\n endDate=" + b.getEndDate()
						+ "\n totalPrice=" + b.getTotalPrice() + "\n noOfPerson=" + b.getNoOfPerson() + "\n status=" + b.getStatus()+ 
						 "\n flightClass=" + b.getFlightClass() + "\n hotelRoomType=" + b.getFlightClass() + "\n daysPlan=" + b.getDaysPlan());
			
			
			
		}
        }catch (Exception e) {
			System.out.println(e.getMessage());
		}
        }
	
//	public static void dateChange(UserClass user) {
//		try {
//		DateTimeFormatter formatter =
//	            DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		
//		System.out.println("Notes : if you want to change toure date 1000 will be detected by per memeber  "
//				+ "even if your flight ticket rate less or high\n"
//				+ "1.accept terms and policy 2.exit");
//		int note = Integer.parseInt(sc.nextLine());
//		if(note==1) {
//		System.out.println("\n enter the alrady booking Start date enter ");
//		String oldPlanningDate = sc.nextLine(); //"2021-12-21 05:30";
//		LocalDate oldStartDate = LocalDate.parse(oldPlanningDate, formatter);
//		BookingTableDaoImplement book = new BookingTableDaoImplement();
//		BookingClass booking = book.getbookingById(user.getId(), oldStartDate);
//		
//		System.out.println("\n enter the planning date enter ");
//		String planningDate = sc.nextLine(); //"2021-12-21 05:30";
//		LocalDate startDate = LocalDate.parse(planningDate, formatter);
//		
//	//	LocalDate endDates = LocalDate.parse(endDate);
//	    int end=0;
//		if(booking.getDaysPlan().equalsIgnoreCase("Two days night plan")) {
//			end=2;
//		}
//		else if(booking.getDaysPlan().equalsIgnoreCase("Three days night plan")) {
//			end=3;
//		}
//		else {
//			end=4;
//		}
//		
//		FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
//		List<FlightClass> flights =flightDao.getFlightByNo(booking.getPackageName(),startDate);
//		for (int i = 0; i < flights.size(); i++) {
//
//			System.out.println(flights.get(i));
//		}	
//			System.out.println("\n choose your depature location given below available flights");
//			String depatureLocation = sc.nextLine();
//			
//			FlightClass singleFlight=null;
//			for(FlightClass f:flights) {
//				if(f.getDepature().equalsIgnoreCase(depatureLocation)) {
//					singleFlight=f;
//				}
//				}
//		
//			int fine = 1000 * booking.getNoOfPerson();
//			
//			
//			 if(user.getWallet()>=fine) {
//				 UserTableDaoImplement userWalletDao = new UserTableDaoImplement();
//				 BookingTableDaoImplement bookDao = new BookingTableDaoImplement();				
//				long wallet = userWalletDao.showWalletAmount(user);
//				wallet=(long) (wallet-fine);
//				BookingClass bookClass = new BookingClass(booking.getBookingId(),user.getId(),singleFlight.getFlightNo(),startDate);
//				boolean books= bookDao.dateChange(bookClass,wallet,end);
//
//				if(books==true) {
//					System.out.println("\n \n successfully date changed \n\n\n"
//							+ "get a amazing trip");
//				}
//				else {
//					System.out.println("\n unable to change a date \n please try again");
//				}
//			 
//		}
//			 else {
//					System.out.println(" Sorry! insufficient balance please add amount on your wallent");
//			 }
//		}
//			 
//		else {
//			System.exit(0);
//		}
//		
//		
//	
//	}catch(Exception e) {
//		System.out.println(e.getMessage());
//	}
//		
//	}s
}


