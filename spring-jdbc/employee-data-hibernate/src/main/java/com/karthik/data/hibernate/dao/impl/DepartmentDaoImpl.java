package com.karthik.data.hibernate.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Transactional;

import com.karthik.data.hibernate.dao.DepartmentDao;
import com.karthik.data.hibernate.model.Department;

@Transactional
public class DepartmentDaoImpl extends GenericDaoImpl<Department,Integer> implements DepartmentDao {

	public DepartmentDaoImpl() {
		super(Department.class);
	}

	@Override
	public List<Serializable> addDepartments(List<Department> departments) {
		List<Serializable> departmentIds = new ArrayList<Serializable>();
		for (Department dept : departments) {
			departmentIds.add(this.add(dept));
		}
		return departmentIds;
	}

	@Override
	public Department findByName(String name) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Department> query = builder.createQuery(Department.class);
		Root<Department> root = query.from(Department.class);
		
		query.select(root);
		query.where(builder.equal(root.get("departmentName"), name));
		
		Department department = getSession().createQuery(query).getSingleResult();
		return department;
	}

}
