/**
 * 
 */
package com.smita.rest.service;

import java.util.List;

import com.smita.rest.entity.Employee;
import com.smita.rest.exception.EmployeeException;

/**
 * @author Smita B Kumar
 *
 */
public interface IEmployeeService {

	public Employee getEmployee(String empNo)throws EmployeeException;

	public Employee addEmployee(Employee emp) throws EmployeeException;

	public Employee updateEmployee(Employee emp) throws EmployeeException;

	public Employee deleteEmployee(String empNo) throws EmployeeException;

	public List<Employee> getAllEmployees() throws EmployeeException;

}
