package de.employeeApp.junitClasses;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.employeeapp.beans.Employee;
import de.employeeapp.service.EmployeeManagementServiceImpl;
import de.employeeapp.service.ValidationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class EmployeeJunitClass {

	@Autowired
	ValidationService validationService;

//	@Before
//	public void setup() {
//
//		Employee employee = new Employee();
//		employee.setEmailId("100");
//		employee.setFirstName("Test");
//		employee.setDateOfBirth(new Date());
//
//		validationService.validateEmployee(employee);
//
//	}

	@Test
<<<<<<< HEAD
	public void EmployeeCreationTestCase(de.employeeapp.beans.Employee employee){
		 
=======
	public void employeeCreationTestCase() {

		EmployeeManagementServiceImpl serviceImpl = new EmployeeManagementServiceImpl();
		Employee employee = new Employee();
		employee.setEmailId("100");
		employee.setFirstName("Test");
		employee.setDateOfBirth(new Date());
		serviceImpl.doEmployeeRegistration(employee);
>>>>>>> a90ce2d9e5031ba8d6fc175897478970cf91d510
	}
}
