package de.employeeApp.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.employeeApp.beans.Employee;
import de.employeeApp.beans.LoginDetails;
import de.employeeApp.service.EmployeeManagementService;

@RestController
@RequestMapping("/employeeManagement")
public class EmployeeManagement {
	
	private static final Logger slf4jLogger = LoggerFactory.getLogger(EmployeeManagement.class);
	
	@Autowired
	private EmployeeManagementService employeeRegistrationService;
	
	@RequestMapping(value="/employee",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void employeeRegistration(@RequestBody Employee employee){
		employeeRegistrationService.doEmployeeRegistration(employee);
	}	
	
	@RequestMapping(value="/employee",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeDetails(){
		Employee employee = new Employee();
		employee.setDateOfBirth(new Date());
		employee.setEmailId("rm4964@gmail.com");
		employee.setEmployeeJoiningDate(new Date());
		employee.setGender(new Byte("1"));
		employee.setFirstName("mahesh");
		employee.setSurName("routh");
		employee.setTelephone(949492788);
		LoginDetails loginDetails = new LoginDetails();
		loginDetails.setPassword("xmkjakJF");
		loginDetails.setUserName("mahesh");
		employee.setLoginDetails(loginDetails);
		return employee;
	}
}
