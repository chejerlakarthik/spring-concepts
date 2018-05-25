package com.karthik.data.hibernate.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Transactional;

import com.karthik.data.hibernate.dao.EmployeeDao;
import com.karthik.data.hibernate.model.Employee;

@Transactional
public class EmployeeDaoImpl extends GenericDaoImpl<Employee, Integer> implements EmployeeDao{

	public EmployeeDaoImpl() {
		super(Employee.class);
	}

	@Override
	public Employee findByName(String employeeName) {
		
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
		Root<Employee> root = query.from(Employee.class);
		
		query.select(root);
		query.where(builder.equal(root.get("employeeName"), employeeName));
		
		Employee employee = null;
		
		try {
			employee = getSession().createQuery(query).getSingleResult();
		} catch (Exception e) {
			System.out.println("No records found for employeeName : "+ employeeName);
		}
		return employee;
	}

}
