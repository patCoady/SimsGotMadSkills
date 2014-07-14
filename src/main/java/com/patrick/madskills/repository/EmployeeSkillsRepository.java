package com.patrick.madskills.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.patrick.madskills.domain.EmployeeSkills;

public interface EmployeeSkillsRepository extends JpaRepository<EmployeeSkills, Integer>{
	
	@Query("select e from EmployeeSkills e where e.employee.id = :empId")
	List<EmployeeSkills> findEmployeeSkills(@Param("empId") int empId);
	
	

}
