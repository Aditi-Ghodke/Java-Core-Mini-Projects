package com.sms.service;

import java.time.LocalDate;

import com.sms.core.Course;
import com.sms.core.Students;
import com.sms.customexception.SMSException;

public interface SMSOperations {
	void addStudents(String prnNo, String firstName, String lastName,String email,String password, String dob, String course, double fees,
			boolean confirm_admission) throws SMSException;
	
	//sign in
	public Students authenticate(String email, String password) throws SMSException;
	
	//change pw
	public void changePassword(String email, String oldpw, String newpw) throws SMSException;
	
	//Display all students data using Iterator. 
	public void displayIterator();
	
	//sorting (as per email using natural ordering)
	public void sortByEmail();
	
	//sorting(as per DOB using custom ordering)
	public void sortByDob();
	
	//Unsubscribe
	public void unsubscribe(String email);
}
