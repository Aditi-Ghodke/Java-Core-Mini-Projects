package com.sms.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.sms.core.Course;
import com.sms.core.Students;
import com.sms.customexception.SMSException;
import static com.sms.validations.SMSValidations.validateCourseAndAmount;
import static com.sms.validations.SMSValidations.validateDob;

public class SMSOperationsImpl implements SMSOperations{
	private List<Students> stud;
	
	public SMSOperationsImpl() throws SMSException
	{
		this.stud = new ArrayList<>();
		addStudents("pg06", "Aditi", "Ghodke", "aditighodke@gmail.com", "aditi@123", "2003-10-19", "pgdac", 95000, true);
		addStudents("pg08", "Janhvi", "Jadhav", "janhvi@gmail.com", "janhvi@123", "2001-05-22", "ditis", 85000, true);
	}

	@Override
	public void addStudents(String prnNo, String firstName, String lastName, String email,String password, String dob, String course,
			double fees, boolean confirm_admission) throws SMSException {
		Course courses = validateCourseAndAmount(course, fees);
		LocalDate date =validateDob(dob);
		Students studs = new Students(prnNo, firstName, lastName, email, password, date, courses, fees, confirm_admission);
		stud.add(studs);
	}
	
	//display students
	public void displayStudents() {
		for(Students s : stud)
			System.out.println(s);
		
	}

	//SIGN IN
	@Override
	public Students authenticate(String email, String password) throws SMSException {
		String regexp = "[a-z]+[a-z0-9]+@[a-z]*\\.(com|org|net)";
		if(!email.matches(regexp)) {
			throw new SMSException("Invalid Email!");
		}
		Students mail = findByEmail(email);
		if(mail.getPassword().equals(password))
			return mail;
		throw new SMSException("Authentication Failed!");
	}
	
	public Students findByEmail(String email) throws SMSException
	{
		
		Students studs = new Students(email);
		int index = stud.indexOf(studs);
		if(index == -1)
			throw new SMSException("Invalid Email!");
		return stud.get(index);
	}
	
	//change password
	@Override
	public void changePassword(String email, String oldpw, String newpw) throws SMSException {
		Students mail = authenticate(email, oldpw);
		mail.setPassword(newpw);
	}

	//display using an iterator
	@Override
	public void displayIterator() {
		Iterator<Students> itr = stud.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	//sort by email
	@Override
	public void sortByEmail() {
		Collections.sort(stud);	
	}

	@Override
	public void sortByDob() {
		Collections.sort(stud, new Comparator<Students>() {
			@Override
			public int compare(Students s1, Students s2) {
				return s1.getDob().compareTo(s2.getDob());
			}
			
		});
		
	}

	@Override
	public void unsubscribe(String email){
		boolean studs = stud.remove(new Students(email));
		if(studs)
		{
			System.out.println("Unsubscribed Successfully!");
		}
		else{
			System.out.println("Cannot find you account");
		}
	}
}
