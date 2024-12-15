package com.enote.service.service;

import java.util.List;

import com.enote.model.Category;

public interface CategoryService {
	
	public Boolean saveCategory(Category category);
	
	public List<Category> getAllCategory();
}
