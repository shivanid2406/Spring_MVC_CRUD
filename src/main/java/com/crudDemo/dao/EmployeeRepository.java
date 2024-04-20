package com.crudDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudDemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
