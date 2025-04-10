package com.sms.validations;

import java.time.LocalDate;

import com.sms.core.Course;
import com.sms.customexception.SMSException;

public class SMSValidations {
	/*Add  validation rules 
		1 DOB : must be after 1st Jan 1985 
		2. Course must be valid
	 */
	public static Course validateCourseAndAmount(String course, double fees) throws SMSException
	{
		Course cr = Course.valueOf(course.toUpperCase());
		if(cr.getCourseCost()!=fees)
			throw new SMSException("Invalid course fees!!");
		return cr;
	}
	
	public static LocalDate validateDob(String dob) throws SMSException
	{
		LocalDate date = LocalDate.parse(dob);
		LocalDate specifiedDate = LocalDate.parse("1985-01-01");
		if(date.isBefore(specifiedDate))
			throw new SMSException("Invalid date!");
		return date;
	}
}
