package de.employeeapp.dao.interfaces.employeeManagementSystem;

import de.employeeapp.dao.model.employeeManagementSystem.VerificationToken;

public interface VerificationTokenBasicDAO {
	public void save(VerificationToken verificationToken);
	public VerificationToken findVerificationTokenByEmployeeID(Integer employeeID);
}
