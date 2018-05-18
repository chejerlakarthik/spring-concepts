package com.karthik.data.hibernate.service.impl;

import java.util.List;

import com.karthik.data.hibernate.dao.EmployeeDao;
import com.karthik.data.hibernate.model.Employee;
import com.karthik.data.hibernate.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{

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
	public Integer addEmployee(Employee employee) {
		return this.employeeDao.addEmployee(employee);
	}

	@Override
	public void updateEmployee(Integer employeeId, Employee employee) {
		this.employeeDao.updateEmployee(employeeId, employee);
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		this.employeeDao.deleteEmployee(employeeId);
	}

}
