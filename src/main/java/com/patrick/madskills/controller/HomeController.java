package com.patrick.madskills.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}
	@RequestMapping(value ="/categories", method = RequestMethod.GET)
	public String categories(Model model){
		return "categories";
	}
	
/*    @RequestMapping(value = "/rest", method = RequestMethod.GET)
    public @ResponseBody CategoryRest getCategory() {
		
    	CategoryRest cat = new CategoryRest("Bob");
    	
    	return cat;

    }*/
     
	
}
