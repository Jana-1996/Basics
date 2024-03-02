package com.Bank.GlobalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Bank.Exception.BankException;

@RestControllerAdvice
public class GlobalExceptionHandling {

	@ExceptionHandler(value = BankException.class)
	public ResponseEntity<Object> ifscException(BankException be) {
		return new ResponseEntity<> (be.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Object> branch(NullPointerException npe) {
		return new ResponseEntity<> ("NullPointerExce", HttpStatus.NOT_FOUND);
	}                 //here we can  put the | message  
}                      //npe.getMessage()
