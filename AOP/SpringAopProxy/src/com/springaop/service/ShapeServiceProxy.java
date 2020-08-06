package com.springaop.service;

import com.springaop.aspect.LoggingAspect;
import com.springaop.model.Circle;

public class ShapeServiceProxy extends ShapeService {
	
	public Circle getCircle() {
		new LoggingAspect().loggingAdvice();
		return super.getCircle();
	}

}
