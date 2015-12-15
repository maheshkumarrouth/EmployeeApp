package de.employeeApp.dao.hibernate.impl.employeeManagementSystem;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.employeeApp.dao.interfaces.employeeManagementSystem.VerificationTokenBasicDAO;
import de.employeeApp.dao.model.employeeManagementSystem.VerificationToken;
@Component("verificationTokenBasicDAO")
public class HibernateVerificationTokenBasicDAO implements VerificationTokenBasicDAO{
 
	@Autowired
	private SessionFactory mySessionFactory;
	@Override
	public void save(VerificationToken verificationToken) {
		try{
			mySessionFactory.getCurrentSession().save(verificationToken);
		}catch(HibernateException hi){
			hi.printStackTrace();
		}
	}

}
