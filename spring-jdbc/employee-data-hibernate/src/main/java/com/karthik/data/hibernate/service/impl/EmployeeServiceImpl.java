package com.karthik.data.hibernate.service.impl;

import java.util.List;
import java.util.Objects;

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
	public List<Employee> getAll() {
		return this.employeeDao.findAll();
	}

	@Override
	public Employee get(Integer employeeId) {
		return this.employeeDao.findById(employeeId, true);
	}

	@Override
	public Employee add(Employee employee) {
		return this.employeeDao.makePersistent(employee);
	}

	@Override
	public void update(Employee employee) {
		this.employeeDao.makePersistent(employee);
	}

	@Override
	public void deleteById(Integer employeeId) {
		Employee employee = this.employeeDao.findById(employeeId, true);
		if (!Objects.isNull(employee)) {
			this.employeeDao.makeTransient(employee);
		}
	}

	@Override
	public void delete(Employee entity) {
		this.employeeDao.makeTransient(entity);
	}

	@Override
	public Employee findByName(String employeeName) {
		return this.employeeDao.findByName(employeeName);
	}

}
