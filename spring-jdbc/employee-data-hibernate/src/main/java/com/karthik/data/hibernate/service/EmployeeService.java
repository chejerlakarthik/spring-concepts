package com.karthik.data.hibernate.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.karthik.data.hibernate.model.Employee;

@Transactional
public interface EmployeeService extends ApplicationService<Employee,Integer>{
	
	List<Employee> findByName(String employeeName);
	
	List<Employee> findBySalaryGreaterThanInDepartment(Double salary, String departmentName);

}
