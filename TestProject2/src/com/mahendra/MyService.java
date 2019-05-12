package com.mahendra;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("service1")
public class MyService {
	
	@GET
	@Produces("text/html")
	public String greet(){
		return "<h2>Hello World</h2>";
	}
}
