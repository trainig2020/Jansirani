package com.jansi.advanced.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectDemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	
	
	@GET
	@Path("/annotations")
	public String getString(@MatrixParam("param") String param,@HeaderParam("authSessionID") 
	String header,@CookieParam("name") String cookie) {
		return "Matrix param:" +param + "Header value :" +header + "   cookie value  : "+cookie;
	}
	
	
	
	@GET
	@Path("/context")
	public String getParamUsingContext(@Context UriInfo uriInfo,@Context HttpHeaders httpHeaders) {
		
		String path = uriInfo.getAbsolutePath().toString();
		String cookies= httpHeaders.getCookies().toString();
		return "Path :  " +path + "  cookies   : " +cookies;
		
	}
	
	
	
	
	
	

}
