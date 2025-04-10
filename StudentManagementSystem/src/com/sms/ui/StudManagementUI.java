package com.sms.ui;

import java.util.Scanner;

import com.sms.customexception.SMSException;
import com.sms.service.SMSOperationsImpl;

public class StudManagementUI {
	public static void main(String[] args) throws SMSException
	{
		try(Scanner sc = new Scanner(System.in))
		{
			SMSOperationsImpl ops = new  SMSOperationsImpl();
			boolean exit = false;
			while(!exit) {
				System.out.println("1. Sign up \n" 
						+ "2. Sign in \n"
						+ "3. Display Students \n"
						+ "4. Change password \n"
						+ "5. Display using an iterator \n"
						+ "6. Sort by email \n"
						+ "7. Sort by dob \n"
						+ "8. Unsubscribe \n"
						+ "9. Sort by Name and dob \n"
						+ "10. Students who have not paid fees for 1 month \n"
						+ "11. Remove students who have not paid fees for 4 months \n"
						+ "0. Exit"
					);
				System.out.println("Enter your choice!");
			try {
				switch (sc.nextInt()) {
				case 1:
					System.out.println("Enter Student's prno, first name, last name,"
							+ "email, dob, course, fees, confirm admission");
					ops.addStudents(sc.next(), sc.next(), sc.next(), sc.next(),
							sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.nextBoolean(), sc.next());
					break;
				case 2:
					System.out.println("Enter your email and password");
					ops.authenticate(sc.next(), sc.next());
					System.out.println("Sign in successfull!");
					sc.nextLine();
					break;
				case 3:
					ops.displayStudents();
					break;
				case 4:
					System.out.println("Enter your registered email, old password, new password");
					ops.changePassword(sc.next(),sc.next(), sc.next());
					System.out.println("Password Changed Successfully!");
					break;
				case 5: 
					ops.displayIterator();
					break;
				case 6:
					ops.sortByEmail();
					break;
				case 7:
					ops.sortByDob();
					break;
				case 8:
					System.out.println("Enter your emil to unsubscribe");
					ops.unsubscribe(sc.next());
					break;
				case 9:
					ops.sortByDobName();
				break;
				case 10:
					ops.feesNotPaidForOneMonth();
					break;
				case 11:
					ops.feesNotPaidForFourMonths();
					System.out.println("Students removed successfully!");
					break;
				case 0:
					exit = true;
					System.out.println("Exiting application!");
					break;
				}
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
				
			}
				
		}
	}
}
