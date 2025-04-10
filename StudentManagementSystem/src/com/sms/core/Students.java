package com.sms.core;

import java.time.LocalDate;

public class Students implements Comparable<Students> {
	private String prnNo;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private LocalDate dob;
	private Course course;
	private double fees;
	private boolean confirm_admission;
	
	public Students(String prnNo, String firstName, String lastName,String email, String password, LocalDate dob, Course course, double fees,
			boolean confirm_admission) {
		super();
		this.prnNo = prnNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.course = course;
		this.fees = fees;
		this.confirm_admission = confirm_admission;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}

	

	@Override
	public String toString() {
		return "Students [prnNo=" + prnNo + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", dob=" + dob + ", course=" + course + ", fees=" + fees
				+ ", confirm_admission=" + confirm_admission + "]";
	}


	public String getPrnNo() {
		return prnNo;
	}

	public void setPrnNo(String prnNo) {
		this.prnNo = prnNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public boolean isConfirm_admission() {
		return confirm_admission;
	}

	public void setConfirm_admission(boolean confirm_admission) {
		this.confirm_admission = confirm_admission;
	}

	public boolean equals(Object obj)
	{
//		if(obj instanceof Students) {
//			Students stud = (Students)obj;
//			return this.email.equals(stud);
//		}
		//return false;	
		if(obj instanceof Students)
			return email.equals(((Students)obj).email);
		return false;
	}
	
	public Students(String email) {
		this.email = email;
	}

	public Object getPassword() {
		
		return password;
	}


	@Override
	public int compareTo(Students st) {
		return st.email.compareTo(email);
	}	
	
	
}
