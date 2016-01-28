package de.employeeapp.MailConformation.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import de.employeeapp.dao.interfaces.employeeManagementSystem.ConformationMailQueueBasicDAO;
import de.employeeapp.manager.ConformationMailQueueManagerImpl;
import de.employeeapp.utilities.ExecutorServiceInstance;
import de.employeeapp.utilities.UtilityClass;


@Configuration
@EnableScheduling
public class ConformationMailScheduler {
	
	@Autowired 
	private UtilityClass utilityClass;
	@Autowired 
	private ExecutorServiceInstance executorServiceInstance;
	@Autowired
	private ConformationMailQueueBasicDAO conformationMailQueueBasicDAO;
	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private ConformationMailQueueManagerImpl conformationMailQueueManager;
	
	
	
//	@Scheduled(fixedRate=50000)
//	public void sendMailConformation(){
//		System.out.println("sendMailConformation");
//		int i=0;
//		while(i<=15 && utilityClass.getActiveThreads()<=utilityClass.getMaxThreads()){
//			ConformationMailQueue conformationMailQueue = conformationMailQueueManager.fetchMailConformationData();
//			if(conformationMailQueue!=null){
//				MailConformationSendService mailConformationSendService = new MailConformationSendService(conformationMailQueue);
//				applicationContext.getAutowireCapableBeanFactory().autowireBean(mailConformationSendService);
//				executorServiceInstance.getExecutorService().execute(mailConformationSendService);
//			}
//		}
//	}
	
	
}
