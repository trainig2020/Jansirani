package com.crud.model.dao;

import java.util.List;

import com.crud.model.dao.Department;

public interface DepartmentDao {
	
	public List<Department> displayAllDepartments();
	public void addDepartment(Department department);
	public void updateDepartment(Department department);
	public Department getDepartmentById(int deptId);
	public void deleteDepartment(int deptId);
	

}
