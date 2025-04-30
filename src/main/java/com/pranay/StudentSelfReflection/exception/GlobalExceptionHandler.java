package com.pranay.StudentSelfReflection.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

/**
 * File Name: GlobalExceptionHandler.java
 * Entity: GlobalExceptionHandler
 * Package: com.pranay.StudentSelfReflection.exception
 * Author: pranayramteke
 * Date: 29/04/25
 * Description:
 */

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(
			ResourceNotFoundException exception,
			WebRequest webRequest
	)
	{
		ErrorDetails errorDetails = new ErrorDetails(
				LocalDateTime.now(),exception.getMessage(),
				webRequest.getDescription(false),
				"USER_NOT_FOUND");
		
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleGlobalException(
			ResourceNotFoundException exception,
			WebRequest webRequest
	)
	{
		ErrorDetails errorDetails = new ErrorDetails(
				LocalDateTime.now(),exception.getMessage(),
				webRequest.getDescription(false),
				"INTERNAL_SERVER_ERROR");
		
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}

