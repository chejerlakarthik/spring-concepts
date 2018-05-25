package com.karthik.data.hibernate.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.karthik.data.hibernate.model.Department;

@Transactional
public interface DepartmentService extends ApplicationService<Department>{
	
	Department findByName(String employeeName);
	
	List<Serializable> addDepartments(List<Department> departments);

}
