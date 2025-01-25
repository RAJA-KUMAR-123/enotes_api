package com.enote.exception;

import java.util.Map;

public class ValidationException extends RuntimeException{
	
	private Map<String, Object> error;

	public ValidationException(Map<String, Object> error) {
		super("Validation Error.........");
		this.error = error;
	}
	
	public Map<String, Object> getError(){
		return error;
	}

}
