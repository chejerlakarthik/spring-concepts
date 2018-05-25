package com.karthik.data.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import com.karthik.data.hibernate.model.Department;

public interface DepartmentDao extends GenericDao<Department, Integer> {
	
	Department findByName(String name);
	
	List<Serializable> addDepartments(List<Department> departments);

}
