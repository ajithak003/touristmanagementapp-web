
package com.ajith.controler;

import java.sql.SQLException;

import java.util.List;
import java.util.Scanner;

import com.ajith.daoImplement.*;
import com.ajith.model.AdminClass;
import com.ajith.model.HotelClass;
import com.ajith.model.UserClass;

public class TestMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		

		
		boolean flag = false;
		do {
			System.out.println("enter your choice \n 1.user register \n 2.login \n Home page");

			String temChoice = sc.nextLine();
			if (String.valueOf(temChoice).matches("[1-3]")) {
				int choice = Integer.parseInt(temChoice);
				flag = true;

				// UserTableDaoImplement userDao=new UserTableDaoImplement()
				UserTableDaoImplement userDao = null;
				AdminTableDaoImplement adminDao = null;
				try {

					switch (choice) {
					case 1:

						userDao = new UserTableDaoImplement();
						String name = null;
						boolean flagName = true;
						do {
							System.out.println("Enter full Name:");
							name = sc.nextLine();

							if (name.trim().matches("[A-Za-z ]{3,100}")) {
								name = name.trim();
								flagName = false;
							} else {
								System.out.println("name must be have atleast 3 character and not allowed white space");
							}
						} while (flagName);
						String email;
						boolean flagemail = true;
						boolean verifi = false;
						do {
							System.out.println("enter the email: ");
							email = sc.nextLine();
//							if(userDao.emailvalid(email)==false){
//								System.out.println("this Email id already registered");
//							}
							if (email.matches("[A-Za-z][A-Za-z0-9]+[@][a-zA-Z]+[.][A-Za-z]{2,3}")) {

								flagemail = true;

								email = email.trim().toLowerCase();
								int otp = (int)(Math.random()*(1000-9990+1)+1000);
								System.out.println("your otp is : "+otp);
								int userOtp = Integer.parseInt(sc.nextLine());
								if(otp==userOtp) {
							   	verifi = userDao.emailvalid(email);
								
								if (verifi == false) {
									 userDao.reRegister(email);
									 System.out.println("your accout is activated! \n "
										 		+ "if you want to change mobile no or password login and update your accout");
									System.exit(0);
								}
								}
								else {
									System.out.println("enter a correct otp");
								}
								// System.out.println(email);
							} else {
								System.out.println("please enter correct email format like xyz23@gmail.com");
							}
							if (flagemail == verifi) {
								flagemail = false;

							}
							// System.out.println(flagemail);
						} while (flagemail);
						long mbo = 0;
						boolean flagmbo = false;
						do {
							System.out.println("enter the mobile no: ");
							String temmbo = sc.nextLine();

							if (temmbo.matches("[6-9][0-9]{9}")) {
								mbo = Long.parseLong(temmbo);
								flagmbo = true;
							} else {
								System.out.println(
										"mobile number start with 6-9 and should be contain 10 numbers only not allowed character and space");
							}
						} while (!flagmbo);

						String psw = null;
						boolean flagpsw = false;
						do {
							System.out.println("password must hava 8 to 15 characters only \n"
									+ "atleast one upper case \n" + "atleast one lower case \n"
									+ "atleast one number  \n" + "atleast one special character \n\n");
							System.out.println("enter the password: ");
							psw = sc.nextLine();
							if (psw.matches(
									"^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$")) {
								flagpsw = true;
								// System.out.println(psw);
							} else {
								System.out.println("please enter password given pattern only");
							}

						} while (!flagpsw);
						// System.out.println(name);
						UserClass userinsert = new UserClass(name, email, mbo, psw);
						boolean boo = userDao.insertUser(userinsert);
						if (boo == true) {
							System.out.println("Successfully Register");
						}

					case 2:

						adminDao = new AdminTableDaoImplement();
						userDao = new UserTableDaoImplement();

						System.out.println("Login Page");
						boolean login = false;
						do {

							String emailId;
							boolean flagemailId = true;
							do {
								System.out.println("enter the email id: ");
								emailId = sc.nextLine();

								if (emailId.matches("[a-zA-z][A-Za-z0-9]+[@][a-zA-Z]+[.][A-Za-z]{2,3}")) {
									flagemailId = false;
									emailId = emailId.trim().toLowerCase();

									// System.out.println(email);
								} else {
									System.out.println("please enter correct email format like xyz23@gmail.com");
								}
							} while (flagemailId);

							if (emailId.endsWith("@admin.com")) {

								String password = null;
								boolean flagpassword = false;
								do {
									System.out.println("password must hava 8 to 15 characters only \n"
											+ "atleast one upper case \n" + "atleast one lower case \n"
											+ "atleast one number  \n" + "atleast one special character \n\n");
									System.out.println("enter the Admin password: ");
									password = sc.nextLine();
									if (password.matches(
											"^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$")) {
										flagpassword = true;
										// System.out.println(password);
									} else {
										System.out.println("please enter password given pattern only\n");
									}

								} while (!flagpassword);
								AdminClass admin = adminDao.validateAdmin(emailId, password);
								if (admin == null) {
									System.out.println("user name and password mismatch");
									login = true;
								} else if (admin != null) {
									System.out.println("Welcom " + admin.getName());

									boolean flagadmin = true;
									do {
										System.out.println("choose your choice \n 1.show all user 2.add package 3.update package 4.delete package"
												+ " 5.show all package \n 6. go to flight table \n 7.hotel table 8.show all booking");

										String temChoiceadmin = sc.nextLine();
										if (String.valueOf(temChoiceadmin).matches("[1-8]")) {
											int choiceadmin = Integer.parseInt(temChoiceadmin);
											flagadmin = false;

											switch (choiceadmin) {
											case 1:

												UserClass usershowall = new UserClass();

												List<UserClass> user = userDao.getAllUser();
												// System.out.println("second");
												for (int i = 0; i < user.size(); i++) {

													System.out.println(user.get(i));

												}
                                                break;
											case 2:
												packageMain insert = new packageMain();
												insert.packageInsert();
												break;
											case 3:
												packageMain update = new packageMain();
												update.packageUpdate();
												break;
											case 4:
												packageMain delete = new packageMain();
												delete.delete();
												break;
											case 5:
												packageMain allPackage = new packageMain();
												allPackage.showAllPackage();
												break;
											case 6:
												FlightMain flighinsert = new FlightMain();
												flighinsert.flights();
												
											case 7:
												HotelMain hotel=new HotelMain();
												
												hotel.hotels();
											case 8: 
												BookingShowMain admimBook = new BookingShowMain();
												admimBook.showAllUserBookings();
											
												default :
												{
													System.out.println("invalid input !");
												}
											}
										} else {
											System.out.println("must be a number");
										}
									} while (flagadmin);

								}
							}

							else {

								String password = null;
								boolean flagpassword = false;
								do {
									System.out.println("password must hava 8 to 15 characters only \n"
											+ "atleast one upper case \n" + "atleast one lower case \n"
											+ "atleast one number  \n" + "atleast one special character \n\n");
									System.out.println("enter the password: ");
									password = sc.nextLine();
									if (password.matches(
											"^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$")) {
										flagpassword = true;
										// System.out.println(password);
									} else {
										System.out.println("please enter password given pattern only \n");
									}

								} while (!flagpassword);

								UserClass user = userDao.validateUser(emailId, password);

								if (user == null) {
									System.out.println("user name and password mismatch");
									login = true;
								} else if (user != null) {
									System.out.println("Welcom " + user.getName());
									login = false;
									
									int userChoice = 0;
									do {
									
									System.out.println("enther your choice 1.update profile 2.delete accout 3.see your profile 4. booking \n 5.show ones booking"
											+ "  6.cancel booking 7.show all booking \n8. add wallet amount and show"
											+ "   9.feedback  10. show all ratings");
									 userChoice=Integer.parseInt(sc.nextLine());
									
									
									switch(userChoice) {
									
									
									case 1:
//										update user details
										UserClassMain userUpdate = new UserClassMain();
										userUpdate.Update();
										System.out.println("do u want continue please enter 20");
										userChoice=Integer.parseInt(sc.nextLine());
										
										break;	
									
									case 2:
										//UserClassMain userDelete = new UserClassMain();
								        //userDelete.delete(user);
										boolean delete = userDao.deleteuser(user);
										if(delete==true){
											System.out.println("deleted successfully");
											System.exit(0);
											
										}
										else {
											System.out.println("cant't be deleted");
										}
										break;
									case 3:
										//System.out.println(userDao.getUserById(user));
										
										System.out.println(user);
										System.out.println("do u want continue please enter 20");
										userChoice=Integer.parseInt(sc.nextLine());
									break;	
									
									case 4:
										
										BookingMain book = new BookingMain();
										book.bookingInsert(user);
									break;
									case 5:
										BookingShowMain showBooking = new BookingShowMain();
										showBooking.show(user);
										System.out.println("do u want continue please enter20");
										userChoice=Integer.parseInt(sc.nextLine());
										break;
									case 6:
										BookingShowMain cancel = new BookingShowMain();
										cancel.cancelBooking(user);
										System.out.println("do u want continue please enter 20");
										userChoice=Integer.parseInt(sc.nextLine());
										break;
									
									case 7:
										BookingShowMain show = new BookingShowMain();
										show.showAllBooking(user);
										System.out.println("do u want continue please enter 20");
										userChoice=Integer.parseInt(sc.nextLine());	
									break;
									case 8:
										UserClassMain wallets = new UserClassMain();
										wallets.wallet(user);
										System.out.println("do u want continue please enter 20");
										userChoice=Integer.parseInt(sc.nextLine());	
									case 9:
										RatingMain rating = new RatingMain();
										rating.userRating(user);	
										System.out.println("do u want continue please enter 20");
										userChoice=Integer.parseInt(sc.nextLine());	
										break;
									case 10:
										RatingMain ratings = new RatingMain();
										ratings.showAllRating();
										System.out.println("do u want continue please enter 20");
										userChoice=Integer.parseInt(sc.nextLine());	
										break;
									}
									}while(userChoice==20);
									
									
								}

							}
						} while (login);

					case 3:

						flag = false;

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			} else {
				System.out.println("must be a numbers 1-3 only");
			}
		} while (!flag);

	}

}