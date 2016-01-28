package de.employeeapp.MailConformation.scheduler;

import org.springframework.beans.factory.annotation.Autowired;

import de.employeeapp.dao.model.employeeManagementSystem.ConformationMailQueue;
import de.employeeapp.manager.ConformationMailQueueManagerImpl;

public class MailConformationSendService implements Runnable {
	
	private ConformationMailQueue conformationMailQueue = null;
	@Autowired
	private ConformationMailQueueManagerImpl conformationMailQueueManager;
	
	public MailConformationSendService(ConformationMailQueue conformationMailQueue) {
		this.conformationMailQueue = conformationMailQueue;
	}


	@Override
	public void run() {
		conformationMailQueueManager.sendMailConformationToEmployee(conformationMailQueue);
	}

}
