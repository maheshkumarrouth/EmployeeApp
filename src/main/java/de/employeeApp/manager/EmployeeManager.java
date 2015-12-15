package de.employeeApp.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.employeeApp.beans.Employee;
import de.employeeApp.beans.LoginDetails;
import de.employeeApp.dao.interfaces.employeeManagementSystem.EmployeeBasicDAO;
import de.employeeApp.dao.interfaces.employeeManagementSystem.EmployeeXLoginBasicDAO;
import de.employeeApp.dao.model.employeeManagementSystem.EmployeeXLogin;
import de.employeeApp.events.OnRegistrationCompleteEvent;

@Component
public class EmployeeManager {
	
	@Autowired 
	private EmployeeBasicDAO employeeBasicDAO;
	@Autowired
	private EmployeeXLoginBasicDAO employeeXLoginBasicDAO;
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	@Transactional(value="transactionManager",readOnly=false)
	public void doEmployeeRegistration(Employee employee){
		
		de.employeeApp.dao.model.employeeManagementSystem.Employee employeeObject = new de.employeeApp.dao.model.employeeManagementSystem.Employee();
		employeeObject.setFirstName(employee.getFirstName());
		employeeObject.setSurName(employee.getSurName());
		employeeObject.setTelephone(employee.getTelephone());
		employeeObject.setDateOfBirth(employee.getDateOfBirth());
		employeeObject.setEmailId(employee.getEmailId());
		employeeObject.setEmployeeJoiningDate(employee.getEmployeeJoiningDate());
		employeeBasicDAO.saveEmployeeDetails(employeeObject);
		
		LoginDetails loginDetails = employee.getLoginDetails();
		EmployeeXLogin employeeXLogin = new EmployeeXLogin();
		employeeXLogin.setUsername(loginDetails.getUserName());
		employeeXLogin.setPassword(loginDetails.getPassword());
		employeeXLogin.setEmployee(employeeObject);
		employeeXLoginBasicDAO.save(employeeXLogin);
		eventPublisher.publishEvent(new OnRegistrationCompleteEvent(employeeObject));
		
		
	}
	
}
