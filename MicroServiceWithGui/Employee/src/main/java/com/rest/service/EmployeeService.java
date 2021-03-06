package com.rest.service;

import java.util.List;

import com.rest.model.Employee;

public interface EmployeeService {

	public void insertEmployee(Employee emp);

	public Employee updateEmployee(int empid, Employee emp);

	public void deleteEmployee(int id);

	public Employee getEmployees(int empId);

	public List<Employee> getAllEmployees();

	public List<Employee> getEmployeesByDept(int deptId);

}
