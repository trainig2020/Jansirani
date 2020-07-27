package com.crud.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public String updateemployee(HttpServletRequest request, ModelMap map) {
		Integer empId = Integer.parseInt(request.getParameter("empId").trim());

		map.addAttribute("employee", employeeService.getEmployeeById(empId));
		return "addemployee";
	}


	@RequestMapping(value = "addemployee", method = RequestMethod.POST)
	public String addEmployeePost(@Valid @ModelAttribute(value = "employee") Employee employee,
			BindingResult bindingResult) {
		if (employee.getEmpId() == null) {

				employeeService.addEmployee(employee);
			} else {
				employeeService.updateEmployee(employee);
			}
		
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
