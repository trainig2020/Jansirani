package com.jansi.advanced;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("webapi")
public class MyRestApl extends Application {
	
	public Set<Class<?>> getClasses(){
		return new HashSet<Class<?>>();
	}

}
