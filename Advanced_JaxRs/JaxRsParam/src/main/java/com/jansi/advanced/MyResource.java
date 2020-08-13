package com.jansi.advanced;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("{pathParam}/test")
public class MyResource {
	
	
	@PathParam("pathParam")private String pathParamExample;
	@QueryParam("query")private String queryParamExample;
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		
		return "Testing Works ! Path param user : "+pathParamExample+ "  queery param used : "+queryParamExample ;
	}

}
