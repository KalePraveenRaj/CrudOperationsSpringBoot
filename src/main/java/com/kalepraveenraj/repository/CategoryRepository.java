package com.kalepraveenraj.repository;



import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kalepraveenraj.entities.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{
	
	//DSL- Domain Specific Language => at run time queries it will generate automatically based on your method names
	
	Optional<Category> findByIdAndBarCode(Integer id, String barCode);
	
	Category findByName(String name);
	
	Category findByNameOrderByIdAsc(String name);
	
	

}
