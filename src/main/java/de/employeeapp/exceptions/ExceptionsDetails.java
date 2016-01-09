package de.employeeapp.exceptions;

public enum ExceptionsDetails {
	Email_Already_Existed("The User with email {0} is already existed"),
	User_Name_Already_Existed("The User {0} is already existed");
	
	String abbrevation;
	
	private ExceptionsDetails(String abbrevation) {
		this.abbrevation = abbrevation;
	}

	public String getAbbrevation() {
		return abbrevation;
	}
	
}

