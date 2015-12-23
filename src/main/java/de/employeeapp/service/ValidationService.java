package de.employeeapp.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import de.employeeapp.beans.ErrorDetail;
import de.employeeapp.beans.LoginDetails;
import de.employeeapp.dao.model.employeeManagementSystem.Employee;
import de.employeeapp.exceptions.EmailAlreadyExistedException;
import de.employeeapp.exceptions.UserNameAlreadyExisted;
import de.employeeapp.manager.EmployeeManager;
import de.employeeapp.manager.EmployeeXLoginManager;

@Component
public class ValidationService {
	
	@Autowired 
	private EmployeeXLoginManager employeeXLoginManager;
	@Autowired
	private EmployeeManager employeeManager;
		
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
	
	public boolean validateEmployee(de.employeeapp.beans.Employee employee) throws EmailAlreadyExistedException,UserNameAlreadyExisted{
		System.out.println("validateEmployee");
		if(isEmailAlreadyExisted(employee.getEmailId()))
			throw new EmailAlreadyExistedException("Email");
			
			if(isUserAlreadyExisted(employee.getLoginDetails()))
				throw new UserNameAlreadyExisted("UserName");
				
		return true;
	}
	
	public boolean isEmailAlreadyExisted(String emailID){
		boolean isEmailAlreadyExisted = false;
		try{
			isEmailAlreadyExisted = employeeManager.isEmailAlreadyExisted(emailID);	
		}catch(Exception e){
			e.printStackTrace();
		}
		return isEmailAlreadyExisted;
	}
	
	public boolean isUserAlreadyExisted(LoginDetails loginDetails){
		boolean isUserAlreadyExisted = false;
		try{
			isUserAlreadyExisted = employeeXLoginManager.isUserAlreadyExisted(loginDetails.getUserName());
		}catch(Exception e){
			e.printStackTrace();
		}
		return isUserAlreadyExisted;
	}
	
	public boolean isValidToken(String token){
		boolean isValidToken = true;
		if(token == null){
			isValidToken =  false;
		}
		Employee employee = employeeManager.fetchEmployeeObjectByToken(token);
		
		if(employee == null){
			isValidToken =  false;
		}
		return isValidToken;
	}
}
