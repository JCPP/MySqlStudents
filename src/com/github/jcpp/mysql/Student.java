package com.github.jcpp.mysql;

import java.util.Date;

public class Student {

	private String firstName;
	private String lastName;
	private int code;
	private Date birthDate;
	
	
	public Student(String firstName, String lastName, int code, Date birthDate) { // Costruttore con i vari parametri
		this.firstName = firstName;
		this.lastName = lastName;
		this.code = code;
		this.birthDate = birthDate;
	}


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}


	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}


	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}


	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	

}
