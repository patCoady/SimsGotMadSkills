package com.patrick.madskills.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrick.madskills.domain.Employee;
import com.patrick.madskills.repository.EmployeeRepository;




@Service
public class EmployeeService {

	@Autowired 
	EmployeeRepository employeeRepository;
	
	  	public List<Employee> findAll() {
		    return employeeRepository.findAll();
		  }
		 
		  public Employee save(Employee t) {
		    return employeeRepository.saveAndFlush(t);
		  }
		 
		  public void delete(int id) {
			  employeeRepository.delete(id);
		  }
		 
		  public Employee findOne(int id) {
		    return employeeRepository.findOne(id);
		  }

}
