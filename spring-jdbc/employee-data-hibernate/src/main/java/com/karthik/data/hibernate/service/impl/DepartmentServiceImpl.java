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
		return this.departmentDao.findById(id, true);
	}

	@Override
	public Department add(Department entity) {
		return this.departmentDao.makePersistent(entity);
	}

	@Override
	public void delete(Department entity) {
		this.departmentDao.makeTransient(entity);
	}

	@Override
	public void deleteById(Integer id) {
		Department department = this.departmentDao.findById(id, true);
		if (!Objects.isNull(department)) {
			this.departmentDao.makeTransient(department);
		}
	}

	@Override
	public void update(Department entity) {
		this.departmentDao.makePersistent(entity);
	}

	@Override
	public Department findByName(String employeeName) {
		Department dept = new Department("HR", "Human Resources");
		dept.setDepartmentId(1);
		return dept;
	}

	@Override
	public void addDepartments(List<Department> departments) {
		this.departmentDao.addList(departments);
	}

}
