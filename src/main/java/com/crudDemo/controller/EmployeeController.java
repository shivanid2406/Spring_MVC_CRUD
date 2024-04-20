package com.crudDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crudDemo.entity.Employee;
import com.crudDemo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	
	public EmployeeController(EmployeeService theEmployeeService) {
		service = theEmployeeService;
	}

	@GetMapping("/list")
	public String getEmployees(Model model) {

		List<Employee> theEmployee = service.findAll();
		model.addAttribute("employees", theEmployee);
		return "employees/list-employee";
	}

	@GetMapping("/showFormForAdd")
	public String addEmployee(Model model) {

		Employee theEmployee = new Employee();
		model.addAttribute("employees", theEmployee);
		return "employees/employee-form";
	}

	@GetMapping("/showFormForUpdate")
	public String updateEmployee(@RequestParam("employeeId") int id, Model model) {

		Employee theEmployee = service.findById(id);
		model.addAttribute("employees", theEmployee);
		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employees") Employee theEmployee) {

		service.save(theEmployee);
		return "redirect:/employees/list";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int id) {

		service.deleteById(id);
		return "redirect:/employees/list";
	}

}
