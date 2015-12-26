package de.employeeapp.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.employeeapp.beans.LoginDetails;
import de.employeeapp.dao.interfaces.employeeManagementSystem.EmployeeBasicDAO;
import de.employeeapp.dao.interfaces.employeeManagementSystem.EmployeeXLoginBasicDAO;
import de.employeeapp.dao.model.employeeManagementSystem.Employee;
import de.employeeapp.dao.model.employeeManagementSystem.EmployeeXLogin;
import de.employeeapp.events.OnRegistrationCompleteEvent;

@Component
public class EmployeeManager {
	
	@Autowired 
	private EmployeeBasicDAO employeeBasicDAO;
	@Autowired
	private EmployeeXLoginBasicDAO employeeXLoginBasicDAO;
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	@Transactional(readOnly=false)
	public void doEmployeeRegistration(de.employeeapp.beans.Employee employee){
		
		Employee employeeObject = new Employee();
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
	
	@Transactional(readOnly=false)
	public void doActivateEmployee(String token){
		System.out.println("doActivateEmployee");
		Employee employee = employeeBasicDAO.findEmployeeByToken(token);
		if(employee != null){
			employee.setVerified(new Byte("1"));
			employeeBasicDAO.updateEmployeeDetails(employee);
		}
	}
	
	public Employee fetchEmployeeObjectByToken(String token){
		return employeeBasicDAO.findEmployeeByToken(token);
	}
	
	public boolean isEmailAlreadyExisted(String emailID){
		return employeeBasicDAO.isEmailAlreadyExisted(emailID);
	}
	
}
