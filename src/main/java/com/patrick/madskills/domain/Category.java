package com.patrick.madskills.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "category")
public class Category{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "name", nullable = false, length =45)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "parentid", referencedColumnName = "id")
	private Category parentCategory;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getparentCategory() {
		return parentCategory;
	}
	public void setparentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}
	
	
}
