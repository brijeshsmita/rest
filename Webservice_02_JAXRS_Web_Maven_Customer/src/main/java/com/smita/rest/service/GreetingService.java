package com.smita.rest.service;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.smita.rest.model.Customer;
@Path("/hello")
public class GreetingService implements IGreeting{
	@Override
 	@GET
	@Path("/{pName}")
	/*@PathParam-Binds the parameter passed 
	 * to the method to a value in path.
	 * used along with method parameter
	 */
	public Response getMsg(@PathParam("pName") 
	String name) {
 		String output = "Hello "+ name 
 				+", From Rest " ;
 		return Response.status(200).
 				entity(output).build();
	}
//custom response
//The entity() method returns the object 
//which we want converted into an 
//HTTP message body. 
//The getStatus() method returns the HTTP response code
 		//build()- build the custom response 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/customerList")
	public Response getCustomerList() {
		ArrayList<Customer> list = new ArrayList<Customer>();
	    Customer c1=new Customer(111, "smita", "s@g.com", "9879879876");
	    Customer c2=new Customer(222, "mita", "m@g.com", "9999879876");
	    Customer c3=new Customer(333, "sita", "i@g.com", "9879879888");
	    list.add(c1);list.add(c2);list.add(c3);
	    GenericEntity<List<Customer>> entity = 
	    		new GenericEntity<List<Customer>>(list) {};
	    Response response = Response.ok(entity).build();
	    return response;
	}
}

