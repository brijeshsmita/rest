package com.mahendra;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MyExceptionMapper implements ExceptionMapper<RuntimeException> {

	@Override
	public Response toResponse(RuntimeException arg0) {
	
		return Response.status(Response.Status.NOT_IMPLEMENTED).build();
	}
	
}
