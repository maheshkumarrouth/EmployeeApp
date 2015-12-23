package de.employeeapp.exceptions;

public class UserNameAlreadyExisted extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public UserNameAlreadyExisted(String key){
		super(key+" Already Existed");
	}
}
