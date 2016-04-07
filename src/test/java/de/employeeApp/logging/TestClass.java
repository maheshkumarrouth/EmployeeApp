package de.employeeApp.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class TestClass {
	private static final Logger log = LoggerFactory.getLogger(TestClass.class);
	public static void main(String args[]){
		  log.trace("Trace Message!");
	      log.debug("Debug Message!");
	      log.info("Info Message!");
	      log.warn("Warn Message!");
	      log.error("Error Message!");
	}
}
