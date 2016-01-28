package de.employeeapp.dao.hibernate.impl.employeeManagementSystem;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.employeeapp.dao.interfaces.employeeManagementSystem.EmployeeBasicDAO;
import de.employeeapp.dao.model.employeeManagementSystem.Employee;
import de.employeeapp.dao.model.employeeManagementSystem.VerificationToken;
import de.employeeapp.exceptions.HibernateDAOException;

@Component("employeeBasicDAO")
public class HibernateEmployeeBasicDAO extends AbstractHibernateImpl implements EmployeeBasicDAO{

	@Override
	public Employee saveEmployeeDetails(Employee employee) {
		
			Session session = mySessionFactory.getCurrentSession();
			session.save(employee);
		
		return employee;
	}

	@Override
	public void updateEmployeeDetails(Employee employee) {
		
			Session session = mySessionFactory.getCurrentSession();
			session.update(employee);
		
	}
	
	@Override
	public Employee getEmployeeDetailsByEmployeeID(Integer employyeID) {
			Session session = mySessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.add(Restrictions.eq("id",employyeID));
			List list = criteria.list();
			if(list == null || list.isEmpty()){
				return null;
			}
			return (Employee)list.get(0);
	}

	@Override
	public List loadAllEmployeeDetails() {
			Session session = mySessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Employee.class);
			List list = criteria.list();
			return list;
	}

	@Override
	@Transactional
	public boolean isEmailAlreadyExisted(String email)throws HibernateDAOException{
			System.out.println("isEmailAlreadyExisted");
			Session session = mySessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.add(Restrictions.eq("emailId", email));
			List list = criteria.list();
			if(list != null && !list.isEmpty()){
				return true;
			}
		
		return false;
	}
	
	@Override
	@Transactional
	public Employee findEmployeeByToken(String token) {
		
			Criteria criteria = mySessionFactory.getCurrentSession().createCriteria(VerificationToken.class,"verificationToken");
			criteria.createAlias("verificationToken.employee", "employee");
			criteria.add(Restrictions.eq("verificationToken.token",token));
			List list = criteria.list();
			if(list != null && !list.isEmpty()){
				VerificationToken verificationToken = (VerificationToken)list.get(0);
				return verificationToken.getEmployee();
			}
		return null;
	}

}
