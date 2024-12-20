package com.enote.service.service.impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.enote.dto.CategoryDto;
import com.enote.dto.CategoryRespose;
import com.enote.model.Category;
import com.enote.repository.CategoryRepository;
import com.enote.service.service.CategoryService;

@Service // bean
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	
//	@Override
//	public Boolean saveCategory(Category category) {
//		category.setIsDeleted(false);
//		category.setCreatedBy(1);
//		category.setCreatedOn(new Date());
//		Category saveCategory =  categoryRepo.save(category);
//		if(ObjectUtils.isEmpty(saveCategory) && saveCategory == null) {
//			return false;
//		}
//		return true;
//	}

	@Override
	public Boolean saveCategory(CategoryDto categoryDto) {
//		Category category = new Category();	
//		category.setName(categoryDto.getName());
//		category.setDescription(categoryDto.getDescription());
//		category.setIsActive(categoryDto.getIsActive());
//		
		Category category = mapper.map(categoryDto, Category.class);
		
		category.setIsDeleted(false);
		category.setCreatedBy(1);
		category.setCreatedOn(new Date());
		Category saveCategory = categoryRepo.save(category);
		if (ObjectUtils.isEmpty(saveCategory)) {
			return false;
		}
		return true;
	}
	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> getAllCategory=categoryRepo.findAll();
		
		List<CategoryDto> categoryDtoList = getAllCategory.stream().map(cat->mapper.map(cat, CategoryDto.class)).toList();
//		if(ObjectUtils.isEmpty(getAllCategory)) {
//			return ;
//		}
		return categoryDtoList;
	}
	
	@Override
	public List<CategoryRespose> getActiveCategory() {
		List<Category> activeCategory=categoryRepo.findByIsActiveTrue(); 
		List<CategoryRespose> categoryList = activeCategory.stream().map(cat->mapper.map(cat, CategoryRespose.class)).toList();
		return categoryList;
	}

	
}
