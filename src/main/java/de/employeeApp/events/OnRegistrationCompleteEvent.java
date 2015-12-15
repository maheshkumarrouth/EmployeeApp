package de.employeeApp.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import de.employeeApp.dao.model.employeeManagementSystem.Employee;

public class OnRegistrationCompleteEvent extends ApplicationEvent{
    
	private Employee employee;
	
	public OnRegistrationCompleteEvent(Employee employee) {
		super(employee);
		setEmployee(employee);
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	

}
