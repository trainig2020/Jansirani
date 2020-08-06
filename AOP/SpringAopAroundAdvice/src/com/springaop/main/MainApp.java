package com.springaop.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springaop.service.ShapeService;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring.xml");
		ShapeService service =ctx.getBean("shapeService",ShapeService.class);
		service.getCircle();
		
	}

}
