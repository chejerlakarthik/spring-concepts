package com.karthik.data.hibernate.service;

import java.util.List;

import com.karthik.data.hibernate.model.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	
	Employee getEmployee(Integer employeeId);
	
	void addEmployee(Employee employee);

}
