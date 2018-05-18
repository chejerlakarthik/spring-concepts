package com.karthik.data.hibernate.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.karthik.data.hibernate.dao.EmployeeDao;
import com.karthik.data.hibernate.model.Employee;

@Transactional
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

	protected Session getSession() {
		return getSessionFactory().getCurrentSession();
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		// Obtain criteria builder and subsequently, criteria query from it
		CriteriaQuery<Employee> criteria = getSession().getCriteriaBuilder().createQuery(Employee.class);
		// Specify criteria root
		criteria.from(Employee.class);
		// Execute the criteria query with the session
		List<Employee> employees = getSession().createQuery(criteria).getResultList();
		return employees;
	}

	@Override
	public Employee getEmployee(Integer employeeId) {
		return getSession().get(Employee.class, employeeId);
	}

	@Override
	public Integer addEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Integer id = (Integer) session.save(employee);
		return id;
	}

	@Override
	public void updateEmployee(Integer employeeId, Employee employee) {
		Employee searchEmployee = getSession().find(Employee.class, employeeId);
		if(null != searchEmployee) {
			Employee emp = new Employee();
			emp.setEmployeeId(employeeId);
			emp.setEmployeeName(employee.getEmployeeName());
			getSession().flush();
		}
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		Employee toDelete = getSession().byId(Employee.class).load(employeeId);
		getSession().delete(toDelete);
	}

}
