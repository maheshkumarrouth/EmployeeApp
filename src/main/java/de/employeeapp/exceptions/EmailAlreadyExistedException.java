package de.employeeapp.exceptions;

import java.text.MessageFormat;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

public class EmailAlreadyExistedException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private String keyMessage = null;
	private String extraMesaage = null;
	
	public EmailAlreadyExistedException(String keyMessage,String extraMesaage){
		super();
		this.extraMesaage = extraMesaage;
		this.keyMessage = keyMessage;
	}

	public String getKeyMessage() {
		return keyMessage;
	}

	public void setKeyMessage(String keyMessage) {
		this.keyMessage = keyMessage;
	}

	public String getExtraMesaage() {
		return extraMesaage;
	}

	public void setExtraMesaage(String extraMesaage) {
		this.extraMesaage = extraMesaage;
	}
	
}
