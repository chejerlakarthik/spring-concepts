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
	public Employee get(Integer employeeId) {
		return this.employeeDao.read(employeeId);
	}

	@Override
	public Employee add(Employee employee) {
		return this.employeeDao.create(employee);
	}

	@Override
	public void update(Employee employee) {
		this.employeeDao.update(employee);
	}

	@Override
	public void deleteById(Integer employeeId) {
		Employee employee = this.employeeDao.read(employeeId);
		if (!Objects.isNull(employee)) {
			this.employeeDao.delete(employee);
		}
	}

	@Override
	public void delete(Employee entity) {
		this.employeeDao.delete(entity);
	}

	@Override
	public List<Employee> findByName(String employeeName) {
		return this.employeeDao.findByName(employeeName);
	}

	@Override
	public List<Employee> getAll() {
		return this.employeeDao.findAll();
	}

	@Override
	public List<Employee> findBySalaryGreaterThanInDepartment(Double salary, String departmentName) {
		return this.employeeDao.findBySalaryGreaterThanInDepartment(departmentName, salary);
	}

}
