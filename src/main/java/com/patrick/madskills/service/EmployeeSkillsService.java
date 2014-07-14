package com.patrick.madskills.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.patrick.madskills.domain.EmployeeSkills;
import com.patrick.madskills.repository.EmployeeSkillsRepository;
import org.springframework.stereotype.Service;


@Service
public class EmployeeSkillsService {

	@Autowired 
	EmployeeSkillsRepository employeeSkillsRepository;
	
	  	public List<EmployeeSkills> findAll() {
		    return employeeSkillsRepository.findAll();
		  }
		 
		  public EmployeeSkills save(EmployeeSkills t) {
		    return employeeSkillsRepository.saveAndFlush(t);
		  }
		 
		  public void delete(int id) {
			  employeeSkillsRepository.delete(id);
		  }
		 
		  public EmployeeSkills findOne(int id) {
		    return employeeSkillsRepository.findOne(id);
		  }
		  public List<EmployeeSkills> findByEmployee(int empId){
			  return employeeSkillsRepository.findEmployeeSkills(empId);
		  }
}
