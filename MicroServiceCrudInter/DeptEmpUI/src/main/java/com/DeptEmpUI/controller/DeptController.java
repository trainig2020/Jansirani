package com.DeptEmpUI.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import com.DeptEmpUI.model.Department;
import com.DeptEmpUI.model.DepartmentList;
import com.DeptEmpUI.model.Employee;
import com.DeptEmpUI.model.EmployeeList;

@RestController

public class DeptController {

	Logger logger = LoggerFactory.getLogger(DeptController.class);

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/")
	public ModelAndView loginPage() {
		return new ModelAndView("redirect:/listDept");

	}

	@GetMapping("/home")
	public ModelAndView listDeptId(HttpServletRequest request, ModelAndView modelAndView,
			@RequestParam(required = false) Integer page) {
		logger.info("From deptcontroller list of department");
		DepartmentList lst = restTemplate.getForObject("http://dept-emp-service/organize/listDept",
				DepartmentList.class);
		int deptId = lst.getDepartments().get(0).getDeptId();
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("page", page);
		if(page!=null) {
			return new ModelAndView("redirect:/listDeptName?deptId=" + deptId+"&page="+page);
		}
		return new ModelAndView("redirect:/listDeptName?deptId=" + deptId);

	}

	@GetMapping("/listDeptName")
	public ModelAndView listDeptName(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession httpSession = request.getSession();
		logger.info("From deptcontroller list of department and employee");
		int id = Integer.parseInt(request.getParameter("deptId"));
		List<Department> lstDept = new ArrayList<Department>();

		DepartmentList lst = restTemplate.getForObject("http://dept-emp-service/organize/listDept",
				DepartmentList.class);
		for (int i = 0; i < lst.getDepartments().size(); i++) {
			lstDept.add(lst.getDepartments().get(i));
		}
		EmployeeList empLst = restTemplate.getForObject("http://dept-emp-service/organize/emp/" + id,
				EmployeeList.class);
		List<Employee> listEmp = new ArrayList<Employee>();
		for (int i = 0; i < empLst.getEmployees().size(); i++) {
			listEmp.add(empLst.getEmployees().get(i));
		}

		

		PagedListHolder<Employee> pagedListHolder = new PagedListHolder<Employee>(listEmp);
		pagedListHolder.setPageSize(2);
		ModelAndView modelAndView = new ModelAndView("form");

		modelAndView.addObject("maxPages", pagedListHolder.getPageCount());
		
		Integer page = (Integer) httpSession.getAttribute("page");

		if (page == null || page < 1 || page > pagedListHolder.getPageCount())
			page = 1;

		modelAndView.addObject("page", page);
		if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(0);
			modelAndView.addObject("empLst", pagedListHolder.getPageList());
		} else if (page <= pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(page - 1);
			modelAndView.addObject("empLst", pagedListHolder.getPageList());
		}

		httpSession.setAttribute("empLst", listEmp);
		modelAndView.addObject("deptLst", lstDept);
		// modelAndView.addObject("empLst", listEmp);
		modelAndView.addObject("home", "homemp");
		modelAndView.addObject("check", "checklist");
		

		return modelAndView;

	}

	

	@GetMapping("/listDept")
	public ModelAndView listDepartment(HttpServletRequest request, @RequestParam(required = false) Integer page) {

		logger.info("From deptcontroller list of department");
		List<Department> lstDept = new ArrayList<Department>();

		DepartmentList lst = restTemplate.getForObject("http://dept-emp-service/organize/listDept",
				DepartmentList.class);
		System.out.println("In list dept");
		for (int i = 0; i < lst.getDepartments().size(); i++) {
			lstDept.add(lst.getDepartments().get(i));
		}
		ModelAndView modelAndView = new ModelAndView("form");
		PagedListHolder<Department> pagedListHolder = new PagedListHolder<Department>(lstDept);
		pagedListHolder.setPageSize(2);

		modelAndView.addObject("maxPages", pagedListHolder.getPageCount());

		if (page == null || page < 1 || page > pagedListHolder.getPageCount())
			page = 1;

		modelAndView.addObject("page", page);
		if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(0);
			modelAndView.addObject("deptList", pagedListHolder.getPageList());
		} else if (page <= pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(page - 1);
			modelAndView.addObject("deptList", pagedListHolder.getPageList());
		}

		HttpSession session = request.getSession();
		session.setAttribute("deptList", lstDept);
		return modelAndView;

	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/newDept")
	public ModelAndView newDepartment(ModelAndView model, HttpServletRequest request) {
		logger.info("From deptcontroller creating new department");
		String Register = "NewFormDept";
		HttpSession session1 = request.getSession();
		List<Department> lst = (List<Department>) session1.getAttribute("deptList");
		session1.setAttribute("deptList", lst);
		model.addObject("Register", Register);
		model.addObject("insertDept", "newDept");
		model.setViewName("form");
		Department department = new Department();
		model.addObject("department", department);
		return model;
	}

	@PostMapping(value = "/saveDept")
	public ModelAndView saveDepartment1(@ModelAttribute Department department, HttpServletRequest request) {
		logger.info("From deptcontroller creating new department");
		@SuppressWarnings("unused")
		ModelAndView model = new ModelAndView("form");
		Department department1 = new Department();
		department1.setDeptId(department.getDeptId());
		department1.setDeptName(department.getDeptName());
		restTemplate.postForObject("http://dept-emp-service/organize/addDept", department1, Department.class);
		System.out.println("In save department");
		return new ModelAndView("redirect:/listDept");

	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/editDept")
	public ModelAndView editDepartment(HttpServletRequest request) {
		logger.info("From deptcontroller updating department");
		int deptId = Integer.parseInt(request.getParameter("id"));
		HttpSession session2 = request.getSession();
		Department department = restTemplate.getForObject("http://dept-emp-service/organize/listDept/" + deptId,
				Department.class);
		session2.setAttribute("department", department);
		List<Department> lst = (List<Department>) session2.getAttribute("deptList");
		session2.setAttribute("deptList", lst);
		ModelAndView model = new ModelAndView("form");
		model.addObject("deptList", lst);
		model.addObject("departId", deptId);
		return model;
	}
	
	@GetMapping("/language")
	public ModelAndView getLanguage() {
		return new ModelAndView("redirect:/listDept");

	}

	@PostMapping(value = "/updateDept")
	public ModelAndView updateEmployee(HttpServletRequest request, @ModelAttribute Department department) {
		logger.info("From deptcontroller updating department");
		int deptId = Integer.parseInt(request.getParameter("deptId"));

		Department department1 = new Department();
		department1.setDeptId(department.getDeptId());
		department1.setDeptName(department.getDeptName());

		restTemplate.put("http://dept-emp-service/organize/updateDept/" + deptId, department1);

		return new ModelAndView("redirect:/listDept");

	}

	@GetMapping(value = "/deleteDept")
	public ModelAndView deleteDepartment(HttpServletRequest request) {
		logger.info("From deptcontroller deleting department");
		int departId = Integer.parseInt(request.getParameter("id"));
		restTemplate.delete("http://dept-emp-service/organize/deleteDept/" + departId);
		return new ModelAndView("redirect:/listDept");
	}

}
