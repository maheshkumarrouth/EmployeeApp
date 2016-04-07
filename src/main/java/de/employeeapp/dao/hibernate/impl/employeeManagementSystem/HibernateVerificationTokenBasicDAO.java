package de.employeeapp.dao.hibernate.impl.employeeManagementSystem;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import de.employeeapp.dao.interfaces.employeeManagementSystem.VerificationTokenBasicDAO;
import de.employeeapp.dao.model.employeeManagementSystem.VerificationToken;
@Component("verificationTokenBasicDAO")
public class HibernateVerificationTokenBasicDAO extends AbstractHibernateImpl implements VerificationTokenBasicDAO{
 
	@Override
	public void save(VerificationToken verificationToken) {

		mySessionFactory.getCurrentSession().save(verificationToken);
		
	}
	
	@Override
	public VerificationToken findVerificationTokenByEmployeeID(Integer employeeID) {
			Criteria criteria = mySessionFactory.getCurrentSession().createCriteria(VerificationToken.class,"verificationToken");
			criteria.createAlias("verificationToken.employee", "employee");
			criteria.add(Restrictions.eq("employee.id",employeeID));
			List list = criteria.list();
			if(list != null && !list.isEmpty()){
				VerificationToken verificationToken = (VerificationToken)list.get(0);
				return verificationToken;
			}
		    return null;
	}

}
