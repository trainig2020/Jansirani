package com.springmvc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/annotation")
public class AnnotationController {
	
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		modelAndView.addObject("message", "Hi Jansi,First spring mvc annotation application");
		return modelAndView;
	}
	

	@RequestMapping("/hello")
	public ModelAndView helloToProgramming() {
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		modelAndView.addObject("message", "Hi Jansi,First spring mvc hellotoProgramming method annotation application");
		return modelAndView;
	}
	

	@RequestMapping("/welcome/{userName}")
	public ModelAndView getUserName(@PathVariable("userName") String name) {
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		modelAndView.addObject("message", " Hello " +name+ "  Welcome to Spring mvc");
		return modelAndView;
	}
	

	@RequestMapping("/welcome/{userName}/{countryName}")
	public ModelAndView getUserNameAndCountryName(@PathVariable("userName") String name,
			@PathVariable("countryName") String cname) {
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		modelAndView.addObject("message", " Hello " +name+ "  Welcome to " +cname);
		return modelAndView;
	}
	

	@RequestMapping("/pathvariable/new/{Name}/{Country}")
	public ModelAndView getByPathVariable(@PathVariable Map<String, String> pathvariable) {
		String username = pathvariable.get("Name");
		String country= pathvariable.get("Country");
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		modelAndView.addObject("message", " Hello " +username+ "  Welcome to " +country + "using map in path variable");
		return modelAndView;
	}



}
