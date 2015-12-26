package de.employeeapp.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import de.employeeapp.beans.Employee;
import de.employeeapp.beans.LoginDetails;
import de.employeeapp.service.EmployeeManagementService;

@RestController
@RequestMapping("/employeeManagement")
public class EmployeeManagement {
	
	@Autowired
	private EmployeeManagementService employeeRegistrationService;
	private static final Logger slf4jLogger = LoggerFactory.getLogger(EmployeeManagement.class);
	
	@RequestMapping(value="/employee",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void employeeRegistration(@RequestBody Employee employee){
		System.out.println("employeeRegistration");
		employeeRegistrationService.doEmployeeRegistration(employee);
	}	
	
	@RequestMapping(value="/activation")
	public void doActivationMail(@RequestParam(value="token") String token){
		employeeRegistrationService.activateEmployee(token);
	}
	
	@RequestMapping(value="/employee",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeDetails(){ //
		slf4jLogger.debug("getEmployeeDetails");
		Employee employee = new Employee();
		employee.setDateOfBirth(new Date());
		employee.setEmailId("rm4964@gmail.com");
		employee.setEmployeeJoiningDate(new Date());
		employee.setGender(Byte.valueOf("1"));
		employee.setFirstName("mahesh");
		employee.setSurName("routh");
		employee.setTelephone(949492788);
		final LoginDetails loginDetails = new LoginDetails();
		loginDetails.setPassword("xmkjakJF");
		loginDetails.setUserName("mahesh");
		employee.setLoginDetails(loginDetails);
		return employee;
	}
}
