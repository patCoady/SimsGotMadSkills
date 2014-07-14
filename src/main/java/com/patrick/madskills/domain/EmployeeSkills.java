package com.patrick.madskills.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;


@Entity
@Table(name = "employee_skills")
/*@NamedQuery(name = "EmployeeSkills.findByEmployee", 
query = "select e from employee_skills e where e.employee_fk = ?1")*/
public class EmployeeSkills {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "skills_fk", referencedColumnName = "id")
	private Skills skill;
	
	@ManyToOne
	@JoinColumn(name = "employee_fk", referencedColumnName = "id")
	private Employee employee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Skills getSkill() {
		return skill;
	}

	public void setSkill(Skills skill) {
		this.skill = skill;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	

}
