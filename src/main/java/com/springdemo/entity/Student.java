package com.springdemo.entity;

//LAB 15.3
public class Student {

	private String firstName;
	private String lstName;

	public Student() {
	}

	public Student(String firstName, String lstName) {
		this.firstName = firstName;
		this.lstName = lstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLstName() {
		return lstName;
	}

	public void setLstName(String lstName) {
		this.lstName = lstName;
	}

}
