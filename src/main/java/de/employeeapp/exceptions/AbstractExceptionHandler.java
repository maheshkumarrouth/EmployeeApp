package de.employeeapp.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

public class AbstractExceptionHandler {
	
	@Autowired
    protected ReloadableResourceBundleMessageSource resourceBundle;
	
	
}
