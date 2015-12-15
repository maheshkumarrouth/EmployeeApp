package de.employeeApp.manager;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.employeeApp.dao.interfaces.employeeManagementSystem.VerificationTokenBasicDAO;
import de.employeeApp.dao.model.employeeManagementSystem.Employee;
import de.employeeApp.dao.model.employeeManagementSystem.VerificationToken;
@Component("verificationTokenManager")
public class VerificationTokenManager {
	
	@Autowired 
	private VerificationTokenBasicDAO verificationTokenBasicDAO;
	public VerificationToken generateVerificationToken(Employee employee){
		VerificationToken verificationToken = new VerificationToken();
		verificationToken.setEmployee(employee);
		verificationToken.setExpireDate(new Date());
		verificationToken.setToken("!@#CHVHJD");
		verificationTokenBasicDAO.save(verificationToken);
		return verificationToken;
	}
}
