package com.karthik.data.hibernate.dao;

import java.util.List;

import com.karthik.data.hibernate.model.Employee;

public interface EmployeeDao {
	
	List<Employee> getAllEmployees();
	
	Employee getEmployee(Integer employeeId);
	
	Integer addEmployee(Employee employee);
	
	void updateEmployee(Integer employeeId, Employee employee);
	
	void deleteEmployee(Integer employeeId);

}
