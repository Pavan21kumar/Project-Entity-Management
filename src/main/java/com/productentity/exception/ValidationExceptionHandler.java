package com.productentity.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.productentity.util.ErrorStructure;

@RestControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {

	private ErrorStructure structure;

	public ValidationExceptionHandler(ErrorStructure structure) {
		super();
		this.structure = structure;
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		//List<ObjectError> errors = ;
		 
		//List<String> messages=new ArrayList<>();
		Map<String ,String> m=new LinkedHashMap<>();
		ex.getAllErrors().forEach(error ->{
			//System.out.println(error.getObjectName()+"-----------");
		//	FieldError fieldError=(FieldError)error;
//			String message = error.getDefaultMessage();
			m.put(((FieldError)error).getField(), error.getDefaultMessage());
			
			//messages.add();
		});
		
		
		return ResponseEntity.badRequest().body(structure.setStatusCode(HttpStatus.BAD_REQUEST.value()).setMessage("invalid inputs").setRootCause(m));
	}

}
