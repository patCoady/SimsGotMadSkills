package com.patrick.madskills.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.patrick.madskills.domain.Skills;
import com.patrick.madskills.repository.SkillsRepository;
@Service
public class SkillsService {
	
	
	@Autowired 
	SkillsRepository skillsRepository;
	
	  	public List<Skills> findAll() {
		    return skillsRepository.findAll();
		  }
		 
		  public Skills save(Skills t) {
		    return skillsRepository.saveAndFlush(t);
		  }
		 
		  public void delete(int id) {
			  skillsRepository.delete(id);
		  }
		 
		  public Skills findOne(int id) {
		    return skillsRepository.findOne(id);
		  }
}
