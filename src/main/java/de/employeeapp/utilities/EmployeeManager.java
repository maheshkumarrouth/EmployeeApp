package de.employeeapp.utilities;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class EmployeeManager {
	
	@Cacheable(value="check", key="#empID")
	public Integer getSal(Integer empID){
		System.out.println("Debug @ stmt :: getSal");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empID;
	}
	
}
