package com.patrick.madskills.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.patrick.madskills.domain.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>  {

}
