package com.karthik.data.jdbc.traditional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.karthik.data.model.Employee;
import com.karthik.data.model.EmployeeDao;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/employeedb";
	private static final String SELECT_ALL_EMPLOYEES = "select * from dbo.employee";
	private static final String SELECT_EMPLOYEE = "select * from dbo.employee where emp_id=?";
	private static final String INSERT_EMPLOYEE = "insert into dbo.employee values(?, ?)";
	private static final String DELETE_EMPLOYEE = "delete from dbo.employee where emp_id=?";
	private static final String UPDATE_EMPLOYEE = "update dbo.employee set emp_name=? where emp_id=?";
	
	private void registerDatabaseDriver() {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			System.out.println(e.getMessage());
		} 
	}

	@Override
	public Employee getEmployee(Integer employeeId) {
		Employee employee = null;
		registerDatabaseDriver();
		try {
			Connection connection = getDatabaseConnection();
			PreparedStatement ps = connection.prepareStatement(SELECT_EMPLOYEE);
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				employee = new Employee();
				employee.setEmployeeId(rs.getInt(1));
				employee.setEmployeeName(rs.getString(2));
			}
			rs.close();
			ps.close();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return employee;
	}

	@Override
	public int addEmployee(Employee employee) {
		int insertedRows=-1;
		registerDatabaseDriver();
		try {
			Connection connection = getDatabaseConnection();
			PreparedStatement ps = connection.prepareStatement(INSERT_EMPLOYEE);
			ps.setInt(1, employee.getEmployeeId());
			ps.setString(2, employee.getEmployeeName());
			insertedRows = ps.executeUpdate();

			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return insertedRows;
	}

	@Override
	public int deleteEmployee(Integer employeeId) {
		int deleted=-1;
		registerDatabaseDriver();
		try {
			Connection connection = getDatabaseConnection();
			PreparedStatement ps = connection.prepareStatement(DELETE_EMPLOYEE);
			ps.setInt(1, employeeId);
			deleted = ps.executeUpdate();

			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return deleted;
	}

	@Override
	public int updateEmployee(Integer employeeId, Employee employee) {
		int updated=-1;
		registerDatabaseDriver();
		try {
			Connection connection = getDatabaseConnection();
			PreparedStatement ps = connection.prepareStatement(UPDATE_EMPLOYEE);
			ps.setString(1, employee.getEmployeeName());
			ps.setInt(2, employeeId);
			updated = ps.executeUpdate();

			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return updated;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		registerDatabaseDriver();
		try {
			Connection connection = getDatabaseConnection();
			PreparedStatement ps = connection.prepareStatement(SELECT_ALL_EMPLOYEES);
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(resultSet.getInt("emp_id"));
				emp.setEmployeeName(resultSet.getString("emp_name"));
				employees.add(emp);
			}
			
			resultSet.close();
			ps.close();
			connection.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return employees;
	}

	protected Connection getDatabaseConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(DB_URL, "karthikchejerla", "daksha");
		return connection;
	}

}
