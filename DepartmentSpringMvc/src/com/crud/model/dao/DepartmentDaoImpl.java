package com.crud.model.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class DepartmentDaoImpl implements DepartmentDao {

	@Autowired
	private SessionFactory sessionFactory;

	public DepartmentDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DepartmentDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Department> displayAllDepartments() {
		return getSession().createQuery("from Department").list();
	}

	@Override
	public void addDepartment(Department department) {
		getSession().save(department);

	}

	@Override
	public void updateDepartment(Department department) {
		getSession().merge(department);

	}

	@Override
	public Department getDepartmentById(int deptId) {
		Department department = (Department) getSession().get(Department.class, deptId);
		if (department == null)
			throw new DepartmentNotFoundException("department with id=" + deptId + " is not found");
		return department;
	}

	@Override
	public void deleteDepartment(int deptId) {
		getSession().createQuery("DELETE FROM Department WHERE deptId = " + deptId).executeUpdate();

	}

}
