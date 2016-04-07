package de.employeeapp.exceptions;


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
