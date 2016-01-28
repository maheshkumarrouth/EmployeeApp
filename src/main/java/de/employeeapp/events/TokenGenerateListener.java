package de.employeeapp.events;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import de.employeeapp.dao.interfaces.employeeManagementSystem.ConformationMailQueueBasicDAO;
import de.employeeapp.dao.interfaces.employeeManagementSystem.VerificationTokenBasicDAO;
import de.employeeapp.dao.model.employeeManagementSystem.ConformationMailQueue;
import de.employeeapp.dao.model.employeeManagementSystem.Employee;
import de.employeeapp.dao.model.employeeManagementSystem.VerificationToken;
import de.employeeapp.manager.VerificationTokenManagerImpl;
@Component
public class TokenGenerateListener implements ApplicationListener<OnRegistrationCompleteEvent>{

    @Autowired 
    private VerificationTokenManagerImpl verificationTokenManager;
    @Autowired
    private ConformationMailQueueBasicDAO conformationMailQueueBasicDAO;
	
    @Override
	public void onApplicationEvent(OnRegistrationCompleteEvent event) {
    	System.out.println("onApplicationEvent");
		VerificationToken verificationToken =verificationTokenManager.generateVerificationToken(event.getEmployee());
		ConformationMailQueue conformationMailQueue = new ConformationMailQueue();
		conformationMailQueue.setEmployeeId(event.getEmployee().getId());
		conformationMailQueue.setIntime(new Date());
		conformationMailQueue.setStatus(new Byte("0"));
		conformationMailQueueBasicDAO.save(conformationMailQueue);
    }

}
