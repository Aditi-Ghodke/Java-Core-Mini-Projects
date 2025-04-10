package com.sms.core;

public enum Course {
	PGDAC(95000), DBDA(90000), DITIS(85000);
	
	private double courseCost;
	
	Course(double courseCost) {
		this.courseCost = courseCost;
	}
	
	public double getCourseCost()
	{
		return courseCost;
	}
}
