package com.enote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enote.model.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
