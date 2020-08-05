package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class DeptEmpLdapApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeptEmpLdapApplication.class, args);
	}

}
