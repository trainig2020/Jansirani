package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.model.dao.Employee;
import com.crud.model.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	
	
	 
		public EmployeeServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

		public EmployeeServiceImpl(EmployeeDao employeeDao) {
			super();
			this.employeeDao = employeeDao;
		}

	@Override
	public List<Employee> displayAllEmployees() {
		return employeeDao.displayAllEmployees();
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
		
	}

	@Override
	public Employee getEmployeeById(int empId) {
		return employeeDao.getEmployeeById(empId);
	}

	@Override
	public void deleteEmployee(int empId) {
		employeeDao.deleteEmployee(empId);
		
	}

}
