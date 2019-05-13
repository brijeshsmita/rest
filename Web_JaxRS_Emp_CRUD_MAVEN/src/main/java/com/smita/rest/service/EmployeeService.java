/**
 * 
 */
package com.smita.rest.service;

import java.util.List;

import com.smita.rest.dao.EmployeeDao;
import com.smita.rest.dao.IEmployeeDao;
import com.smita.rest.entity.Employee;
import com.smita.rest.exception.EmployeeException;

/**
 * @author Smita B Kumar
 *
 */
public class EmployeeService implements IEmployeeService {
	private IEmployeeDao employeeDao;
	public EmployeeService() {
		employeeDao=new EmployeeDao();
	}

	@Override
	public Employee getEmployee(String empNo) throws EmployeeException {
		return employeeDao.getEmployee(empNo);
	}

	@Override
	public Employee addEmployee(Employee emp) throws EmployeeException {
		return employeeDao.addEmployee(emp);
	}

	@Override
	public Employee updateEmployee(Employee emp) throws EmployeeException {
		return employeeDao.updateEmployee(emp);
	}

	@Override
	public Employee deleteEmployee(String empNo) throws EmployeeException {
		return employeeDao.deleteEmployee(empNo);
	}

	@Override
	public List<Employee> getAllEmployees() throws EmployeeException {
		
		return employeeDao.getAllEmployees();
	}

}