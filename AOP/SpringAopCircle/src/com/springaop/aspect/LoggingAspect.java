package com.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	/*
	 @Before("execution(public String com.springaop.model.Circle.getName())")
	 public void LoggingAdvice(){
	  
	  System.out.println("Advice run ,Get method called");
	  
	  }
	 */

/*	@Before("execution(* get*())")
	public void LoggingAdvice() {

		System.out.println("Advice run ,Get method called");

	}

	@Before("execution(* get*())")
	public void secondAdvice() {

		System.out.println("second advice method called");

	}    */

	@Before("allGetters() && allCircleMethods()")
	public void LoggingAdvice() {

		System.out.println("Advice run ,Get method called");

	}

	@Before("allGetters()")
	public void secondAdvice() {

		System.out.println("second advice method called");

	}

	@Pointcut("execution(* get*())")
	public void allGetters() {

	}
	
	
	
	@Pointcut("within(com.springaop.model.Circle)")
	public void allCircleMethods() {}
	
	
	
	
	
	

}
