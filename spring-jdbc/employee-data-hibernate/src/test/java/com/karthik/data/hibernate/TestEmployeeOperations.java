package com.karthik.data.hibernate;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.karthik.data.hibernate.model.Employee;
import com.karthik.data.hibernate.service.EmployeeService;

class TestEmployeeOperations {

	AbstractApplicationContext context = null;
	
	@BeforeEach
	void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
	}

	@AfterEach
	void tearDown() throws Exception {
		context.close();
	}

	@Test
	void testGetAllEmployees() {
		EmployeeService service = context.getBean(EmployeeService.class);
		List<Employee> employees = service.getAllEmployees();
		
		assertThat(employees.size()).isGreaterThan(2);	
	}
	

	void testGetEmployee() {
		EmployeeService service = context.getBean(EmployeeService.class);
		Employee employee = service.getEmployee(1);
		
		assertThat(employee.getEmployeeName()).isEqualTo("Karthik");
	}
	
	@Test
	void testAddEmployee() {
		EmployeeService service = context.getBean(EmployeeService.class);
		service.addEmployee(new Employee(5, "Virat Kohli"));
	}

}
