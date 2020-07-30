package com.jpasecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String Home() {
		return ("<h1>Welcome<h1>");

	}

	@GetMapping("/user")
	public String User() {
		return ("<h1>Welcome User<h1>");
	}

	@GetMapping("/admin")
	public String Admin() {
		return ("<h1>Welcome Admin<h1>");
	}
}
