package com.patrick.madskills.CRUD;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.patrick.madskills.domain.Category;
import com.patrick.madskills.service.CategoryService;

public class Crud {
	
	@Autowired
	private CategoryService service;
/*	@Test
	public void test() {
		fail("Not yet implemented");
	}*/
	@Test
	public void selectTest(){
			List<Category> categorytest = this.service.findAll();
	}

}
