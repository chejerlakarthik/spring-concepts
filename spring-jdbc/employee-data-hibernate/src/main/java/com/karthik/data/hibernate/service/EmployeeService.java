package com.karthik.data.hibernate.service;

import java.util.List;

import com.karthik.data.hibernate.model.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	
	Employee getEmployee(Integer employeeId);
	
	Integer addEmployee(Employee employee);
	
	void updateEmployee(Integer employeeId, Employee employee);
	
	void deleteEmployee(Integer employeeId);

}
