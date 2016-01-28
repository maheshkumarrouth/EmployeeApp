package de.employeeapp.manager;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.employeeapp.dao.interfaces.employeeManagementSystem.VerificationTokenBasicDAO;
import de.employeeapp.dao.model.employeeManagementSystem.Employee;
import de.employeeapp.dao.model.employeeManagementSystem.VerificationToken;
@Component("verificationTokenManager")
public class VerificationTokenManagerImpl implements VerificationTokenManager{
	
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
	
	public VerificationToken findVerificationTokenByEmployeeID(Integer employeeID){
		try{
			VerificationToken verificationToken = verificationTokenBasicDAO.findVerificationTokenByEmployeeID(employeeID);
			return verificationToken;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
