package com.enote.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.enote.utils.CommonUtil;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception e) {
		log.error("GlobalExceptionHandler :: handleException ::", e.getMessage());
//		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		return CommonUtil.createResponseErrorMessage(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<?> handleNullPointerException(Exception e) {
		log.error("GlobalExceptionHandler :: handleNullPointerException ::", e.getMessage());
//		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		return CommonUtil.createResponseErrorMessage(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<?> handleResourceNotFoundException(Exception e) {
		log.error("GlobalExceptionHandler :: handleResourceNotFoundException ::", e.getMessage());
//		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		return CommonUtil.createResponseErrorMessage(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<?> handleValidationException(ValidationException e) {
//		return new ResponseEntity<>(e.getErrors(), HttpStatus.BAD_REQUEST);
		return CommonUtil.createResponseErrorMessage(e.getError(), HttpStatus.BAD_REQUEST);
	}

//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<?> handleException(Exception e) {
//		log.error("GlobalExceptionHandler :: handleException ::", e.getMessage());
//		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//	
//	@ExceptionHandler(NullPointerException.class)
//	public ResponseEntity<?> handleNullPointerException(Exception e){
//		log.error("GlobalExceptionHandler :: handleNullPointerException ::  "+e.getMessage());
//		return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//		
//	}
//	
//	@ExceptionHandler(ResourceNotFound.class)
//	public ResponseEntity<?> handleResourceNotFoundException(Exception e){
//		log.error("GlobalExceptionHandler :: handleResourceNotFoundException ::  "+e.getMessage());
//		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
//		
//	}
//	
//	@ExceptionHandler(ValidationException.class)
//	public ResponseEntity<?> handleValidationException(ValidationException e){
////		log.error("GlobalExceptionHandler :: handleResourceNotFoundException ::  "+e.getMessage());
//		return new ResponseEntity<>(e.getError(),HttpStatus.BAD_REQUEST);
//		
//	}
//	
//	@ExceptionHandler(ExitDataExeception.class)
//	public ResponseEntity<?> handleEixitDataExeception(ExitDataExeception e){
////		log.error("GlobalExceptionHandler :: handleResourceNotFoundException ::  "+e.getMessage());
//		return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
//		
//	}
//	
//	@ExceptionHandler(HttpMessageNotReadableException.class)
//	public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
////		log.error("GlobalExceptionHandler :: handleResourceNotFoundException ::  "+e.getMessage());
//		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
//		
//	}
	
	
}
