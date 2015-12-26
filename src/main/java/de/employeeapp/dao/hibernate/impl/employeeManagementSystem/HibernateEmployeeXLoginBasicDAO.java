package de.employeeapp.dao.hibernate.impl.employeeManagementSystem;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.employeeapp.dao.interfaces.employeeManagementSystem.EmployeeBasicDAO;
import de.employeeapp.dao.interfaces.employeeManagementSystem.EmployeeXLoginBasicDAO;
import de.employeeapp.dao.model.employeeManagementSystem.EmployeeXLogin;

@Component("employeeXLoginBasicDAO")
public class HibernateEmployeeXLoginBasicDAO implements EmployeeXLoginBasicDAO{
    @Autowired 
    private SessionFactory mySessionFactory;
    
	@Override
	@Transactional
	public boolean isUserAlreadyExisted(String userName) {
		try{
			Session session = mySessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(EmployeeXLogin.class);
			criteria.add(Restrictions.eq("username", userName));
			List list = criteria.list();
			if(list != null && !list.isEmpty()){
				return true;
			}
		}catch(HibernateException ex){
			System.out.println("isUserAlreadyExisted");
			ex.printStackTrace();
		}
		return false;
	}
	@Override
	public void save(EmployeeXLogin employeeXLogin) {
		try{
			Session session = mySessionFactory.getCurrentSession();
			session.save(employeeXLogin);
		}catch(HibernateException ex){
			ex.printStackTrace();
		}
	}

}
