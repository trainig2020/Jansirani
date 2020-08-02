package com.securityldap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	
	@GetMapping("/")
	public String getIndex() {
		return " (<h1>Welcome to Home Page</h1>)";
	}

}
