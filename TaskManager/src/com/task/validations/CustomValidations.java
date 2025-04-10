package com.task.validations;
import com.task.customexception.*;

import java.time.LocalDate;

import com.task.core.Status;
import com.task.core.TaskManager;

public class CustomValidations  {
	
	public static Status parseStatus(String status) throws IllegalStateException
	{
		Status stat = Status.valueOf(status.toUpperCase());
		return stat;
	}
	
//	public static LocalDate parseDate(String date) {
//		LocalDate newDate = LocalDate.parse(date);
//		return newDate;
//	}
}
