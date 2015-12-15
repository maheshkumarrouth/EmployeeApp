package de.employeeApp.dao.interfaces.employeeManagementSystem;

import de.employeeApp.dao.model.employeeManagementSystem.ConformationMailQueue;

public interface ConformationMailQueueBasicDAO {
	
	public void save(ConformationMailQueue conformationMailQueue);
	public ConformationMailQueue findByEmployeeID();
}
