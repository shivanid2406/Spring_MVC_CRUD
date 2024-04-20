package com.crudDemo.service;

import java.util.List;

import com.crudDemo.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();

	Employee findById(int theId);

	Employee save(Employee theEmployee);

	void deleteById(int theId);
}
