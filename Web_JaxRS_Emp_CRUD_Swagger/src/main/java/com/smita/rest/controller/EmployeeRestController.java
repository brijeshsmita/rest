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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Smita B Kumar
 *
 */
//http://localhost:8080/Web_JaxRS_Emp_CRUD_MAVEN/rest/employees
@Path("/employees")
//step 4: add swagger annotation in your rest service
@Api(value="Employee Demo Service")
public class EmployeeRestController {
	private IEmployeeService employeeService;
	public EmployeeRestController() {
		employeeService=new EmployeeService();
	}
	//http://localhost:8080/Web_JaxRS_Emp_CRUD_MAVEN/rest/employees
	// URI:
    // /contextPath/servletPath/employees
	//step 5: add swagger annotation in your rest service method
	@ApiResponse( code = 200, message = "Success JSON Employee List Fetched", 
	        		response = Employee.class, responseContainer = "List" ) 
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
 //http://localhost:8080/Web_JaxRS_Emp_CRUD_MAVEN/rest/employees/E01
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
 //http://localhost:8080/Web_JaxRS_Emp_CRUD_MAVEN/rest/employees
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
  //http://localhost:8080/Web_JaxRS_Emp_CRUD_MAVEN/rest/employees
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