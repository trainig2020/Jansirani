package com.crud.model.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	@NotEmpty
	@Size(min = 4, max = 30)
	private String empName;
	@NotEmpty
	private String password;
	@NotEmpty
	@Size(min = 4, max = 30)
	private String email;
	@NotEmpty
	@Size(min = 4, max = 30)
	private String address;
	@NotEmpty
	@Size(min = 4, max = 30)
	private String phoneNo;

	public Employee(Integer empId) {
		super();
		this.empId = empId;
	}

	public Employee() {
		super();
	}

	public Employee(Integer empId, String empName, String password, String email, String address, String phoneNo) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.password = password;
		this.email = email;
		this.address = address;
		this.phoneNo = phoneNo;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", password=" + password + ", email=" + email
				+ ", address=" + address + ", phoneNo=" + phoneNo + "]";
	}

}
