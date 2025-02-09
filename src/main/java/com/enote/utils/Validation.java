package com.enote.utils;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.enote.dto.CategoryDto;
import com.enote.exception.ValidationException;

@Component   // it will create bean
public class Validation {
	
	public void categoryValidation(CategoryDto categoryDto) {
		
		Map<String,Object> error = new LinkedHashMap<>();
		if(ObjectUtils.isEmpty(categoryDto)) {
			throw new IllegalArgumentException("Category object should not be Null or Empty!");
		}else {
			if(ObjectUtils.isEmpty(categoryDto.getName())) {
				error.put("Name", "Name is empty.");
			}else {
				if(categoryDto.getName().length() < 10) {
					error.put("Name Lenght", "Name is less than 10 character.");
				}
			}
		}
		
		if(ObjectUtils.isEmpty(categoryDto.getDescription())) {
			error.put("Description", "Description is empty.");
		}
		
		if(ObjectUtils.isEmpty(categoryDto.getIsActive())) {
			error.put("IsActive", "IsActive value is coming empty");
		}else {
//			if(categoryDto.getIsActive()!=Boolean.TRUE.booleanValue() || categoryDto.getIsActive()!=Boolean.FALSE.booleanValue()) {
//				error.put("IsActive", "Invalid isActive value.....");
//			}
			if (categoryDto.getIsActive() != Boolean.TRUE.booleanValue()
					&& categoryDto.getIsActive() != Boolean.FALSE.booleanValue()) {
				error.put("isActive", "invalid value isActive field ");
			}
		}
		
		if(!error.isEmpty()) {
			throw new ValidationException(error);
		}
	} 
}
