package com.karthik.data.jdbc.traditional;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.karthik.data.jdbc.traditional.EmployeeDaoImpl;
import com.karthik.data.model.Employee;
import com.karthik.data.model.EmployeeDao;

public class TestGetAllEmployees {

	@Test
	public void testAllEmployees() {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		List<Employee> employees = employeeDao.getAllEmployees();
		
		assertThat(employees.size()==4);
	}
	
	@Test
	public void testEmployeeById() {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		
		assertThat(employeeDao.getEmployee(3).getEmployeeName()).isEqualTo("Sanjeev");
	}
	
	@Test
	public void testNewEmployee() {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		
		assertThat(employeeDao.addEmployee(new Employee(5, "Uday Shankar"))).isEqualTo(1);
		assertThat(employeeDao.addEmployee(new Employee(6, "C P Mohan Rao"))).isEqualTo(1);
	}
	
	@Test
	public void testDeleteEmployee() {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		
		assertThat(employeeDao.deleteEmployee(2)).isEqualTo(1);
	}
	
	@Test
	public void testUpdateEmployee() {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		
		assertThat(employeeDao.updateEmployee(1, new Employee(6, "Mohan Rao"))).isEqualTo(1);
	}

}
