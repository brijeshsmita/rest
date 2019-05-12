package com.mahendra;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/service1")
public class MyService {
	
	@GET @Produces("text/plain")
	public String greet(){
		
		if(true) {
			throw new RuntimeException("Some error occurred");
		}
		
		return "<h2>Hello World</h2>";
	}
}
