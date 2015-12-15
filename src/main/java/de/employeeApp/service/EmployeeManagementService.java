package de.employeeApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.employeeApp.beans.Employee;
import de.employeeApp.beans.LoginDetails;
import de.employeeApp.dao.interfaces.employeeManagementSystem.EmployeeBasicDAO;
import de.employeeApp.dao.interfaces.employeeManagementSystem.EmployeeXLoginBasicDAO;
import de.employeeApp.dao.model.employeeManagementSystem.EmployeeXLogin;
import de.employeeApp.manager.EmployeeManager;

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
	
	
	
}
