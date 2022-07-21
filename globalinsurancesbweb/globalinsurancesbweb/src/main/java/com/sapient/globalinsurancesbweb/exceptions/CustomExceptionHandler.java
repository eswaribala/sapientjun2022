package com.sapient.globalinsurancesbweb.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//AOP
@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler 
{
	private String INCORRECT_REQUEST = "INCORRECT_REQUEST";
	private String BAD_REQUEST = "BAD_REQUEST";
	
	@ExceptionHandler(RecordNotFoundException.class)
	@ResponseBody
	public final ResponseEntity<ErrorResponse> handleUserNotFoundException
						(RecordNotFoundException ex, WebRequest request) 
	{
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(INCORRECT_REQUEST, details);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(RecordFoundException.class)
	@ResponseBody
	public final ResponseEntity<ErrorResponse> handleUserFoundException
			(RecordFoundException ex, WebRequest request)
	{
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(INCORRECT_REQUEST, details);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MissingHeaderInfoException.class)
	@ResponseBody
	public final ResponseEntity<ErrorResponse> handleInvalidTraceIdException
						(MissingHeaderInfoException ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(BAD_REQUEST, details);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseBody
	public final ResponseEntity<ErrorResponse> handleConstraintViolation(
											ConstraintViolationException ex,
											WebRequest request)
	{
		List<String> details = ex.getConstraintViolations()
									.parallelStream()
									.map(e -> e.getMessage())
									.collect(Collectors.toList());

		ErrorResponse error = new ErrorResponse(BAD_REQUEST, details);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	 
	   
	    @Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	    		BindingResult bindingResult=ex.getBindingResult();
	    	
	    	List<String> details = bindingResult.getFieldErrors().parallelStream()
					.map(e -> e.getDefaultMessage())
					.collect(Collectors.toList());

				ErrorResponse error = new ErrorResponse(BAD_REQUEST, details);
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	    }
}
