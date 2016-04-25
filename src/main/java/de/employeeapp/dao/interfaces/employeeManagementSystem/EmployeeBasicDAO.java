package de.employeeapp.dao.interfaces.employeeManagementSystem;

import java.util.List;

import de.employeeapp.dao.model.employeeManagementSystem.Employee;


public interface EmployeeBasicDAO {
	
	public Employee saveEmployeeDetails(Employee employee);
	
	public Employee getEmployeeDetailsByEmployeeID(Integer employyeID);
	
	public List loadAllEmployeeDetails();
	
	public boolean isEmailAlreadyExisted(String email);
	
	public Employee findEmployeeByToken(String token);
	
	public void updateEmployeeDetails(Employee employee);
	
	public Employee getEmployeeDetailsByEmail(String emailID);
	
	public void delete(String emilID);
	
}
