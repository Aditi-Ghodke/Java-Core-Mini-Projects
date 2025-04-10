package com.task.core;

import java.time.LocalDate;

public class TaskManager {
	public int taskId;
	private String taskName;
	private String description;
	private LocalDate taskDate;
	Status status;
	private boolean active;
	static int idGenerator = 0;
	
	public TaskManager(String taskName, String description, LocalDate taskDate, Status status,
			boolean active) {
		super();
		this.taskId = ++idGenerator;
		this.taskName = taskName;
		this.description = description;
		this.taskDate = taskDate;
		this.status = status;
		this.active = active;
	}

	public TaskManager (String taskName)
	{
		this.taskName = taskName;
	}
	@Override
	public String toString() {
		return "TaskManager [taskId=" + taskId + ", taskName=" + taskName + ", description=" + description
				+ ", taskDate=" + taskDate + ", status=" + status + ", active=" + active + "]";
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(LocalDate taskDate) {
		this.taskDate = taskDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public static int getIdGenerator() {
		return idGenerator;
	}

	public static void setIdGenerator(int idGenerator) {
		TaskManager.idGenerator = idGenerator;
	}
	
	public boolean equals(Object obj)
	{
		if(obj instanceof TaskManager) {
			TaskManager task = (TaskManager)obj;
		return ((Integer)taskId).equals(task);
		}
		return false;
	}

	public TaskManager(int taskId) {
		super();
		this.taskId = taskId;
	}
	
}
