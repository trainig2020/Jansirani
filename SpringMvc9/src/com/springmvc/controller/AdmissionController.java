package com.springmvc.controller;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdmissionController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//binder.setDisallowedFields(new String[] {"studentMobile"});
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, "studentDOB",new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class, "studentName", new StudentNameEditor());
	}

	@ModelAttribute
	public void addingCommonObjects(Model model) {

		model.addAttribute("headerMessage", "ABC College of engineering and technology");

	}

	@RequestMapping(value = "/admissionForm.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm()  throws Exception{
		String ExceptionOccured = "IO_EXCEPTION";
		
		if(ExceptionOccured.equalsIgnoreCase("NULL_POINTER")) {
			throw new NullPointerException("Null pointer Exception");
		}else if(ExceptionOccured.equalsIgnoreCase("IO_EXCEPTION")) {
			throw new IOException("IO Exception");
		}
		ModelAndView modelAndView = new ModelAndView("AdmissionForm");

		return modelAndView;
	}

	@RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@Valid @ModelAttribute("student") Student student, BindingResult result) {

		if (result.hasErrors()) {
			ModelAndView model = new ModelAndView("AdmissionForm");
			return model;
		}

		ModelAndView modelAndView = new ModelAndView("AdmissionSuccess");

		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(value = "/students" ,method = RequestMethod.GET)
	public ArrayList<Student> getStudentsList(){
		
		Student student = new Student();
		student.setStudentName("Jansirani Rajkumar");
		
		Student student1 = new Student();
		student1.setStudentName("Jennifer Rajkumar");
		
		Student student2 = new Student();
		student2.setStudentName("SriKanth");
		
		ArrayList<Student> list= new ArrayList<Student>();
		list.add(student);
		list.add(student1);
		list.add(student2);
		return list;
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/students/{name}", method = RequestMethod.GET)
	public Student getByName(@PathVariable("name") String name) {
		Student student = new Student();
		student.setStudentName(name);
		student.setStudentHobby("coding");
		return student;
		
	}

}
