package com.project.banking.exception;

public class NegativeAmountException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public NegativeAmountException() {
	super("You have entered negative amount for this transaction.....");
}
public  NegativeAmountException(String msg) {
	super(msg);
	
}
}
