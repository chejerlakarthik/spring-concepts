package com.karthik.data;

import org.junit.Test;

public class TestGetAllEmployees {

	@Test
	public void test() {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		
		for (Employee emp : employeeDao.getAllEmployees()) {
			System.out.println(emp);
		}
	}

}
