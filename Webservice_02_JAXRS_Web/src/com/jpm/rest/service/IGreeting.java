/**
 * 
 */
package com.jpm.rest.service;

import javax.ws.rs.core.Response;

/**
 * @author Smita B Kumar
 *
 */
public interface IGreeting {
	public Response getMsg(String name);
}
