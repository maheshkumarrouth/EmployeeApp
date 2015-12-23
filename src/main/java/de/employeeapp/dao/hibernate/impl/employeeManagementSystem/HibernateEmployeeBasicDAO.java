package de.employeeapp.dao.hibernate.impl.employeeManagementSystem;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.employeeapp.dao.interfaces.employeeManagementSystem.EmployeeBasicDAO;
import de.employeeapp.dao.model.employeeManagementSystem.Employee;
import de.employeeapp.dao.model.employeeManagementSystem.EmployeeXLogin;
import de.employeeapp.dao.model.employeeManagementSystem.VerificationToken;

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
	public void updateEmployeeDetails(Employee employee) {
		try{
			Session session = mySessionFactory.getCurrentSession();
			session.update(employee);
		}catch(HibernateException ex){
			ex.printStackTrace();
		}
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
	
	@Override
	@Transactional(value="transactionManager")
	public Employee findEmployeeByToken(String token) {
		try{
			Criteria criteria = mySessionFactory.getCurrentSession().createCriteria(VerificationToken.class,"verificationToken");
			criteria.createAlias("verificationToken.employee", "employee");
			criteria.add(Restrictions.eq("verificationToken.token",token));
			List list = criteria.list();
			if(list != null && !list.isEmpty()){
				VerificationToken verificationToken = (VerificationToken)list.get(0);
				return verificationToken.getEmployee();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
