package com.patrick.madskills.domain;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Category extends AbstractPersistable<Long>{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private int parentid;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	
	
}
