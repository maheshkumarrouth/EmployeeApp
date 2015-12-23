package de.employeeapp.exceptions;

public class EmailAlreadyExistedException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public EmailAlreadyExistedException(String key){
		super(key+" Email Already Existed");
		System.out.println("Email Already Existed");
	}
}
