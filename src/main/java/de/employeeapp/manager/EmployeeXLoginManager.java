package de.employeeapp.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.employeeapp.beans.LoginDetails;
import de.employeeapp.dao.interfaces.employeeManagementSystem.EmployeeXLoginBasicDAO;

@Component
public class EmployeeXLoginManager {
	
	@Autowired 
	private EmployeeXLoginBasicDAO employeeXLoginBasicDAO;
	
	public boolean isUserAlreadyExisted(String userName){
		try{
			return employeeXLoginBasicDAO.isUserAlreadyExisted(userName);
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
}
