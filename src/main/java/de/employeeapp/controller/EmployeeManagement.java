package de.employeeapp.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
import de.employeeapp.profiles.SpringProfilesTest;
import de.employeeapp.service.EmployeeManagementService;
import de.employeeapp.utilities.EmployeeManager;

@RestController
@RequestMapping("/employeeManagement")
public class EmployeeManagement {
	
	@Autowired
	private EmployeeManagementService employeeManagementService;
	
	private static final Logger slf4jLogger = LoggerFactory.getLogger(EmployeeManagement.class);
	
	
	private EmployeeManager employeeManager ;
	
	@Autowired 
	public void setEmployeeManager(EmployeeManager employeeManager){
		this.employeeManager = employeeManager;
	}
	
	@Autowired
	private SpringProfilesTest springProfilesTest;
	
	
	
	@RequestMapping(value="/employee",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void employeeRegistration(@RequestBody Employee employee){
		employeeManagementService.doEmployeeRegistration(employee);
	}	
	
	@RequestMapping(value="/activation")
	public void doActivationMail(@RequestParam(value="token") String token){
		employeeManagementService.activateEmployee(token);
	}
	
	@RequestMapping(value="/employee",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		public Employee getEmployeeDetails(@RequestParam(value="emailId") String emailId){ 
		slf4jLogger.debug("Search Employee By {}",emailId);
		//env.setActiveProfiles("dev");
		springProfilesTest.setupDatasource();
		String strClassPath = System.getProperty("java.class.path");
		System.out.println("Classpath is " + strClassPath);
		Properties prop = new Properties();
		String propFileName = "database.properties";
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		if (inputStream != null) {
			try {
				prop.load(inputStream);
				String user = prop.getProperty("db.driver");
				System.out.println(user);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return employeeManagementService.getEmployeeDetails(emailId);
	}
	
	@RequestMapping(value="employee",method=RequestMethod.DELETE)
	public void dropEmployee(@RequestParam(value="emailId") String emailId){
		System.out.println("dropEmployee");
		employeeManagementService.deleteEmployee(emailId);
	}
	
	@RequestMapping(value="test",method=RequestMethod.POST)
	public void test(@RequestBody String data){
		System.out.println(data);
	}
}
