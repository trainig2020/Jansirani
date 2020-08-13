package com.jansi.advanced.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.jansi.advanced.model.ErrorMessage;


@Provider
public class GenricException implements ExceptionMapper<Throwable>{
	
	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage errorMessage =  new ErrorMessage(exception.getMessage(), 500, "http://jaxrs.jansi.com");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errorMessage)
				.build();
	}

}
