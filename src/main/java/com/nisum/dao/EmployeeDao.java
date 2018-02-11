package com.nisum.dao;

import java.util.List;

import com.nisum.employee.Employee;

public interface EmployeeDao {
	Employee saveEmployee(Employee e);
	Employee updateEmployee(Employee e);
	String deleteEmployee(int eid);
	List<Employee> getAllEmployee();
	Employee getByEid(Integer eid);
}
