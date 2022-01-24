package com.ajith.controler;

import java.util.Scanner;

import com.ajith.daoImplement.UserTableDaoImplement;
import com.ajith.model.UserClass;

public  class UserClassMain {
	
	Scanner sc = new Scanner(System.in);
	
	public void  Update() {
		
		Scanner sc = new Scanner (System.in);
		
		
		UserTableDaoImplement userDao= new UserTableDaoImplement();
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
		
		do {
			System.out.println("enter the email: ");
			email = sc.nextLine();

			if (email.matches("[A-Za-z][A-Za-z0-9]+[@][a-zA-Z]+[.][A-Za-z]{2,3}")) {

				flagemail = false;

				email = email.trim().toLowerCase();

			} else {
				System.out.println("please enter correct email format like xyz23@gmail.com");
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
		
		
		boolean update = userDao.updateuser(name, email, mbo, psw);
		if(update==true) {
			System.out.println("update successfully");
		}
		else {
			System.out.println("unable to update your profile");
		}
	}
	
	public void wallet(UserClass user) {
		
		UserTableDaoImplement userDao = new UserTableDaoImplement();
		long wallet = userDao.showWalletAmount(user);
		System.out.println("Your Wallet Amount :  "+wallet);
		System.out.println("do you want to add wallet amount 1.yes or 2.no");
		int choice = Integer.parseInt(sc.nextLine());

				switch(choice) {
				case 1:
					UserTableDaoImplement userWalletDao = new UserTableDaoImplement();
					System.out.println("enter the added amount:");
					long add = Long.parseLong(sc.nextLine());
					if(add>0) {
					long totalWalletAmount = wallet+add;
					
					boolean walletAdd = userWalletDao.addWalletAmount(user.getId(),totalWalletAmount);
					if(walletAdd) {
						System.out.println("transaction successfully");
						long wallets = userDao.showWalletAmount(user);
						System.out.println("Your Wallet Amount :  "+wallets);	
					}
					else
						System.out.println("transaction failed");
					}
					else {
						System.out.println("please enter a valid amount");
					}
					break;
				case 2:
					System.exit(0);
					break;
			    default:
					
					System.out.println("invalid answ");
				}
	
	
	
	}
}
