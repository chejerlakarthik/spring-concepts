package com.karthik.data.hibernate.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.karthik.data.hibernate.dao.EmployeeDao;
import com.karthik.data.hibernate.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	
	private SessionFactory sessionFactory;

	public EmployeeDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Employee> getAllEmployees() {
		Session session = sessionFactory.openSession();

		// Obtain criteria builder and subsequently, criteria query from it
		CriteriaQuery<Employee> criteria = session.getCriteriaBuilder().createQuery(Employee.class);

		// Specify criteria root
		criteria.from(Employee.class);

		// Execute the criteria query with the session
		List<Employee> employees = session.createQuery(criteria).getResultList();

		return employees;
	}

	@Override
	public Employee getEmployee(Integer employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		session.save(employee);
	}

	@Override
	public void updateEmployee(Integer employeeId, Employee employee) {
		Session session = sessionFactory.openSession();
		Employee searchEmployee = session.find(Employee.class, employeeId);
		if(null != searchEmployee) {
			session.save(employee);
		}
	}

}
