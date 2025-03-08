package com.enote.handler;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder 
public class GenericResponse {
	private HttpStatus reponseStatus;
	private String status;
	private String message;
	private Object data;
	
	public ResponseEntity<?> create(){
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("Status", status);
		map.put("Message", message);
		
		if(!ObjectUtils.isEmpty(data)) {
			map.put("data", data);
		}
		return new ResponseEntity<>(map,reponseStatus);
	}
}
