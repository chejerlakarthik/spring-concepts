package com.karthik.data.hibernate.main;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.karthik.data.hibernate.model.Asset;
import com.karthik.data.hibernate.model.Employee;
import com.karthik.data.hibernate.service.DepartmentService;
import com.karthik.data.hibernate.service.EmployeeService;
import com.karthik.data.hibernate.util.HelperUtil;

public class Runner {
	
	static AbstractApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();

		EmployeeService employeeService = context.getBean(EmployeeService.class);
		DepartmentService departmentService = context.getBean(DepartmentService.class);
		
		departmentService.addDepartments(HelperUtil.listDepartments());
		
		// 1. Insert few employees
		System.out.println("Adding Employees");
		for (String empName : HelperUtil.listEmployeeNames()) {
			employeeService.add(newEmployee(empName, departmentService));
		}
		
		System.out.println("Get All Employees");
		// 2. Get All Employees
		for (Employee emp: employeeService.getAll()) {
			System.out.println(emp);
		}
		
		// 3. Get Employee
		System.out.println("Get Employee");
		List<Employee> employees = employeeService.findByName("Aarthi");
		System.out.println(employees);
		
		assertThat(employees.size()).isGreaterThan(0);
		
		// 4. Update Employee
		System.out.println("Update Employee");
		Employee emp1 = employees.get(0);
		System.out.println("Salary before update: " + emp1.getSalary());
		emp1.setSalary(150000.00);
		employeeService.update(emp1);
		System.out.println("Salary after update: " + emp1.getSalary());
		
		// 5. Delete Employee
		System.out.println("Delete Employee");
		System.out.println("# of employees before delete: " + employeeService.getAll().size());
		employeeService.deleteById(2);
		System.out.println("# of employees after delete: " + employeeService.getAll().size());

		context.close();
	}

	protected static Employee newEmployee(String employeeName, DepartmentService departmentService) {
		Employee emp = new Employee();
		emp.setEmployeeName(employeeName);
		emp.setEmployer(HelperUtil.randomEmployer());
		emp.setSalary(HelperUtil.randomDouble());
		emp.setDepartment(departmentService.findByName(HelperUtil.randomDepartmentName()).get(0));
		emp.setCubicle(HelperUtil.randomLong());
		Asset myAsset = new Asset();
		emp.getAssets().add(myAsset);
		myAsset.setEmployee(emp);
		emp.setLastModified(new Date());
		return emp;
	}
    
}
