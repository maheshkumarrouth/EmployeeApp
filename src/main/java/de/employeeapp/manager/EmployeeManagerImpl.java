package de.employeeapp.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.employeeapp.beans.LoginDetails;
import de.employeeapp.dao.interfaces.employeeManagementSystem.EmployeeBasicDAO;
import de.employeeapp.dao.model.employeeManagementSystem.Employee;
import de.employeeapp.events.OnRegistrationCompleteEvent;

@Component
public class EmployeeManagerImpl implements EmployeeManager{
	
	@Autowired 
	private EmployeeBasicDAO employeeBasicDAO;
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	@Autowired
	private EmployeeXLoginManager employeeXLoginManager;
	
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
		employeeXLoginManager.saveUserCreadentials(employee.getLoginDetails(),employeeObject);
		eventPublisher.publishEvent(new OnRegistrationCompleteEvent(employeeObject));
		evictParticularEmployeeData(employee.getEmailId());
	}
	
	@CacheEvict(value = "employee", key = "#emailId")
	public void evictParticularEmployeeData(String employeeId){
		
	}
	
	@Transactional(readOnly=false)
	public void doActivateEmployee(String token){
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
	
	@Transactional
	public de.employeeapp.beans.Employee getEmployeeDetails(String emailId){
		Employee employee = employeeBasicDAO.getEmployeeDetailsByEmail(emailId);
		de.employeeapp.beans.Employee e = new de.employeeapp.beans.Employee();
		LoginDetails loginDetails = new LoginDetails();
		loginDetails.setUserName(employee.getEmployeeXLogin().getUsername());
		loginDetails.setPassword(employee.getEmployeeXLogin().getPassword());
		e.setLoginDetails(loginDetails);
		e.setDateOfBirth(employee.getDateOfBirth());
		e.setEmailId(employee.getEmailId());
		e.setEmployeeJoiningDate(employee.getEmployeeJoiningDate());
		e.setFirstName(employee.getFirstName());
		e.setSurName(employee.getSurName());
		e.setTelephone(employee.getTelephone());
		return e;
	}
	
	@Transactional(readOnly=false)
	public void deleteEmployee(String emailID){
		employeeBasicDAO.delete(emailID);
	}
	
}
