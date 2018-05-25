package com.karthik.data.hibernate.dao;

import com.karthik.data.hibernate.model.Employee;

public interface EmployeeDao extends GenericDao<Employee> {
	
	Employee findByName(String employeeName);
	
}
