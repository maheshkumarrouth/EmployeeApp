package de.employeeapp.exceptions;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import de.employeeapp.beans.ErrorDetail;
import de.employeeapp.exceptions.EmailAlreadyExistedException;
import de.employeeapp.exceptions.HibernateDAOException;
import de.employeeapp.exceptions.UserNameAlreadyExisted;

@ControllerAdvice(basePackages = {"de.employeeapp.controller"})
public class GlobalExceptionHandler extends AbstractExceptionHandler{
	
	@ExceptionHandler(EmailAlreadyExistedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
	public ErrorDetail emailAlreadyExistedException(EmailAlreadyExistedException exception) {
		String errorMessage = resourceBundle.getMessage(exception.getKeyMessage(), null, Locale.getDefault());
		errorMessage = new MessageFormat(errorMessage).format(new Object[]{exception.getExtraMesaage()});
		ErrorDetail error = new ErrorDetail();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(errorMessage);
		return error;
	}		
	
	@ExceptionHandler(UserNameAlreadyExisted.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
	public ErrorDetail userNameAlreadyExisted(UserNameAlreadyExisted exception) {
		ErrorDetail error = new ErrorDetail();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exception.getLocalizedMessage());
		return error;
	}
	
	@ExceptionHandler(HibernateDAOException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
	public ErrorDetail hibernateDAOExeption(HibernateDAOException exception) {
		System.out.println("hibernateDAOExeption");
		ErrorDetail error = new ErrorDetail();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exception.getLocalizedMessage());
		return error;
	}
	
	@ExceptionHandler(Throwable.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
	public ErrorDetail globlaExceptionHandling(Throwable exception) {
		ErrorDetail error = new ErrorDetail();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exception.getLocalizedMessage());
		return error;
	}
}