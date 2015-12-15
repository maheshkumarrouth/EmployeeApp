package de.employeeApp.dao.interfaces.employeeManagementSystem;

import de.employeeApp.dao.model.employeeManagementSystem.EmployeeXLogin;

public interface EmployeeXLoginBasicDAO {
	
	public boolean isUserAlreadyExisted(String userName);
	public void save(EmployeeXLogin employeeXLogin);
	
}
