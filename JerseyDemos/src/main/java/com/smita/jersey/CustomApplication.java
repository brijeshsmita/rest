package com.smita.jersey;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import com.smita.jersey.provider.AuthenticationFilter;

public class CustomApplication extends ResourceConfig 
{
	public CustomApplication() 
	{
		packages("com.smita.jersey");
		register(LoggingFilter.class);
		register(RolesAllowedDynamicFeature.class);
		register(AuthenticationFilter.class);
	}
}
