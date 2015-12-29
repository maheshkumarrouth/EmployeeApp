package de.employeeapp.dao.hibernate.impl.employeeManagementSystem;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractHibernateImpl {
	
	@Autowired
	protected SessionFactory mySessionFactory;
	
}
