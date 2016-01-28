package de.employeeapp.manager;

import de.employeeapp.beans.LoginDetails;
import de.employeeapp.dao.model.employeeManagementSystem.Employee;

public interface EmployeeXLoginManager {
	public boolean isUserAlreadyExisted(String userName);
	public void saveUserCreadentials(LoginDetails loginDetails,Employee employeeObject);
}
