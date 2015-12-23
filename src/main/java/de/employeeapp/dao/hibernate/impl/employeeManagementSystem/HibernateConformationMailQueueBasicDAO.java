package de.employeeapp.dao.hibernate.impl.employeeManagementSystem;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.employeeapp.dao.interfaces.employeeManagementSystem.ConformationMailQueueBasicDAO;
import de.employeeapp.dao.model.employeeManagementSystem.ConformationMailQueue;
@Component("conformationMailQueueBasicDAO")
public class HibernateConformationMailQueueBasicDAO implements ConformationMailQueueBasicDAO{
	@Autowired
	private SessionFactory mySessionFactory;
	
	@Override
	@Transactional(value="transactionManager",readOnly=false)
	public void save(ConformationMailQueue conformationMailQueue) {
		try{
			mySessionFactory.getCurrentSession().save(conformationMailQueue);
		}catch(HibernateException e){
			e.printStackTrace();
		}
	}
	
	public void update(ConformationMailQueue conformationMailQueue) {
		try{
			mySessionFactory.getCurrentSession().update(conformationMailQueue);
		}catch(HibernateException e){
			e.printStackTrace();
		}
	}
	
	@Override
	@Transactional(value="transactionManager",readOnly=false)
	public void delete(ConformationMailQueue conformationMailQueue) {
		try{
			mySessionFactory.getCurrentSession().delete(conformationMailQueue);
		}catch(HibernateException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public ConformationMailQueue findByEmployeeID() {
		try{
			Session session = mySessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(ConformationMailQueue.class);
			criteria.add(Restrictions.eq("status", new Byte("0")));
			criteria.addOrder(Order.desc("id"));
			criteria.setMaxResults(1);
			List list = criteria.list();
			if(list!=null && !list.isEmpty()){
				return (ConformationMailQueue)list.get(0);
			}
		}catch(HibernateException hx){
			hx.printStackTrace();
		}
		return null;
	}
}
