package com.karthik.data.jdbc.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.karthik.data.model.Employee;
import com.karthik.data.model.EmployeeDao;

public class TestEmployeeDao {
	
	AbstractApplicationContext ctx = null;
	
	@Before
	public void setUpBeforeClass() throws Exception {
		ctx = new ClassPathXmlApplicationContext("spring-data.xml");
		ctx.registerShutdownHook();
	}

	@After
	public void tearDownAfterClass() throws Exception {
		ctx.close();
	}
	
	@Test
	public void testGetAllEmployees() {
		EmployeeDao employeeDao = ctx.getBean("employeeDao", EmployeeDao.class);
		assertThat(employeeDao.getAllEmployees().size()).isGreaterThan(1);
	}
	
	@Test
	public void testGetEmployee() {
		EmployeeDao employeeDao = ctx.getBean("employeeDao", EmployeeDao.class);
		assertThat(employeeDao.getEmployee(1).getEmployeeName()).isEqualTo("Karthik");
	}
	
	@Test
	public void testDeleteEmployee() {
		EmployeeDao employeeDao = ctx.getBean("employeeDao", EmployeeDao.class);
		assertThat(employeeDao.deleteEmployee(4)).isEqualTo(1);
	}
	
	@Test
	public void testUpdateEmployee() {
		EmployeeDao employeeDao = ctx.getBean("employeeDao", EmployeeDao.class);
		assertThat(employeeDao.updateEmployee(2, new Employee(2, "Virat Kohli"))).isEqualTo(1);
	}
	
	@Test
	public void testAddEmployee() {
		EmployeeDao employeeDao = ctx.getBean("employeeDao", EmployeeDao.class);
		assertThat(employeeDao.addEmployee(new Employee(5, "Daksha Chejerla")));
	}

}
