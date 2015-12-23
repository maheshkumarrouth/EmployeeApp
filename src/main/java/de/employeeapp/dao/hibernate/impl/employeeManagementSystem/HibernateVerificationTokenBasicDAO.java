package de.employeeapp.dao.hibernate.impl.employeeManagementSystem;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.employeeapp.dao.interfaces.employeeManagementSystem.VerificationTokenBasicDAO;
import de.employeeapp.dao.model.employeeManagementSystem.VerificationToken;
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
	@Override
	public VerificationToken findVerificationTokenByEmployeeID(Integer employeeID) {
		try{
			Criteria criteria = mySessionFactory.getCurrentSession().createCriteria(VerificationToken.class,"verificationToken");
			criteria.createAlias("verificationToken.employee", "employee");
			criteria.add(Restrictions.eq("employee.id",employeeID));
			List list = criteria.list();
			if(list != null && !list.isEmpty()){
				VerificationToken verificationToken = (VerificationToken)list.get(0);
				return verificationToken;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
