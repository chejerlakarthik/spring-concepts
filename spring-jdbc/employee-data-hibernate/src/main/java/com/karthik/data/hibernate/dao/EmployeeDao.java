package com.karthik.data.hibernate.dao;

import com.karthik.data.hibernate.model.Employee;

public interface EmployeeDao extends GenericDao<Employee, Integer> {
	
	Employee findByName(String employeeName);
	
}
