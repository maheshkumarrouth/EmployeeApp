package de.employeeapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	
	public boolean validateEmployee(de.employeeapp.beans.Employee employee) throws EmailAlreadyExistedException,UserNameAlreadyExisted{
		if(isEmailAlreadyExisted(employee.getEmailId()))
			throw new EmailAlreadyExistedException("exception.Email_Already_Existed",employee.getEmailId());
			
			if(isUserAlreadyExisted(employee.getLoginDetails()))
				throw new UserNameAlreadyExisted(employee.getLoginDetails().getUserName());
				
		return true;
	}
	
	public boolean isEmailAlreadyExisted(String emailID){
		return employeeManager.isEmailAlreadyExisted(emailID);	
	}
	
	public boolean isUserAlreadyExisted(LoginDetails loginDetails){
			return employeeXLoginManager.isUserAlreadyExisted(loginDetails.getUserName());
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
