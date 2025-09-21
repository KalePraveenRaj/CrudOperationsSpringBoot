package com.kalepraveenraj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kalepraveenraj.entities.Category;
import com.kalepraveenraj.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Category createCategory(@RequestBody Category category) {
		return categoryService.createCategory(category);
		
	}
	
	@GetMapping(value="/fetch/{categoryId}")
	public Category fetchCategory(@PathVariable Integer categoryId) {
		return categoryService.fetchCategory(categoryId);
		
	}
	
	@PutMapping("/update/{categoryId}")
	public Category updateCategory(@RequestBody Category category,@PathVariable Integer categoryId ) {
		return categoryService.update(category,categoryId);
		
	}
	
	@DeleteMapping("/delete/{categoryId}")
	public Boolean deleteCategory(@PathVariable Integer categoryId) {
		return categoryService.deleteCategory(categoryId);
	}
	
	@GetMapping("/fetch/{id}/{barCode}")
	public Category fetchCategory(@PathVariable Integer id,@PathVariable String barCode){
		return categoryService.fetchCategory(id,barCode);
	}

	
}
