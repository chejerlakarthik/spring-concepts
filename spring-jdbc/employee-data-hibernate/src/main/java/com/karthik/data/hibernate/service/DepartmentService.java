package com.karthik.data.hibernate.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.karthik.data.hibernate.model.Department;

@Transactional
public interface DepartmentService extends ApplicationService<Department,Integer>{
	
	Department findByName(String employeeName);
	
	void addDepartments(List<Department> departments);

}
