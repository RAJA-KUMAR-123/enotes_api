package com.enote.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enote.model.Category;
import com.enote.service.service.CategoryService;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

	@Autowired
     private CategoryService categoryService;
	
	@PostMapping("/category_save")
	 public ResponseEntity<?> saveCategory(@RequestBody Category category){
		 Boolean saveCategory = categoryService.saveCategory(category);
		 if(saveCategory) {
			 return new ResponseEntity<>("save ", HttpStatus.CREATED);
		 }
		 return new ResponseEntity<>("not save", HttpStatus.INTERNAL_SERVER_ERROR);
	 }
	
	@GetMapping("/get_category")
	 public ResponseEntity<?> getCategory(){
		 List<Category> getAllCategory = categoryService.getAllCategory();
		 if(CollectionUtils.isEmpty(getAllCategory)) {
			 return ResponseEntity.noContent().build();
		 }
		 return new ResponseEntity<>(getAllCategory, HttpStatus.OK);
	 }
}
