package de.employeeapp.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.employeeapp.dao.interfaces.employeeManagementSystem.ConformationMailQueueBasicDAO;
import de.employeeapp.dao.model.employeeManagementSystem.ConformationMailQueue;
import de.employeeapp.dao.model.employeeManagementSystem.VerificationToken;
import de.employeeapp.utilities.UtilityClass;

@Component
public class ConformationMailQueueManager {
	
	@Autowired
	private ConformationMailQueueBasicDAO conformationMailQueueBasicDAO;
	@Autowired
	private  UtilityClass utilityClass;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private VerificationTokenManager verificationTokenManager;
	
	@Transactional(value="transactionManager",readOnly=false)
	public ConformationMailQueue fetchMailConformationData(){
		ConformationMailQueue conformationMailQueue = conformationMailQueueBasicDAO.findByEmployeeID();
		if(conformationMailQueue != null){
			conformationMailQueue.setStatus(new Byte("1"));
			conformationMailQueueBasicDAO.update(conformationMailQueue);
			utilityClass.threadExecutionStarted();
		}
		return conformationMailQueue;
	}
	
	@Transactional(value="transactionManager",readOnly=false)
	public void sendMailConformationToEmployee(ConformationMailQueue conformationMailQueue){
		try{
			VerificationToken verificationToken = verificationTokenManager.findVerificationTokenByEmployeeID(conformationMailQueue.getEmployeeId());
			String confirmationUrl = "http://localhost:8080/EmployeeApp/employeeManagement/activation?token=" + verificationToken.getToken();
	        String recipientAddress = "mahee.routh@gmail.com";
	        String subject = "Registration Confirmation";
			String message = confirmationUrl;
			SimpleMailMessage email = new SimpleMailMessage();
			email.setTo(recipientAddress);
			email.setSubject(subject);
			email.setText(message);
			// sends the e-mail
			mailSender.send(email);
			conformationMailQueueBasicDAO.delete(conformationMailQueue);
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
}
