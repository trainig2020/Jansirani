package com.crud.service;

import java.util.List;

import com.crud.model.dao.Department;

public interface DepartmentService {
	
	
	public List<Department> displayAllDepartments();
	public void addDepartment(Department department);
	public void updateDepartment(Department department);
	public Department getDepartmentById(int deptId);
	public void deleteDepartment(int deptId);

}
