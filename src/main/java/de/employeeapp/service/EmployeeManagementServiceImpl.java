package de.employeeapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import de.employeeapp.beans.Employee;
import de.employeeapp.manager.EmployeeManager;

@Component
public class EmployeeManagementServiceImpl implements EmployeeManagementService{
	
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
	
	@Cacheable(value="getEmp",key="#employeeId")
	public de.employeeapp.beans.Employee getEmployeeDetails(Integer employeeId){
		System.out.println("getEmployeeDetails");
		return employeeRegistrationManager.getEmployeeDetails(employeeId);
	}
	
}
