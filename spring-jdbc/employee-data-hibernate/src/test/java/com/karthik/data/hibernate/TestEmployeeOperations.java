package com.karthik.data.hibernate;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.karthik.data.hibernate.model.Employee;
import com.karthik.data.hibernate.service.EmployeeService;

public class TestEmployeeOperations {

	AbstractApplicationContext context = null;
	EmployeeService service = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		service = context.getBean(EmployeeService.class);
	}

	@After
	public void tearDown() throws Exception {
		context.close();
	}

	@Test
	public void testGetAllEmployees() {
		List<Employee> employees = service.getAllEmployees();
		
		assertThat(employees.size()).isGreaterThan(2);	
	}
	
	@Test
	public void testGetEmployee() {
		Employee employee = service.getEmployee(1);
		
		assertThat(employee.getEmployeeName()).contains("Virat");
	}
	
	@Test
	public void testAddEmployee() {
		service.addEmployee(new Employee(5, "Rohit Sharma"));
	}
	
	@Test
	public void testUpdateEmployee() {
		service.updateEmployee(2, new Employee(2, "Aarthi Sundar"));
	}
	
	@Test
	public void testDeleteEmployee() {
		service.deleteEmployee(8);
	}

}
