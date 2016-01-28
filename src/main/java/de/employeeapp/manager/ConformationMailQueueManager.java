package de.employeeapp.manager;

import de.employeeapp.dao.model.employeeManagementSystem.ConformationMailQueue;

public interface ConformationMailQueueManager {
	public ConformationMailQueue fetchMailConformationData();
	public void sendMailConformationToEmployee(ConformationMailQueue conformationMailQueue);
}
