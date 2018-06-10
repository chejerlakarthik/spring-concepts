package com.karthik.data.hibernate.dao;

import java.util.List;

import com.karthik.data.hibernate.model.Employee;

public interface EmployeeDao extends GenericDao<Employee, Integer> {
	
	List<Employee> findAll();
	
	List<Employee> findByName(String employeeName);
	
	Employee findById(Integer id);
	
	List<Employee> findBySalaryGreaterThanInDepartment(String departmentName, Double salary);
	
}
