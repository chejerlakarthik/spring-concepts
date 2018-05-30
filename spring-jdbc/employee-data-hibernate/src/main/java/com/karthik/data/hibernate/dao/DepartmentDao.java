package com.karthik.data.hibernate.dao;

import java.util.List;

import com.karthik.data.hibernate.model.Department;

public interface DepartmentDao extends GenericDao<Department, Integer> {

	List<Department> findAll();
	
	List<Department> findByName(String name);

}
