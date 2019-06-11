package com.shopping.orders.exceptions;

public class OrderPlacingBusinessException extends Exception{

	private String message;
	private String errorCode;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public OrderPlacingBusinessException(String message, String errorCode) {
		this.message = message;
		this.errorCode = errorCode;
	}
	

}
