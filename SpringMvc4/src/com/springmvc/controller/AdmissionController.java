package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdmissionController {

/*	@RequestMapping(value = "/admissionForm.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		ModelAndView modelAndView = new ModelAndView("AdmissionForm");
		return modelAndView;
	}  */
	
	
	

/*	@RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam(value = "studentName", defaultValue = "Ms.Jansi") String name,
			@RequestParam("studentHobby") String hobby) {
		Student student = new Student();
		student.setStudentName(name);
		student.setStudentHobby(hobby);
		ModelAndView modelAndView = new ModelAndView("AdmissionSuccess");
		modelAndView.addObject("headerMessage", "ABC College of engineering and technology");
		modelAndView.addObject("student", student);
		return modelAndView;
	}    */
	
	@ModelAttribute
	public void addingCommonObjects(Model model) {
		
		model.addAttribute("headerMessage", "ABC College of engineering and technology");
		
	}
	
	@RequestMapping(value = "/admissionForm.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		ModelAndView modelAndView = new ModelAndView("AdmissionForm");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("student") Student student) {
		
		ModelAndView modelAndView = new ModelAndView("AdmissionSuccess");
		
	
		return modelAndView;
	}  

}
