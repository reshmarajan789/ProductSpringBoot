package com.project.Product.advice;



import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.Product.exception.productNotFoundException;

@RestControllerAdvice
public class exceptionHandler {
	
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public  Map<String,String> handleInvalidException(MethodArgumentNotValidException ex){
		
		Map<String,String>  errorMap= new HashMap();
		ex.getBindingResult().getFieldErrors().forEach(error->{
			errorMap.put("errorMessage", ex.getMessage());
			
		});
		return errorMap;
	}
	@ExceptionHandler(productNotFoundException.class)
	public  Map<String,String> productNotFoundException(productNotFoundException ex){
		
		Map<String,String>  errorMap= new HashMap();
		errorMap.put("errorMessage", ex.getMessage());
		return errorMap;
		
	}
}
