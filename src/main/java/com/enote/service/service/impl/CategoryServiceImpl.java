package com.enote.service.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import com.enote.model.Category;
import com.enote.repository.CategoryRepository;
import com.enote.service.service.CategoryService;

@Service // bean
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
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
	public Boolean saveCategory(Category category) {
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
	public List<Category> getAllCategory() {
		List<Category> getAllCategory=categoryRepo.findAll();
//		if(ObjectUtils.isEmpty(getAllCategory)) {
//			return ;
//		}
		return getAllCategory;
	}

	
}
