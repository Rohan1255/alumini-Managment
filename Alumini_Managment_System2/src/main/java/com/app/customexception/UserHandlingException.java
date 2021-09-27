package com.app.customexception;


@SuppressWarnings("serial")
public class UserHandlingException extends RuntimeException{
	public UserHandlingException(String msg) {
		super(msg);
	}
}
