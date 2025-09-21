package com.kalepraveenraj.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalepraveenraj.entities.Category;
import com.kalepraveenraj.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public Category createCategory(Category category) {
		category.setBarCode(UUID.randomUUID().toString());
		return categoryRepository.save(category);
		
	}

	public Category fetchCategory(Integer categoryId) {
		return categoryRepository.findById(categoryId).orElseThrow(()->new RuntimeException("Category Not Exist in DB"));
		
	}

	public Category update(Category category, Integer categoryId) {
		Category dbCategory = fetchCategory(categoryId);
		dbCategory.setName(category.getName());
		return categoryRepository.save(dbCategory);
		
	}

	public boolean deleteCategory(Integer categoryId) {
		Category dbCategory = fetchCategory(categoryId);
		categoryRepository.delete(dbCategory);
		return true;
		
	}

	public Category fetchCategory(Integer id, String barCode) {
		return categoryRepository.findByIdAndBarCode(id, barCode).orElseThrow(()->new RuntimeException("Category Not Exist in DB"));
	}

	
	
	

}
