package de.employeeApp.dao.interfaces.employeeManagementSystem;

import java.util.List;

import de.employeeApp.dao.model.employeeManagementSystem.Employee;


public interface EmployeeBasicDAO {
	
	public Employee saveEmployeeDetails(Employee employee);
	
	public Employee getEmployeeDetailsByEmployeeID(Integer employyeID);
	
	public List loadAllEmployeeDetails();
	
	public boolean isEmailAlreadyExisted(String email);
	
}
