package com.enote.exception;

@SuppressWarnings("serial")
public class ResourceNotFound extends Exception
{
	public ResourceNotFound(String message) {
		super(message);
	}
}
