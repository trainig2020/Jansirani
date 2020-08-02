package com.securitylogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication
@EnableOAuth2Sso
public class SecurityLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityLoginApplication.class, args);
	}

}
