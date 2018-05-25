package com.karthik.data.hibernate.service;

import org.springframework.transaction.annotation.Transactional;

import com.karthik.data.hibernate.model.Employee;

@Transactional
public interface EmployeeService extends ApplicationService<Employee>{
	
	Employee findByName(String employeeName);

}
