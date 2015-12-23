package de.employeeapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import de.employeeapp.beans.ErrorDetail;
import de.employeeapp.exceptions.EmailAlreadyExistedException;
import de.employeeapp.exceptions.UserNameAlreadyExisted;

@ControllerAdvice
public class GlobalControllerAdvice {
	
	@ExceptionHandler(EmailAlreadyExistedException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public ErrorDetail emailAlreadyExistedException(Exception exception) {
		ErrorDetail error = new ErrorDetail();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exception.getLocalizedMessage());
		return error;
	}
	
	@ExceptionHandler(UserNameAlreadyExisted.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public ErrorDetail userNameAlreadyExisted(Exception exception) {
		ErrorDetail error = new ErrorDetail();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exception.getLocalizedMessage());
		return error;
	}
}
