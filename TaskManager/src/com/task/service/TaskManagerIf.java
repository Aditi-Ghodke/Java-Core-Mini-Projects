package com.task.service;

import com.task.core.Status;
import com.task.customexception.TaskException;

public interface TaskManagerIf {
	void addNewTask(String taskName, String description, String taskDate, String status,
			boolean active) throws IllegalStateException, TaskException;
	
	public void displayAll();
	
	public void deleteTask(int taskid) throws TaskException;
	
	public void updateStatus(int taskid, String status) throws TaskException;
	
	public void displayPendingTask();
	
	public void displaySortedTask();

}
