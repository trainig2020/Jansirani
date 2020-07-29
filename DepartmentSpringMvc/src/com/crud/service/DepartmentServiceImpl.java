package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.model.dao.Department;
import com.crud.model.dao.DepartmentDao;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;

	public DepartmentServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DepartmentServiceImpl(DepartmentDao departmentDao) {
		super();
		this.departmentDao = departmentDao;
	}

	@Override
	public List<Department> displayAllDepartments() {

		return departmentDao.displayAllDepartments();
	}

	@Override
	public void addDepartment(Department department) {
		departmentDao.addDepartment(department);

	}

	@Override
	public void updateDepartment(Department department) {
		departmentDao.updateDepartment(department);

	}

	@Override
	public Department getDepartmentById(int deptId) {
		return departmentDao.getDepartmentById(deptId);
	}

	@Override
	public void deleteDepartment(int deptId) {
		departmentDao.deleteDepartment(deptId);

	}

}
