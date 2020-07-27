package com.crud.model.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	

	public EmployeeDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getSession(){
		return sessionFactory.openSession();
	}

	@Override
	public List<Employee> displayAllEmployees() {
		return getSession().createQuery("from Employee").list();
	}

	@Override
	public void addEmployee(Employee employee) {
		getSession().save(employee);
	}

	

	@Override
	public void updateEmployee(Employee employee) {
		 
		 getSession().update(employee);
	}

	@Override
	public Employee getEmployeeById(int empId) {
		Employee employee=(Employee) getSession().get(Employee.class, empId);
		if(employee==null)
			throw new EmployeeNotFoundException("employee with id="+ empId+ " is not found");
		return employee;
	}

	@Override
	public void deleteEmployee(int empId) {
		getSession().createQuery("DELETE FROM Employee WHERE empid = "+empId).executeUpdate();
		 
	}

}
