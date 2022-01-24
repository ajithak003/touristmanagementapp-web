package com.ajith.controler;

import java.util.List;
import java.util.Scanner;

import com.ajith.daoImplement.AdminTableDaoImplement;
import com.ajith.daoImplement.UserTableDaoImplement;
import com.ajith.model.UserClass;

public class AdminMain {
	
	public void Admin(){
	Scanner sc = new Scanner (System.in);
	
	{
	boolean flagadmin = true;
	
	UserTableDaoImplement userDao = new UserTableDaoImplement();
	AdminTableDaoImplement adminDao = new AdminTableDaoImplement();
	do {
		System.out.println("choose your choice \n 1.show all user 2.logout 3.delete user 4.");

		String temChoiceadmin = sc.nextLine();
		if (String.valueOf(temChoiceadmin).matches("[1-2]")) {
			int choiceadmin = Integer.parseInt(temChoiceadmin);
			flagadmin = false;

			switch (choiceadmin) {
			case 1:

				UserClass usershowall = new UserClass();
				
				userDao = new UserTableDaoImplement();
				List<UserClass> user = userDao.getAllUser();
				// System.out.println("second");
				for (int i = 0; i < user.size(); i++) {

					System.out.println(user.get(i));

				}

			case 2:

				break;
			}
		} else {
			System.out.println("must be a number");
		}
	} while (flagadmin);
	}	
}
}


