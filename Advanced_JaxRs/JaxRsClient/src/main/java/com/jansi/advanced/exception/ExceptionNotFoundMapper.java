	package com.jansi.advanced.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.jansi.advanced.model.ErrorMessage;


@Provider
public class ExceptionNotFoundMapper  implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException exception) {
		ErrorMessage errorMessage =  new ErrorMessage(exception.getMessage(), 404, "http://jaxrs.jansi.com");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}

}
