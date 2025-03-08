package com.enote.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.enote.handler.GenericResponse;

public class CommonUtil {

	public static ResponseEntity<?> createResponseBuilder(Object data, HttpStatus status){
		GenericResponse response = GenericResponse.builder()
				.reponseStatus(status)
				.status("SUCCESS")
				.message("SUCCESS")
				.data(data)
				.build();
		return response.create();
	}
	
	public static ResponseEntity<?> createResponseBuilderMessage(String message, HttpStatus status){
		GenericResponse response = GenericResponse.builder()
				.reponseStatus(status)
				.status("SUCCESS")
				.message(message)
				.build();
		return response.create();
	}
	
	public static ResponseEntity<?> createResponseErrorMessage(Object data, HttpStatus status){
		GenericResponse response = GenericResponse.builder()
				.reponseStatus(status)
				.status("failed....")
				.message("failed....")
				.data(data)
				.build();
		return response.create();
	}
	
	public static ResponseEntity<?> createResponseErrorMessage(String message, HttpStatus status){
		GenericResponse response = GenericResponse.builder()
				.reponseStatus(status)
				.status("failed....")
				.message(message)
				.build();
		return response.create();
	}
}
