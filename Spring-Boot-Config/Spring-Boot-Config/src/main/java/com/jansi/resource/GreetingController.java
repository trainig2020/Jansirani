package com.jansi.resource;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jansi.settings.DBSettings;

@RestController
public class GreetingController {
	
	@Value("${my.greeting}")
	private String greetingMessage;
	
	@Value("some static message")
	private String staticMessage;
	
	@Value("${my.list.values}")
	private List<String> listValues;
	
	@Value("#{${dataValues}}")
	private Map<String, String> dbValues;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private DBSettings dbSettings;
	
	@RequestMapping("/greeting")
	public String greeting() {
		return "Greeting Message : " +greetingMessage +  "  Static Message : "+ staticMessage 
				+ "  List Of Values: " +listValues + "  DB Values :  "+dbValues;
	}
	
	@GetMapping("/greetings")
	public String getGreeting() {
		return " Connections: " +dbSettings.getConnection()+  " Host  :" +dbSettings.getHost()+
				" Port : " + dbSettings.getPort();
		
	}
	
	
	@GetMapping("/environment")
	public String[] envDetails() {
		return environment.getActiveProfiles();
	}

}
