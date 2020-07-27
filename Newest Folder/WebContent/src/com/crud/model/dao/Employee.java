package com.crud.model.dao;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	private String empName;
	private String password;
	private String email;
	private String address;
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
