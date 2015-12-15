package de.employeeApp.utilities;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Component;

@Component
public class ExecutorServiceInstance {
	
	private final ExecutorService executorService = Executors.newFixedThreadPool(30);

	public ExecutorService getExecutorService() {
		return executorService;
	}
	
}
