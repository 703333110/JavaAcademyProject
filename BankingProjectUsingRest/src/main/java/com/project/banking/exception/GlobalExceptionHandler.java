package com.project.banking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<String> hanlderResourceNotFoundException(ResourceNotFoundException e){
	String msg= e.getMessage();
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
}
	@ExceptionHandler(InsufficientBalanceException.class)
	public ResponseEntity<String> hanlderInsufficientBalanceException(InsufficientBalanceException e){
		String msg= e.getMessage();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
	}
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<String> hanlderInvalidCredentialsException(InvalidCredentialsException e){
		String msg= e.getMessage();
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(msg);
	}
	@ExceptionHandler(NegativeAmountException.class)
	public ResponseEntity<String> hanlderNegativeAmountException(NegativeAmountException e){
		String msg= e.getMessage();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
	}
}
