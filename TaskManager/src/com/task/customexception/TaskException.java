package com.task.customexception;

public class TaskException extends Exception{
	
	public TaskException(String newMessage) {
		super(newMessage);
	}
}