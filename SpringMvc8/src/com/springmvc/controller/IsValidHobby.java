package com.springmvc.controller;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = HobbyValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidHobby {
	
	String listOfValidHobbies() default "Music|Football|Cricket|Athletics|Hockey";

	String message() default "Please provide a valid hobby;"
			+ " accepted Hobbies are - Music,Football,Cricket,Athletics and Hocky(choose anyone)";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	

}
