package de.employeeApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.employeeApp.beans.Employee;
import de.employeeApp.beans.LoginDetails;
import de.employeeApp.dao.interfaces.employeeManagementSystem.EmployeeBasicDAO;
import de.employeeApp.dao.interfaces.employeeManagementSystem.EmployeeXLoginBasicDAO;

@Component
public class ValidationService {
	@Autowired
	private EmployeeXLoginBasicDAO employeeXLoginBasicDAO;
	@Autowired 
	private EmployeeBasicDAO employeeBasicDAO;
	
	public boolean validateEmployee(Employee employee){
		boolean isValidateEmployee = true;
		if(isEmailAlreadyExisted(employee.getEmailId()) || isUserAlreadyExisted(employee.getLoginDetails())){
			isValidateEmployee = false;
		}
		return isValidateEmployee;
	}
	
	public boolean isEmailAlreadyExisted(String emailID){
		boolean isEmailAlreadyExisted = false;
		try{
			isEmailAlreadyExisted = employeeBasicDAO.isEmailAlreadyExisted(emailID);	
			System.out.println("isEmailAlreadyExisted"+isEmailAlreadyExisted);
		}catch(Exception e){
			e.printStackTrace();
		}
		return isEmailAlreadyExisted;
	}
	
	public boolean isUserAlreadyExisted(LoginDetails loginDetails){
		boolean isUserAlreadyExisted = false;
		try{
			System.out.println("isUserAlreadyExisted"+isUserAlreadyExisted);
			isUserAlreadyExisted = employeeXLoginBasicDAO.isUserAlreadyExisted(loginDetails.getUserName());
			System.out.println("isUserAlreadyExisted"+isUserAlreadyExisted);
		}catch(Exception e){
			e.printStackTrace();
		}
		return isUserAlreadyExisted;
	}
	
}
