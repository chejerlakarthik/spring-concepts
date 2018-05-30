package com.karthik.data.hibernate.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.karthik.data.hibernate.dao.DepartmentDao;
import com.karthik.data.hibernate.model.Department;

@Transactional
public class DepartmentDaoImpl extends GenericDaoImpl<Department,Integer> implements DepartmentDao {

	public DepartmentDaoImpl(Class<Department> persistentClass) {
		super(persistentClass);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findAll() {
		Query query = getSession().getNamedQuery("Department.findAll");
		List<Department> departments = query.getResultList();
		return departments;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findByName(String departmentName) {
		Query query = getSession().getNamedQuery("Department.findByName");
		query.setParameter("d_name", departmentName);
		List<Department> departments = query.getResultList();
		return departments;
	}

}
