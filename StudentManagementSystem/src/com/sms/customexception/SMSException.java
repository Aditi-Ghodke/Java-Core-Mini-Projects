package com.sms.customexception;

public class SMSException extends Exception{
	
	public  SMSException(String errMessage)
	{
		super(errMessage);
	}
}
