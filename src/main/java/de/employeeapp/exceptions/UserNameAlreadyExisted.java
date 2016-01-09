package de.employeeapp.exceptions;

import java.text.MessageFormat;

public class UserNameAlreadyExisted extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public UserNameAlreadyExisted(String key){
		super(new MessageFormat(ExceptionsDetails.User_Name_Already_Existed.abbrevation).format(new Object[]{key}));
		
	}
}
