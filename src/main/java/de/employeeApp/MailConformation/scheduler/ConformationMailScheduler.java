package de.employeeApp.MailConformation.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import de.employeeApp.dao.interfaces.employeeManagementSystem.ConformationMailQueueBasicDAO;
import de.employeeApp.dao.model.employeeManagementSystem.ConformationMailQueue;
import de.employeeApp.utilities.ExecutorServiceInstance;
import de.employeeApp.utilities.UtilityClass;


@Configuration
@EnableScheduling
public class ConformationMailScheduler {
	
	@Autowired 
	private UtilityClass utilityClass;
	@Autowired 
	private ExecutorServiceInstance executorServiceInstance;
	@Autowired
	private ConformationMailQueueBasicDAO conformationMailQueueBasicDAO;
	
	@Scheduled(fixedRate=1000)
	public void sendMailConformation(){
		System.out.println("sendMailConformation");
		int i=0;
		while(i<=15 && utilityClass.getActiveThreads()<=utilityClass.getMaxThreads()){
			ConformationMailQueue conformationMailQueue = conformationMailQueueBasicDAO.findByEmployeeID();
			if(conformationMailQueue!=null){
				executorServiceInstance.getExecutorService().submit("");
			}
		}
	}
	
}
