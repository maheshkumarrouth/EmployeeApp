package de.employeeapp.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.employeeapp.beans.LoginDetails;
import de.employeeapp.dao.interfaces.employeeManagementSystem.EmployeeXLoginBasicDAO;
import de.employeeapp.dao.model.employeeManagementSystem.Employee;
import de.employeeapp.dao.model.employeeManagementSystem.EmployeeXLogin;

@Component
public class EmployeeXLoginManagerImpl implements EmployeeXLoginManager{
	
	@Autowired 
	private EmployeeXLoginBasicDAO employeeXLoginBasicDAO;
	
	public boolean isUserAlreadyExisted(String userName){
		return employeeXLoginBasicDAO.isUserAlreadyExisted(userName);
	}

	@Override
	public void saveUserCreadentials(LoginDetails loginDetails,Employee employeeObject) {
		EmployeeXLogin employeeXLogin = new EmployeeXLogin();
		employeeXLogin.setUsername(loginDetails.getUserName());
		employeeXLogin.setPassword(loginDetails.getPassword());
		employeeXLogin.setEmployee(employeeObject);
		employeeXLoginBasicDAO.save(employeeXLogin);
	}
	
}
