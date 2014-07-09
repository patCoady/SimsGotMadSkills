package com.patrick.madskills.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrick.madskills.domain.Category;
import com.patrick.madskills.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired 
	CategoryRepository categoryRepository;
	
	  public List<Category> findAll() {
		    return categoryRepository.findAll();
		  }
		 
		  public Category save(Category t) {
		    return categoryRepository.save(t);
		  }
		 
		  public void delete(int id) {
			  categoryRepository.delete(id);
		  }
		 
		  public Category findOne(int id) {
		    return categoryRepository.findOne(id);
		  }

}
