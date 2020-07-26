package com.springmvc.controller;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	
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
	
	
	@RequestMapping(value = "/students/{name}", method = RequestMethod.GET)
	public Student getByName(@PathVariable("name") String name) {
		Student student = new Student();
		student.setStudentName(name);
		student.setStudentHobby("coding");
		return student;
		
	}



}
