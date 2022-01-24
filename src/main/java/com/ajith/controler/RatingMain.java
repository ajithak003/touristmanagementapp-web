package com.ajith.controler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.ajith.daoImplement.BookingTableDaoImplement;
import com.ajith.daoImplement.HotelTableDaoImplement;
import com.ajith.daoImplement.RatingDaoImplement;
import com.ajith.model.BookingClass;
import com.ajith.model.HotelClass;
import com.ajith.model.UserClass;
import com.ajith.model.UserFeedbackClass;

public class RatingMain {
	
	Scanner sc = new Scanner (System.in);
	
	public void userRating(UserClass user) {
		try {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.println("\n enter the planning date enter ");
		String planningDate = sc.nextLine(); // "2021-12-21";
		LocalDate startDate = LocalDate.parse(planningDate, formatter);

		BookingTableDaoImplement book = new BookingTableDaoImplement();
		BookingClass booking = book.getbookingById(user.getId(),startDate);
		System.out.println(booking);
		RatingDaoImplement rating = new RatingDaoImplement();
		boolean eligible = rating.endDateCheck(booking);
		
		if(eligible==true) {
			
			System.out.println("please give your rating in points (1.0 to 5.0)");
			 float point=Float.parseFloat(sc.nextLine());
		
			System.out.println("How would you describe the amzing experience?");
			String describe = sc.nextLine();
			UserFeedbackClass feedBack = new UserFeedbackClass(booking.getBookingId(),user.getId(),booking.getPackageIid(),user.getName(),booking.getPackageName(),point,describe);
		
				boolean insert = rating.insertFeedback(feedBack);
			if(insert==true) {
				System.out.println("Thank you for your goldan review!");
			
		}
			else {
				System.out.println("enter a correct value");
			}
			
		}
		else {
			System.out.println("your not a eligile to give a rating \n"
					+ "once you finish a tour then you are eligible for given your valid feed back");
		}
		
	
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	}

	public void showAllRating() {
		
		try {
			
			HotelClass showAllFlight = new HotelClass();
			RatingDaoImplement ratingDao = new RatingDaoImplement();

			List<UserFeedbackClass> rating = ratingDao.getAllFeedback();

			for (int i = 0; i < rating.size(); i++) {
		

				System.out.println(rating.get(i));

			}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		
	}
	
	
	
}
