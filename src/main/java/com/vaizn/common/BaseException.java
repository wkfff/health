package com.vaizn.common;

public class BaseException extends RuntimeException {

	private static final long serialVersionUID = -836903168394646133L;

	private String faultCode;
	
	private String faultMessage;

	public BaseException(String faultCode, String faultMessage) {
		super(faultMessage);
		this.faultCode = faultCode;
		this.faultMessage = faultMessage;
	}

	public BaseException(String faultCode, String faultMessage, Throwable e) {
		super(faultMessage, e);
		this.faultCode = faultCode;
		this.faultMessage = faultMessage;
	}

	public String getFaultCode() {
		return faultCode;
	}

	public void setFaultCode(String faultCode) {
		this.faultCode = faultCode;
	}

	public String getFaultMessage() {
		return faultMessage;
	}

	public void setFaultMessage(String faultMessage) {
		this.faultMessage = faultMessage;
	}
}
