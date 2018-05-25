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
	public List<Employee> getAll() {
		return this.employeeDao.getAll();
	}

	@Override
	public Employee get(Integer employeeId) {
		return this.employeeDao.get(employeeId);
	}

	@Override
	public Integer add(Employee employee) {
		return (Integer) this.employeeDao.add(employee);
	}

	@Override
	public void update(Employee employee) {
		this.employeeDao.update(employee);
	}

	@Override
	public void deleteById(Integer employeeId) {
		this.employeeDao.deleteById(employeeId);
	}

	@Override
	public void delete(Employee entity) {
		this.employeeDao.delete(entity);
	}

	@Override
	public Employee findByName(String employeeName) {
		return this.employeeDao.findByName(employeeName);
	}

}
