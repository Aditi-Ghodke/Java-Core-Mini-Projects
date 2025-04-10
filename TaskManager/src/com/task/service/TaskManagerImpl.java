package com.task.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

import com.task.core.Status;
import com.task.core.TaskManager;
import com.task.customexception.TaskException;
import com.task.validations.CustomValidations;

public class TaskManagerImpl implements TaskManagerIf {
	private ArrayList<TaskManager> task;
	
	public TaskManagerImpl()
	{
		this.task = new ArrayList<TaskManager>();
		try {
			addNewTask("Complete Assignment", "Complete by today ","2025-04-16", "pending", true);
			addNewTask("Study Java", "Revise all the topics", "2025-04-06", "inprogress", true);
			addNewTask("Buy stationary", "Buy books and pen", "2025-04-01", "completed", false);
			addNewTask("Practice Leetcode", "Do it everyday", "2025-04-20", "inprogress", true);	
		}catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	@Override
	public void addNewTask(String taskName, String description, String taskDate, 
			String status, boolean active) throws IllegalStateException, TaskException {
		LocalDate ldate = LocalDate.parse(taskDate);
		Status stat = CustomValidations.parseStatus(status);
		TaskManager tasks = new TaskManager(taskName, description, ldate, stat, active);
		task.add(tasks);
		System.out.println("Task added successfully!");
	}
	
	//display all the tasks
	@Override
	public void displayAll() {
		for(TaskManager t : task)
			System.out.println(t);
	}
	
	//delete task
	@Override
	public void deleteTask(int taskid) throws TaskException{
		boolean removed = task.removeIf(p->p.getTaskId() == taskid);
		if(removed)
			System.out.println("Task removed successfully!");
		else {
			throw new TaskException("Task id does not exist");
		}
	}
	
	//UPDATE STATUS
	@Override
	public void updateStatus(int taskid, String status) throws TaskException {
		Status stat = Status.valueOf(status.toUpperCase());
		for(TaskManager t : task)
			if(t.getTaskId() == taskid) {
				t.setStatus(stat);
				System.out.println("Status updated successfully to "+t.getStatus());
			}else {
				throw new TaskException("Task not found!");
			}		
	}
	
	//DISPLAY ALL THE PENDING TASK
	@Override
	public void displayPendingTask() {
		
		task.stream().filter(p->p.getStatus()
				.equals(Status.PENDING)).forEach(t->System.out.println(t));
	}
	
	//DISPLAY ALL TASKS SORTED BY TASKDATE
	@Override
	public void displaySortedTask() {
		Collections.sort(task, new Comparator<TaskManager>() {

			@Override
			public int compare(TaskManager t1, TaskManager t2) {
				return t1.getTaskDate().compareTo(t2.getTaskDate());
			}
		});	
	}
	
}
