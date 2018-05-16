package com.karthik.data;

import java.util.List;

public interface EmployeeDao {
	
	List<Employee> getAllEmployees();
	
	Employee getEmployee(Integer employeeId);
	
	void addEmployee(Employee employee);
	
	void deleteEmployee(Integer employeeId);
	
	void updateEmployee(Integer employeeId, Employee employee);

}
