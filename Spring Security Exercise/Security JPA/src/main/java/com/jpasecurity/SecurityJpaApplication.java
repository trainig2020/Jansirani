package com.jpasecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jpasecurity.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SecurityJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityJpaApplication.class, args);
	}

}
