package com.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.model.Employee;

@Repository
public interface EmployeeDao {

	public void insertEmployee(Employee emp);

	public Employee updateEmployee(Employee emp);

	public void deleteEmployee(int id);

	public Employee getEmployees(int id);

	public List<Employee> getAllEmployees();

	public List<Employee> getEmployeesByDept(int deptId);

}
