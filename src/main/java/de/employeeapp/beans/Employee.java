package de.employeeapp.beans;

import java.util.Date;

import org.springframework.cache.annotation.Cacheable;

public class Employee {
	 
	 private String firstName;
     private String surName;
     private Integer telephone;
     private Byte gender;
     private String emailId;
     private Date employeeJoiningDate;
     private Date dateOfBirth;
     private LoginDetails loginDetails;
     
	public LoginDetails getLoginDetails() {
		return loginDetails;
	}
	public void setLoginDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public Integer getTelephone() {
		return telephone;
	}
	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}
	public Byte isGender() {
		return gender;
	}
	public void setGender(Byte gender) {
		this.gender = gender;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Date getEmployeeJoiningDate() {
		return employeeJoiningDate;
	}
	public void setEmployeeJoiningDate(Date employeeJoiningDate) {
		this.employeeJoiningDate = employeeJoiningDate;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
		
}
