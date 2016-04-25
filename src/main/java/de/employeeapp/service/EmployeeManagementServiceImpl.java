package de.employeeapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
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
	
	@Cacheable(value="employee",key="#emailId")
	public de.employeeapp.beans.Employee getEmployeeDetails(String emailId){
		System.out.println("getEmployeeDetails");
		return employeeRegistrationManager.getEmployeeDetails(emailId);
	}
	
	//@CacheEvict(value="employee", allEntries=true)
	@CacheEvict(value="employee",key="#emailId")
	public void deleteEmployee(String emailId){
		System.out.println("deleteEmployee");
		//employeeRegistrationManager.deleteEmployee(emailID);
		//evictParticularEmployeeData(emailId);
		deleteAllEmployeesData(emailId);
	}
	
	@CacheEvict(value="employee",key="#emailId")
	public void evictParticularEmployeeData(String emailId){
		
	}
	
	@CacheEvict(value="employee", allEntries=true)
	public void deleteAllEmployeesData(String emailId){
		
	}
}
