package de.employeeapp.dao.interfaces.employeeManagementSystem;

import de.employeeapp.dao.model.employeeManagementSystem.ConformationMailQueue;

public interface ConformationMailQueueBasicDAO {
	
	public void save(ConformationMailQueue conformationMailQueue);
	public ConformationMailQueue findByEmployeeID();
	public void update(ConformationMailQueue conformationMailQueue);
	public void delete(ConformationMailQueue conformationMailQueue);
	
}
