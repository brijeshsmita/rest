/**
 * 
 */
package com.smita.rest.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.smita.rest.entity.Employee;
import com.smita.rest.exception.EmployeeException;

/**
 * @author Smita B Kumar
 *
 */
public class EmployeeDao implements IEmployeeDao {
	List<Employee> list;
	private static final Map<String, Employee> empMap = new HashMap<String, Employee>();

	static {
		initEmps();
	}

	private static void initEmps() {
		Employee emp1 = new Employee("E01", "Smith", "Clerk");
		Employee emp2 = new Employee("E02", "Allen", "Salesman");
		Employee emp3 = new Employee("E03", "Jones", "Manager");

		empMap.put(emp1.getEmpNo(), emp1);
		empMap.put(emp2.getEmpNo(), emp2);
		empMap.put(emp3.getEmpNo(), emp3);
	}

	@Override
	public Employee getEmployee(String empNo) throws EmployeeException {
		return empMap.get(empNo);
	}

	@Override
	public Employee addEmployee(Employee emp) throws EmployeeException {
		empMap.put(emp.getEmpNo(), emp);
		return emp;
	}

	@Override
	public Employee updateEmployee(Employee emp) throws EmployeeException {
		empMap.put(emp.getEmpNo(), emp);
		return emp;
	}

	@Override
	public Employee deleteEmployee(String empNo) throws EmployeeException {
		return empMap.remove(empNo);
	}

	@Override
	public List<Employee> getAllEmployees() throws EmployeeException {
		Collection<Employee> c = empMap.values();
		List<Employee> list = new ArrayList<Employee>();
		list.addAll(c);
		return list;
	}

}