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
import org.springframework.web.servlet.ModelAndView;

import com.crud.model.dao.Department;
import com.crud.service.DepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	public DepartmentController() {
		super();
	}

	public DepartmentController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}

	@RequestMapping(value = "deleteaccount", method = RequestMethod.GET)
	public String deleteDepartment(HttpServletRequest request) {
		Integer deptId = Integer.parseInt(request.getParameter("deptId"));
		departmentService.deleteDepartment(deptId);
		return "redirect:/alldepartments";
	}

	@RequestMapping(value = "updateaccount", method = RequestMethod.GET)
	public String updateDepartment(HttpServletRequest request, ModelMap map) {
		Integer deptId = Integer.parseInt(request.getParameter("deptId").trim());

		map.addAttribute("department", departmentService.getDepartmentById(deptId));
		return "adddepartment";
	}


	@RequestMapping(value = "adddepartment", method = RequestMethod.POST)
	public String addEmployeePost(@Valid @ModelAttribute(value = "department") Department department,
			BindingResult bindingResult,ModelMap map) {
		if (bindingResult.hasErrors()) {
			map.addAttribute("error", "Please enter a value for empName between 4 and 30 characters");
			return "DepartmentNotFoundException";
		}

		
		else if (department.getDeptId()== null) {

				departmentService.addDepartment(department);
			} else {
				departmentService.updateDepartment(department);
			}
		
		return "redirect:/alldepartments";
	}

	/* this will display a page that allow to submit new account */
	@RequestMapping(value = "adddepartment", method = RequestMethod.GET)
	public String getDepartment(ModelMap map) {
		map.addAttribute("department", new Department());
		return "adddepartment";
	}

	/* this will display all accounts */
	@RequestMapping(value = "alldepartments", method = RequestMethod.GET)
	public String allDepartments(ModelMap map) {
		map.addAttribute("departments", departmentService.displayAllDepartments());
		return "alldepartments";
	}

}
