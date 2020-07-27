package com.crud.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.crud.model.dao.Employee;
import com.crud.service.EmployeeService;

@Controller
public class EmployeeController {
    
	@Autowired
	private EmployeeService employeeService;
	

	
	public EmployeeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@RequestMapping(value = "deleteaccount", method = RequestMethod.GET)
	public String deleteEmployee(HttpServletRequest request) {
		Integer empId = Integer.parseInt(request.getParameter("empId"));
		employeeService.deleteEmployee(empId);
		return "redirect:/allemployees";
	}

	@RequestMapping(value = "updateaccount", method = RequestMethod.GET)
	public String updateEmployee(HttpServletRequest request, ModelMap map) {
		Integer empId = Integer.parseInt(request.getParameter("empId").trim());

		map.addAttribute("employee", employeeService.getEmployeeById(empId));
		Employee emp = new Employee(empId);
		employeeService.updateEmployee(emp);
		return "addemployee";
	}   
	
	

	@RequestMapping(value = "addemployee", method = RequestMethod.POST)
	public String addEmployeePost(@Validated @ModelAttribute(value = "employee") Employee employee,
			BindingResult bindingResult) {
		employeeService.addEmployee(employee);
			return "redirect:/allemployees";
		
	}

	/* this will display a page that allow to submit new account */
	@RequestMapping(value = "addemployee", method = RequestMethod.GET)
	public String getEmployee(ModelMap map) {
		map.addAttribute("employee", new Employee());
		return "addemployee";
	}

	/* this will display all accounts */
	@RequestMapping(value = "allemployees", method = RequestMethod.GET)
	public String allEmployees(ModelMap map) {
		map.addAttribute("employees", employeeService.displayAllEmployees());
		return "allemployees";
	}
	
	


}
