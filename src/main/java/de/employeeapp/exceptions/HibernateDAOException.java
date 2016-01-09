package de.employeeapp.exceptions;

import java.text.MessageFormat;

public class HibernateDAOException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public HibernateDAOException(String errorMessage){
		super(errorMessage);
	}
}
