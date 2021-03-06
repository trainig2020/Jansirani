package com.DeptEmpUI.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import com.DeptEmpUI.model.Department;
import com.DeptEmpUI.model.Employee;

@RestController

public class EmployeeController {
	
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);  
	
	@Autowired
	private RestTemplate restTemplate;
	
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/newEmp")
	public ModelAndView showFormForAdd(HttpServletRequest request,ModelAndView modelAndView) {
		
		String Register  = "NewForm";
		HttpSession session1 = request.getSession();
		List<Employee> lst =(List<Employee>)session1.getAttribute("empLst");
		List<Department> deptlst = (List<Department>) session1.getAttribute("deptList");
		modelAndView.addObject("deptLst", deptlst);
		ModelAndView model = new ModelAndView("form");
		model.addObject("empLst", lst);
		model.addObject("deptLst",deptlst);
		model.addObject("Register", Register);
		model.addObject("addEmp", "regEmp");
		model.addObject("home", "homemp");	
		return model;	
	}
	
	@PostMapping(value = "/saveEmp")
	public ModelAndView saveEmployee( HttpServletRequest request,@ModelAttribute Employee employee) {
		logger.info("From EmployeeController Creating new employee");
		int deptId =  Integer.parseInt(request.getParameter("deptId"));
		Employee employee1 = new Employee();
		employee1.setEmpId(employee.getEmpId());
		employee1.setEmpName(employee.getEmpName());
		employee1.setAge(employee.getAge());
		employee1.setDeptId(employee.getDeptId());
		
		
		restTemplate.postForObject("http://dept-emp-service/organize/addEmp", employee1, Employee.class);

		return new ModelAndView("redirect:/listDeptName?deptId="+deptId);
	}


	@SuppressWarnings("unchecked")
	@GetMapping(value = "/editEmp")
	public ModelAndView editEmployee(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("empId"));
		int did =  Integer.parseInt(request.getParameter("deptId"));
		HttpSession session2 = request.getSession();
		List<Employee> lst =(List<Employee>) session2.getAttribute("empLst");
		List<Department> deptlst = (List<Department>) session2.getAttribute("deptList");
		
		session2.setAttribute("empLst", lst);
		ModelAndView model = new ModelAndView("form");
		model.addObject("home", "homemp");
		model.addObject("deptLst", deptlst);
		model.addObject("empLst", lst);
		model.addObject("employeeid", employeeId);
		model.addObject("deptId", did);
		return model;
	}

	@PostMapping(value = "/updateEmp")
	public ModelAndView updateEmployee(HttpServletRequest request, @ModelAttribute Employee employee) {
		logger.info("From EmployeeController updating employee");
		int employeeId = Integer.parseInt(request.getParameter("empId"));
		int deptId =  Integer.parseInt(request.getParameter("deptId"));
		
		  Employee employee1 = new Employee();
		  employee1.setEmpId(employee.getEmpId());
		  employee1.setEmpName(employee.getEmpName());
		  employee1.setAge(employee.getAge());
		  employee1.setDeptId(employee.getDeptId());
		 
		  restTemplate.put("http://dept-emp-service/organize/updateEmp/"+employeeId, employee);

		return new ModelAndView("redirect:/listDeptName?deptId="+deptId);

	}

	@GetMapping(value = "/deleteEmp")
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		
		logger.info("From EmployeeController deleting employee");
		int employeeId = Integer.parseInt(request.getParameter("empId"));
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		restTemplate.delete("http://dept-emp-service/organize/deleteEmp/"+employeeId);
		return new ModelAndView("redirect:/listDeptName?deptId="+deptId);
	}


}
