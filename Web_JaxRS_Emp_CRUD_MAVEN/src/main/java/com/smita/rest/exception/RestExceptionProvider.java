package com.smita.rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RestExceptionProvider implements ExceptionMapper<EmployeeException> {

	@Override
	public Response toResponse(EmployeeException exception) {
		
		return Response.status(Response.Status.NOT_FOUND)
					.entity("Error Occurred: "+exception.getMessage())
					.build();
	}

}
