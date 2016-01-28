package de.employeeapp.dao.hibernate.impl.employeeManagementSystem;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.employeeapp.dao.interfaces.employeeManagementSystem.ConformationMailQueueBasicDAO;
import de.employeeapp.dao.model.employeeManagementSystem.ConformationMailQueue;

@Component("conformationMailQueueBasicDAO")
public class HibernateConformationMailQueueBasicDAO extends AbstractHibernateImpl implements ConformationMailQueueBasicDAO {
	
	
	@Override
	@Transactional(readOnly=false)
	public void save(ConformationMailQueue conformationMailQueue) {
		
		mySessionFactory.getCurrentSession().save(conformationMailQueue);
			
	}
	
	public void update(ConformationMailQueue conformationMailQueue) {
		
		mySessionFactory.getCurrentSession().update(conformationMailQueue);
		
	}
	
	@Override
	@Transactional(readOnly=false)
	public void delete(ConformationMailQueue conformationMailQueue) {
		
		mySessionFactory.getCurrentSession().delete(conformationMailQueue);
		
	}
	
	@Override
	public ConformationMailQueue findByEmployeeID() {
			Session session = mySessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(ConformationMailQueue.class);
			criteria.add(Restrictions.eq("status", new Byte("0")));
			criteria.addOrder(Order.desc("id"));
			criteria.setMaxResults(1);
			List list = criteria.list();
			if(list!=null && !list.isEmpty()){
				return (ConformationMailQueue)list.get(0);
			}
		return null;
	}
}
