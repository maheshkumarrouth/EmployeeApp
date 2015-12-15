package de.employeeApp.dao.hibernate.impl.employeeManagementSystem;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.employeeApp.dao.interfaces.employeeManagementSystem.EmployeeBasicDAO;
import de.employeeApp.dao.model.employeeManagementSystem.Employee;
import de.employeeApp.dao.model.employeeManagementSystem.EmployeeXLogin;

@Component("employeeBasicDAO")
public class HibernateEmployeeBasicDAO implements EmployeeBasicDAO{

	@Autowired
	private SessionFactory mySessionFactory ; 
	
	@Override
	public Employee saveEmployeeDetails(Employee employee) {
		try{
			Session session = mySessionFactory.getCurrentSession();
			session.save(employee);
		}catch(HibernateException ex){
			ex.printStackTrace();
		}
		return employee;
	}

	@Override
	public Employee getEmployeeDetailsByEmployeeID(Integer employyeID) {
		try{
			Session session = mySessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.add(Restrictions.eq("id",employyeID));
			List list = criteria.list();
			if(list == null || list.isEmpty()){
				return null;
			}
			return (Employee)list.get(0);
		}catch(HibernateException ex){
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List loadAllEmployeeDetails() {
		try{
			Session session = mySessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Employee.class);
			List list = criteria.list();
			return list;
		}catch(HibernateException ex){
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional(value="transactionManager")
	public boolean isEmailAlreadyExisted(String email) {
		try{
			Session session = mySessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.add(Restrictions.eq("emailId", email));
			List list = criteria.list();
			if(list != null && !list.isEmpty()){
				return true;
			}
		}catch(HibernateException ex){
			System.out.println("isEmailAlreadyExisted");
			ex.printStackTrace();
		}
		return false;
	}

}
