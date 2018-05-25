package com.karthik.data.hibernate;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.karthik.data.hibernate.model.Department;
import com.karthik.data.hibernate.model.Employee;
import com.karthik.data.hibernate.model.Employer;
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
	public void testAddEmployee() {
		Employee emp = new Employee(5, "Rohit Sharma", Employer.ORACLE);
		emp.setDepartment(new Department("HKP", "Housekeeping"));
		emp.setCubicle(5001L);
		emp.setSalary(50000.00);
		service.add(emp);
	}
	
	@Test
	public void testGetAllEmployees() {
		List<Employee> employees = service.getAll();
		
		assertThat(employees.size()).isGreaterThan(0);	
	}
	
	@Test
	public void testGetEmployee() {
		Employee employee = service.get(1);
		
		assertThat(employee.getEmployeeName()).isNotBlank();
	}
	
	@Test
	public void testUpdateEmployee() {
		Employee employee = service.get(18);
		employee.setSalary(65000.00);
		service.update(employee);
	}
	
	@Test
	public void testDeleteEmployee() {
		service.deleteById(3);
	}

}
