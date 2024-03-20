package com.productentity.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandle {

	@ExceptionHandler
	public String exceptionHandling(RuntimeException r)
	{
		return r.getMessage();
	}
	

}
