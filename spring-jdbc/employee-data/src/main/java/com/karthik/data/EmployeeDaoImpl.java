package com.karthik.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/employeedb";
	private static final String SELECT_ALL_EMPLOYEES = "select * from dbo.employee";
	
	private void registerDatabaseDriver() {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			System.out.println(e.getMessage());
		} 
	}

	@Override
	public Employee getEmployee(Integer employeeId) {
		return null;
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateEmployee(Integer employeeId, Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		registerDatabaseDriver();
		try {
			Connection connection = DriverManager.getConnection(DB_URL, "karthikchejerla", "daksha");
			PreparedStatement ps = connection.prepareStatement(SELECT_ALL_EMPLOYEES);
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(resultSet.getInt("emp_id"));
				emp.setEmployeeName(resultSet.getString("emp_name"));
				employees.add(emp);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return employees;
	}

}
