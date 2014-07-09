package com.patrick.madskills.repository;


 
import org.springframework.data.jpa.repository.JpaRepository;

import com.patrick.madskills.domain.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> { }
