package com.karthik.data.hibernate.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.karthik.data.hibernate.dao.EmployeeDao;
import com.karthik.data.hibernate.model.Employee;

@Transactional
public class EmployeeDaoImpl extends GenericDaoImpl<Employee, Integer> implements EmployeeDao{

	public EmployeeDaoImpl(Class<Employee> persistentClass) {
		super(persistentClass);
	}

//	@Override
//	public List<Employee> findByName(String employeeName) {
//		
//		CriteriaBuilder builder = getSession().getCriteriaBuilder();
//		CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
//		Root<Employee> root = query.from(Employee.class);
//		
//		query.select(root);
//		query.where(builder.equal(root.get("employeeName"), employeeName));
//		
//		List<Employee> employees = null;
//		
//		try {
//			employees = getSession().createQuery(query).getResultList();
//		} catch (Exception e) {
//			System.out.println("No records found for employeeName : "+ employeeName);
//		}
//		return employees;
//	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAll() {
		Query query = getSession().getNamedQuery("Employee.findAll");
		List<Employee> employees = query.getResultList();
		return employees;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findByName(String employeeName) {
		Query query = getSession().getNamedQuery("Employee.findByName");
		query.setParameter("e_name", employeeName);
		List<Employee> employees = query.getResultList();
		return employees;
	}

	@Override
	public Employee findById(Integer id) {
		Query query = getSession().getNamedQuery("Employee.findById");
		query.setParameter("e_id", id);
		Employee employee = (Employee) query.getSingleResult();
		return employee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findBySalaryGreaterThanInDepartment(String departmentName, Double salary) {
		Query query = getSession().getNamedQuery("Employee.findBySalaryGreaterThanInDepartment");
		query.setParameter("e_salary", salary);
		query.setParameter("d_name", departmentName);
		List<Employee> employees = query.getResultList();
		return employees;
	}

}
