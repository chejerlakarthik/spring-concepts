package com.karthik.data.hibernate.service.impl;

import java.util.List;

import com.karthik.data.hibernate.dao.EmployeeDao;
import com.karthik.data.hibernate.model.Employee;
import com.karthik.data.hibernate.service.EmployeeService;

public class EmployeeServiceImpl  implements EmployeeService{

	private EmployeeDao employeeDao;
	
	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return this.employeeDao.getAllEmployees();
	}

	@Override
	public Employee getEmployee(Integer employeeId) {
		return this.employeeDao.getEmployee(employeeId);
	}

	@Override
	public void addEmployee(Employee employee) {
		this.employeeDao.addEmployee(employee);
	}

}
