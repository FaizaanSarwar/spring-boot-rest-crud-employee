package com.example.employeemanagementsystem.dao;

import java.util.List;

import com.example.employeemanagementsystem.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
	Employee findById(int id);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int id);
	
}
