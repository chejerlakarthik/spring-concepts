package com.karthik.data.model;

import java.util.List;

public interface EmployeeDao {
	
	List<Employee> getAllEmployees();
	
	Employee getEmployee(Integer employeeId);
	
	int addEmployee(Employee employee);
	
	int deleteEmployee(Integer employeeId);
	
	int updateEmployee(Integer employeeId, Employee employee);

}
