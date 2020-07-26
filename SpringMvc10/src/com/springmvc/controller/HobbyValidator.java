package com.springmvc.controller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbyValidator implements ConstraintValidator< IsValidHobby, String> {
   
	
	private String listOfValidHobbies;
	
	@Override
	public void initialize(IsValidHobby isValidHobby) {
		this.setListOfValidHobbies(isValidHobby.listOfValidHobbies());
		
	}

	@Override
	public boolean isValid(String studentHobby, ConstraintValidatorContext context) {
		if(studentHobby == null) {
			return false;
		}if(studentHobby.matches("listOfValidHobbies")) {
			return true;
		}else {
		return false;
	}
	}

	public String getListOfValidHobbies() {
		return listOfValidHobbies;
	}

	public void setListOfValidHobbies(String listOfValidHobbies) {
		this.listOfValidHobbies = listOfValidHobbies;
	}

}
