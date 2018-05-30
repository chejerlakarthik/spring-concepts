package com.karthik.data.hibernate.service.impl;

import java.util.List;
import java.util.Objects;

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
		return this.departmentDao.findAll();
	}

	@Override
	public Department get(Integer id) {
		return this.departmentDao.read(id);
	}

	@Override
	public Department add(Department entity) {
		return this.departmentDao.create(entity);
	}

	@Override
	public void delete(Department entity) {
		this.departmentDao.delete(entity);
	}

	@Override
	public void deleteById(Integer id) {
		Department department = this.departmentDao.read(id);
		if (!Objects.isNull(department)) {
			this.departmentDao.delete(department);
		}
	}

	@Override
	public void update(Department entity) {
		this.departmentDao.update(entity);
	}

	@Override
	public void addDepartments(List<Department> departments) {
		this.departmentDao.createList(departments);
	}

	@Override
	public List<Department> findByName(String employeeName) {
		return this.departmentDao.findByName(employeeName);
	}

}
