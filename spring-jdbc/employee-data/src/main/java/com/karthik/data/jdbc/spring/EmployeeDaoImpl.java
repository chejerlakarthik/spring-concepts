package com.karthik.data.jdbc.spring;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.karthik.data.model.Employee;
import com.karthik.data.model.EmployeeDao;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private static final String SELECT_ALL_EMPLOYEES = "select * from dbo.employee";
	private static final String SELECT_EMPLOYEE = "select * from dbo.employee where emp_id=?";
	private static final String INSERT_EMPLOYEE = "insert into dbo.employee values(?, ?)";
	private static final String DELETE_EMPLOYEE = "delete from dbo.employee where emp_id=?";
	private static final String UPDATE_EMPLOYEE = "update dbo.employee set emp_name=? where emp_id=?";
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		employees = this.jdbcTemplate.query(SELECT_ALL_EMPLOYEES, getEmployeeRowMapper());
		return employees;
	}

	@Override
	public Employee getEmployee(Integer employeeId) {
		Object[] args = new Object[] { employeeId };
		int[] types = new int[] { Types.INTEGER };
		Employee employee = this.jdbcTemplate.queryForObject(SELECT_EMPLOYEE, args, types, getEmployeeRowMapper());
		return employee;
	}

	@Override
	public int addEmployee(Employee employee) {
		Object[] args = new Object[] { employee.getEmployeeId(), employee.getEmployeeName() };
		int[] types = new int[] { Types.INTEGER, Types.VARCHAR };
		return this.jdbcTemplate.update(INSERT_EMPLOYEE, args, types);
	}

	@Override
	public int deleteEmployee(Integer employeeId) {
		Object[] args = new Object[] { employeeId };
		int[] types = new int[] { Types.INTEGER };
		return this.jdbcTemplate.update(DELETE_EMPLOYEE, args, types);
	}

	@Override
	public int updateEmployee(Integer employeeId, Employee employee) {
		Object[] args = new Object[] { employee.getEmployeeName(), employeeId };
		int[] types = new int[] { Types.VARCHAR, Types.INTEGER };
		return this.jdbcTemplate.update(UPDATE_EMPLOYEE, args, types);
	}
	
	public EmployeeRowMapper getEmployeeRowMapper() {
		return new EmployeeRowMapper();
	}

}
