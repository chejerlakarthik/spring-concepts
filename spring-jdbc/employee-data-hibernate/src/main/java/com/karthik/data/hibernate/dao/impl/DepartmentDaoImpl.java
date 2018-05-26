package com.karthik.data.hibernate.dao.impl;

import org.springframework.transaction.annotation.Transactional;

import com.karthik.data.hibernate.dao.DepartmentDao;
import com.karthik.data.hibernate.model.Department;

@Transactional
public class DepartmentDaoImpl extends GenericDaoImpl<Department,Integer> implements DepartmentDao {

	public DepartmentDaoImpl(Class<Department> persistentClass) {
		super(persistentClass);
	}

}
