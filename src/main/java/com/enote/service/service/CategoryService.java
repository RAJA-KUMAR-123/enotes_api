package com.enote.service.service;

import java.util.List;

import com.enote.dto.CategoryDto;
import com.enote.dto.CategoryRespose;

public interface CategoryService {
	
	Boolean saveCategory(CategoryDto categoryDto); 
	public List<CategoryDto> getAllCategory();

	public List<CategoryRespose> getActiveCategory();

	public CategoryDto getCategoryByid(Integer id);

	public Boolean deletedById(Integer id);

}
