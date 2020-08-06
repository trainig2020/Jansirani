package com.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


public class LoggingAspect {

	
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


	public void loggingAdvice() {
		System.out.println("Logging from advice");
		
	}

}
