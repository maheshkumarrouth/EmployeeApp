package de.employeeapp.MailConformation.scheduler;

import org.springframework.beans.factory.annotation.Autowired;

import de.employeeapp.dao.model.employeeManagementSystem.ConformationMailQueue;
import de.employeeapp.manager.ConformationMailQueueManager;

public class MailConformationSendService implements Runnable {
	
	private ConformationMailQueue conformationMailQueue = null;
	@Autowired
	private ConformationMailQueueManager conformationMailQueueManager;
	
	public MailConformationSendService(ConformationMailQueue conformationMailQueue) {
		this.conformationMailQueue = conformationMailQueue;
	}


	@Override
	public void run() {
		conformationMailQueueManager.sendMailConformationToEmployee(conformationMailQueue);
	}

}
