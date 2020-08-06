package com.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	@Before("allCircleMethods()")
	public void LoggingAdvice(JoinPoint joinPoint) {

	}

	@AfterReturning(pointcut = "args(name)", returning = "returnString")
	public void stringArgumentMethods(String name, Object returnString) {

		System.out.println("The method that takes string as an argument .The value is: " + name
				+ "The output values is:" + returnString);

	}

	@Around("@annotation(com.springaop.aspect.Loggable)")
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {

		Object returnValue = null;
		try {
			System.out.println("Before Advice");
			returnValue = proceedingJoinPoint.proceed();
			System.out.println("After returning");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("After Trowing");
		}
		System.out.println("After Finally");
		return returnValue;
	}

	@AfterThrowing(pointcut = "args(name)", throwing = "ex")
	public void exceptionAdvice(String name, RuntimeException ex) {
		System.out.println("Exception has been thrown " + ex);
		
		
	}
//all service	
	
//	@Pointcut("execution(*com.sprinaop.service.*Service.*(..)")
	

	@Pointcut("execution(* get*())")
	public void allGetters() {

	}

	@Pointcut("within(com.springaop.model.Circle)")
	public void allCircleMethods() {
	}

}
