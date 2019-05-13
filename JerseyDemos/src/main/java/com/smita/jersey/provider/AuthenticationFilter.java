	package com.smita.jersey.provider;
	
	import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;
	
@Provider
@PreMatching
public class AuthenticationFilter implements ContainerRequestFilter {
    /**
     * Apply the filter : check input request, validate or not with user auth
     * @param containerRequest The request from Tomcat server
     */
    @Override
    public void filter(ContainerRequestContext containerRequest) throws WebApplicationException {
        //GET, POST, PUT, DELETE, ...
        String method = containerRequest.getMethod();
        // myresource/get/56bCA for example
        String path = containerRequest.getUriInfo().getPath(true);
  
        //We do allow wadl to be retrieve
        if(method.equals("GET") && (path.equals("application.wadl") || path.equals("application.wadl/xsd0.xsd"))){
            return;
        }
  
        //Get the authentification passed in HTTP headers parameters
        String auth = containerRequest.getHeaderString("authorization");
  
        //If the user does not have the right (does not provide any HTTP Basic Auth)
        if(auth == null) {
            throw new WebApplicationException(Status.UNAUTHORIZED);
        }
  
        //lap : loginAndPassword
        String[] lap = BasicAuth.decode(auth);
  
        //If login or password fail
        if(lap == null || lap.length != 2) {
            throw new WebApplicationException(Status.UNAUTHORIZED);
        }
  
        //DO YOUR DATABASE CHECK HERE (replace that line behind)...
        User user =  validateUser(lap[0], lap[1]);
  
        //Our system refuse login and password
        if(user == null) {
            throw new WebApplicationException(Status.UNAUTHORIZED);
        }
  
        // We configure your Security Context here
        String scheme = containerRequest.getUriInfo().getRequestUri().getScheme();
        containerRequest.setSecurityContext(new MyApplicationSecurityContext(user, scheme));
 
        //TODO : HERE YOU SHOULD ADD PARAMETER TO REQUEST, TO REMEMBER USER ON YOUR REST SERVICE...
    }

	private User validateUser(String userName, String pass) {
		User user = null;
		if(userName.equalsIgnoreCase("smita") && pass.equals("admin")) {
			user = new User();
			user.setEmail("brijeshsmita@gmail.com");
			user.setFirstName("Smita");
			user.setLastName("Gupta");
			user.setId("smita");
			user.setLogin("smita");
			user.setPassword("admin");
			user.getRole().add("admin");
			user.getRole().add("user");
		}
		return user;
	}
    
}