package de.employeeapp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import de.employeeapp.exceptions.HibernateDAOException;

@Component
@Aspect
public class DataAccessObjectExceptionInterceptor {
	@AfterThrowing(
			pointcut = "within(de.employeeapp.dao.hibernate.impl.employeeManagementSystem.*)",throwing= "excep")
		    public void logAfterThrowing(JoinPoint joinPoint, Throwable excep) throws Exception{
				System.out.println("logAfterThrowing");
     		}
}
