package de.employeeapp.service;

import de.employeeapp.beans.Employee;

public interface EmployeeManagementService {
	public void doEmployeeRegistration(Employee employee);
	public void activateEmployee(String token);
}
