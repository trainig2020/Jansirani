package com.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	@Before("allCircleMethods()")
	public void LoggingAdvice(JoinPoint joinPoint) {

		System.out.println(joinPoint.toString());

	}
	
	@Before("args(name)")
	public void stringArgumentMethods(String name) {

		System.out.println("The method that takes string as an argument .The value is: "+name  );

	}

	@Pointcut("execution(* get*())")
	public void allGetters() {

	}

	@Pointcut("within(com.springaop.model.Circle)")
	public void allCircleMethods() {
	}

}
