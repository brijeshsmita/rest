package com.smita.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;

@Path("/service1")
@Api(value="Demo Service")
public class MyService {
	
	@ApiResponse( code = 200, message = "Success") 
	@GET
	public String greet(){
		return "Hello WOrld";
	}
}
