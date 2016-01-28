package de.employeeapp.service;

import de.employeeapp.beans.LoginDetails;
import de.employeeapp.exceptions.EmailAlreadyExistedException;
import de.employeeapp.exceptions.UserNameAlreadyExisted;

public interface ValidationService {
	public boolean validateEmployee(de.employeeapp.beans.Employee employee) throws EmailAlreadyExistedException,UserNameAlreadyExisted;
	public boolean isEmailAlreadyExisted(String emailID);
	public boolean isUserAlreadyExisted(LoginDetails loginDetails);
	public boolean isValidToken(String token);
}
