package com.patrick.madskills.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.patrick.madskills.domain.Category;
import com.patrick.madskills.service.CategoryService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	CategoryService categoryService;

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

	// headers = {"Content-type=application/json"}
	@RequestMapping(value = "/rest/category", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public @ResponseBody
	void setCategory(@RequestBody Category category) {
		logger.info("cat:" + category.getName());
		categoryService.save(category);
	}

}
