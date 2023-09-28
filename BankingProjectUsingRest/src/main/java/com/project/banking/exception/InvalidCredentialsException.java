package com.project.banking.exception;

public class InvalidCredentialsException extends RuntimeException{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public InvalidCredentialsException(String msg) {super(msg);}
public InvalidCredentialsException()
{super("Given credentials are not valid");}
}
