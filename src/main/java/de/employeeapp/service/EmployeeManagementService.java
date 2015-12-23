package de.employeeapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.employeeapp.beans.Employee;
import de.employeeapp.beans.LoginDetails;
import de.employeeapp.dao.interfaces.employeeManagementSystem.EmployeeBasicDAO;
import de.employeeapp.dao.interfaces.employeeManagementSystem.EmployeeXLoginBasicDAO;
import de.employeeapp.dao.model.employeeManagementSystem.EmployeeXLogin;
import de.employeeapp.manager.EmployeeManager;

@Component
public class EmployeeManagementService {
	
	@Autowired 
	private EmployeeManager employeeRegistrationManager;
	@Autowired
	private ValidationService validationService;
	
	public void doEmployeeRegistration(Employee employee){
		boolean isValidData = validationService.validateEmployee(employee);
		if(isValidData)
			employeeRegistrationManager.doEmployeeRegistration(employee);
	}
	
	public void activateEmployee(String token){
		boolean isValidData = validationService.isValidToken(token);
		if(isValidData){
			employeeRegistrationManager.doActivateEmployee(token);
		}
		
	}
	
	
}
