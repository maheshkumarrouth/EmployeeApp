package de.employeeapp.dao.hibernate.impl.employeeManagementSystem;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.employeeapp.dao.interfaces.employeeManagementSystem.EmployeeXLoginBasicDAO;
import de.employeeapp.dao.model.employeeManagementSystem.EmployeeXLogin;

@Component("employeeXLoginBasicDAO")
public class HibernateEmployeeXLoginBasicDAO extends AbstractHibernateImpl implements EmployeeXLoginBasicDAO{
    
	@Override
	@Transactional
	public boolean isUserAlreadyExisted(String userName) {
		
			Session session = mySessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(EmployeeXLogin.class);
			criteria.add(Restrictions.eq("username", userName));
			List list = criteria.list();
			if(list != null && !list.isEmpty()){
				return true;
			}
		
		return false;
	}
	@Override
	public void save(EmployeeXLogin employeeXLogin) {
		
			Session session = mySessionFactory.getCurrentSession();
			session.save(employeeXLogin);
		
	}

}
