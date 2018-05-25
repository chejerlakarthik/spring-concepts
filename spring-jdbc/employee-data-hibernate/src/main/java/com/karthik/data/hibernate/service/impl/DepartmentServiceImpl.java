package com.karthik.data.hibernate.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.karthik.data.hibernate.dao.DepartmentDao;
import com.karthik.data.hibernate.model.Department;
import com.karthik.data.hibernate.service.DepartmentService;

@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDao departmentDao;
	
	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public List<Department> getAll() {
		return this.departmentDao.getAll();
	}

	@Override
	public Department get(Integer id) {
		return this.departmentDao.get(id);
	}

	@Override
	public Integer add(Department entity) {
		return (Integer) this.departmentDao.add(entity);
	}

	@Override
	public void delete(Department entity) {
		this.departmentDao.delete(entity);
	}

	@Override
	public void deleteById(Integer id) {
		this.departmentDao.deleteById(id);
	}

	@Override
	public void update(Department entity) {
		this.departmentDao.update(entity);
	}

	@Override
	public List<Serializable> addDepartments(List<Department> departments) {
		return this.departmentDao.addDepartments(departments);
	}

	@Override
	public Department findByName(String employeeName) {
		return this.departmentDao.findByName(employeeName);
	}

}
