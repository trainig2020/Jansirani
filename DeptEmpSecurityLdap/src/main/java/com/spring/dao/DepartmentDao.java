package com.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.model.Department;
@Repository
public interface DepartmentDao {
	

		public void insertDepartment(Department dept);

		public List<Department> getAllDepartments();
		
		public String updateDepartment(Department dept);
		
		public void deleteDepartment(int deptId);

		Department getDeptById(int deptId);

	

}
