package com.springmvc.controller;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class StudentController {
	
	
	@RequestMapping(value = "/students" ,method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
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
	
	@RequestMapping(value = "/students/{name}",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> updateStudent(@PathVariable("name") String studentName,@RequestBody Student student) {
		System.out.println("studentName"+studentName);
		System.out.println("Student Name:"+student.getStudentName()+"Student Hobby" +student.getStudentHobby());
		HttpHeaders headers = new HttpHeaders();
		headers.add("key1", "value1");
		headers.add("key2", "value2");
		return new ResponseEntity<Boolean>(true,headers,HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/students",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> insertStudent(@RequestBody Student student) {
		
		System.out.println("Student Name:   "+student.getStudentName()+"  Student Hobby : " +student.getStudentHobby());
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{name}")
				.buildAndExpand(student.getStudentName()).toUri().toString());
		
		return new ResponseEntity<Boolean>(true,headers,HttpStatus.CREATED);
	}
	

	@RequestMapping(value = "/students/{name}",method = RequestMethod.DELETE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> deleteStudent(@PathVariable("name") String studentName) {
		System.out.println("studentName : "+studentName);
		
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	}



}
