package com.crud.model.dao;

import java.util.List;

import com.crud.model.dao.Employee;

public interface EmployeeDao {
	
	public List<Employee> displayAllEmployees();
	public void addEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public Employee getEmployeeById(int empId);
	public void deleteEmployee(int empId);
	

}
