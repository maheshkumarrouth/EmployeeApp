package de.employeeapp.utilities;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class EmployeeManager {
	
	@Cacheable(value="check", key="#empID")
	public Integer getSal(Integer empID){
		System.out.println("Debug @ stmt :: getSal");
		return empID;
	}
	
}
