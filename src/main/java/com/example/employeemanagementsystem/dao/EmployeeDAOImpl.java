package com.example.employeemanagementsystem.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.employeemanagementsystem.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	private EntityManager entityManager;

	public EmployeeDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		
		//create a query
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
		
		//execute query a get the result
		List<Employee> employees = theQuery.getResultList();
		
		//return the result
		return employees;
	}

	@Override
	public Employee findById(int id) {
		
		//create a query
		Employee thEmployee = entityManager.find(Employee.class, id);
		
		//return employee
		return thEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		//save employee
		Employee dbEmployee = entityManager.merge(theEmployee);
		
		//return the dbEmployee
		return dbEmployee;
	}

	@Override
	public void deleteById(int id) {
		//find the employee by id
		Employee thEmployee = entityManager.find(Employee.class, id);
		
		//remove the employee
		entityManager.remove(thEmployee);
	}

}
