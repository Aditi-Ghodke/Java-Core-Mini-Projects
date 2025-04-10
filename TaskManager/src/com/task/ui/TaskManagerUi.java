package com.task.ui;

import java.util.Scanner;

import com.task.service.TaskManagerImpl;

public class TaskManagerUi {
	public static void main(String[] args)
	{
		TaskManagerImpl ops = new TaskManagerImpl();
		boolean exit = false;
		try(Scanner sc = new Scanner(System.in))
		{
			while(!exit)
				try {
					System.out.println("1. Add new task \n"
							+ "2. Display all the tasks \n"
							+ "3. Delete a task \n"
							+ "4. Update status \n"
							+ "5. Display pending tasks \n" 
							+ "6. Display Sorted Task \n"
							+ "0. Exit \n"
							+ "Enter your choice: "
							);
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter the task name, description, date, status, active ");
						ops.addNewTask(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextBoolean());
						break;
					case 2:
						ops.displayAll();
						break;
					case 3: 
						System.out.println("Enter the Task id to delete the task");
						ops.deleteTask(sc.nextInt());
						break;
					case 4:
						System.out.println("Enter the task id and new status");
						ops.updateStatus(sc.nextInt(), sc.next());
						break;
					case 5:
						ops.displayPendingTask();
						break;
					case 6:
						ops.displaySortedTask();
						break;
					default:
						exit = true;
						System.out.println("Exiting the application");
						sc.nextLine();
						break;
					}
					
				
					
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
		}
	}

}
