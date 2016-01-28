package de.employeeapp.manager;

import de.employeeapp.dao.model.employeeManagementSystem.Employee;
import de.employeeapp.dao.model.employeeManagementSystem.VerificationToken;

public interface VerificationTokenManager {
	public VerificationToken generateVerificationToken(Employee employee);
	public VerificationToken findVerificationTokenByEmployeeID(Integer employeeID);
}
