package de.employeeapp.dao.interfaces.employeeManagementSystem;

import de.employeeapp.dao.model.employeeManagementSystem.EmployeeXLogin;

public interface EmployeeXLoginBasicDAO {
	
	public boolean isUserAlreadyExisted(String userName);
	public void save(EmployeeXLogin employeeXLogin);
	
}
