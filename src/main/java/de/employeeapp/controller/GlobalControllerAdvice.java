package de.employeeapp.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import de.employeeapp.beans.ErrorDetail;
import de.employeeapp.exceptions.EmailAlreadyExistedException;
import de.employeeapp.exceptions.UserNameAlreadyExisted;

@ControllerAdvice(basePackages = {"de.employeeapp.controller"})
public class GlobalControllerAdvice{
	
	@ExceptionHandler(EmailAlreadyExistedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
	public ErrorDetail emailAlreadyExistedException(Exception exception) {
		ErrorDetail error = new ErrorDetail();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exception.getLocalizedMessage());
		return error;
	}
	
	@ExceptionHandler(UserNameAlreadyExisted.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
	public ErrorDetail userNameAlreadyExisted(Exception exception) {
		ErrorDetail error = new ErrorDetail();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exception.getLocalizedMessage());
		return error;
	}
}
