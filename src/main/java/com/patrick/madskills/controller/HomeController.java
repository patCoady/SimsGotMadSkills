package com.patrick.madskills.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.patrick.madskills.domain.Category;
import com.patrick.madskills.domain.Employee;
import com.patrick.madskills.domain.Skills;
import com.patrick.madskills.service.CategoryService;
import com.patrick.madskills.service.EmployeeService;
import com.patrick.madskills.service.SkillsService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SkillsService skillsService;
	
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		return "home";
	}

	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public String categories(Model model) {
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		return "categories";
	}

	@RequestMapping(value = "/rest/category", method = RequestMethod.GET)
	public @ResponseBody
	List<Category> getCategory() {
		List<Category> categories = categoryService.findAll();
		return categories;
	}

	@RequestMapping(value = "/rest/category", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public @ResponseBody
	void setCategory(@RequestBody Category category) {
		categoryService.save(category);
	}
	@RequestMapping(value = "/rest/category/{categoryId}", method = RequestMethod.PUT, headers = { "Content-type=application/json" })
	public @ResponseBody void updateCategory(@PathVariable("categoryId") int categoryId,@RequestBody Category updatedCategory){
		categoryService.save(updatedCategory);
		
	}
	@RequestMapping(value = "/rest/category/{categoryId}", method = RequestMethod.DELETE, headers = { "Content-type=application/json" })
	public @ResponseBody void deleteCategory(@PathVariable("categoryId") int categoryId){
		categoryService.delete(categoryId);
		
	}
	
	@RequestMapping(value = "/skills", method = RequestMethod.GET)
	public String skills(Model model) {
		List<Skills> skills = skillsService.findAll();
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		model.addAttribute("skills", skills);
		return "skills";
	}
	@RequestMapping(value = "/rest/skills", method = RequestMethod.POST,  headers = { "Content-type=application/json" })
	public void setSkills(@RequestBody Skills skill) {
		skillsService.save(skill);
	}
	@RequestMapping(value = "/rest/skills/{skillId}", method = RequestMethod.PUT, headers = { "Content-type=application/json" })
	public @ResponseBody void updateSkill(@PathVariable("skillId") int categoryId,@RequestBody Skills updatedSkill){
		skillsService.save(updatedSkill);
		
	}
	@RequestMapping(value = "/rest/skills/{skillId}", method = RequestMethod.DELETE, headers = { "Content-type=application/json" })
	public @ResponseBody void deleteSkill(@PathVariable("skillId") int skillId){
		skillsService.delete(skillId);
		
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String employees(Model model) {
		List<Employee> employee = employeeService.findAll();
		model.addAttribute("employees", employee);
		return "employee";
	}

	@RequestMapping(value = "/rest/employee", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public @ResponseBody void setEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
	}
	@RequestMapping(value = "/rest/employee/{employeeId}", method = RequestMethod.PUT, headers = { "Content-type=application/json" })
	public @ResponseBody void updateEmployee(@PathVariable("employeeId") int employeeId,@RequestBody Employee updatedEmployee){
		employeeService.save(updatedEmployee);
		
	}

}
