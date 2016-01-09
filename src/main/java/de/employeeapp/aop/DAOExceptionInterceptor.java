package de.employeeapp.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import de.employeeapp.exceptions.HibernateDAOException;

public class DAOExceptionInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		 try{
	           return invocation.proceed();
	       } catch (HibernateDAOException e) {
	           throw new HibernateDAOException(e.getLocalizedMessage());
	       }
	}

}
