package de.employeeApp.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestClass {
	private static final Logger slf4jLogger = LoggerFactory.getLogger(TestClass.class);
	public static void main(String args[]){
		slf4jLogger.debug("Hello World!");
	}
}
