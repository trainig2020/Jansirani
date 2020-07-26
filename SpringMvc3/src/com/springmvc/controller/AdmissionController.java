package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdmissionController {
	
	
	@RequestMapping(value = "/admissionForm.html" , method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		ModelAndView modelAndView = new ModelAndView("AdmissionForm");
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/submitAdmissionForm.html" ,method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam(value = "studentName" ,defaultValue = "Ms.Jansi") String name,
			@RequestParam("studentHobby") String hobby) {
		ModelAndView modelAndView = new ModelAndView("AdmissionSuccess");
		modelAndView.addObject("message", "Details submitted by you :  Name: " +name + ",Hobby : "+hobby);
		return modelAndView;
	}
	

}
