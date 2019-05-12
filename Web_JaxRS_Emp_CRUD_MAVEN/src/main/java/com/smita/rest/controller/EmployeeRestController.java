/**
 * 
 */
package com.smita.rest.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.smita.rest.entity.Employee;
import com.smita.rest.exception.EmployeeException;
import com.smita.rest.service.EmployeeService;
import com.smita.rest.service.IEmployeeService;

/**
 * @author Smita B Kumar
 *
 */
@Path("/employees")
public class EmployeeRestController {
	private IEmployeeService employeeService;
	public EmployeeRestController() {
		employeeService=new EmployeeService();
	}
	// URI:
    // /contextPath/servletPath/employees
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Employee> getEmployees_JSON() {
        List<Employee> listOfCountries=null;
		try {
			listOfCountries = employeeService.getAllEmployees();
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return listOfCountries;
    }
 
    // URI:
    // /contextPath/servletPath/employees/{empNo}
    @GET
    @Path("/{empNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Employee getEmployee(@PathParam("empNo") String empNo) {
    	Employee employee=null;
        try {
        	employee= employeeService.getEmployee(empNo);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
    }
 
    // URI:
    // /contextPath/servletPath/employees
    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Employee addEmployee(Employee emp) {
    	Employee employee=null;
        try {
        	employee= employeeService.addEmployee(emp);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
    }
 
    // URI:
    // /contextPath/servletPath/employees
    @PUT
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Employee updateEmployee(Employee emp) {
    	Employee employee=null;
        try {
        	employee= employeeService.updateEmployee(emp);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
    }
 
    @DELETE
    @Path("/{empNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Employee deleteEmployee(@PathParam("empNo") String empNo) {
    	Employee employee=null;
        try {
        	employee=employeeService.deleteEmployee(empNo);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
    }
}