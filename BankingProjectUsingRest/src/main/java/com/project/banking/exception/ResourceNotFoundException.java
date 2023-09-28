package com.project.banking.exception;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
public ResourceNotFoundException() {
	super("Resource not found in the user database");
}
public ResourceNotFoundException(String msg) {
	super(msg);
}
}
