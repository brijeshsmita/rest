package com.smita.rest.service;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
@Path("/mobile")
public class MobileService {
 	@POST
 	@Path("/add")
	public Response addMobile(
		@FormParam("id") int id,
		@FormParam("name") String name,
		@FormParam("price") float price) { 
		return Response.status(200)
			.entity(" Mobile added successfuly!"
					+ "<br> Id: 	"+id
					+"<br> Name: " + name
					+"<br> Price: "+price)
			.build();
 	}
}