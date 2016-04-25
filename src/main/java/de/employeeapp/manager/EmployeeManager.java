package de.employeeapp.manager;

import de.employeeapp.dao.model.employeeManagementSystem.Employee;

public interface EmployeeManager {
	public void doEmployeeRegistration(de.employeeapp.beans.Employee employee);
	public void doActivateEmployee(String token);
	public Employee fetchEmployeeObjectByToken(String token);
	public boolean isEmailAlreadyExisted(String emailID);
	public de.employeeapp.beans.Employee getEmployeeDetails(String emailID);
	public void deleteEmployee(String emailID);
}
