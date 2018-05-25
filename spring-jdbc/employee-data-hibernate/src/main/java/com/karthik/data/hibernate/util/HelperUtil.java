package com.karthik.data.hibernate.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.karthik.data.hibernate.model.Department;
import com.karthik.data.hibernate.model.Employer;

public final class HelperUtil {
	
	private static List<Department> depts = Arrays.asList(new Department("HR", "Human Resources"),
			   											  new Department("TL", "Transport & Logistics"),
			   											  new Department("IT", "Information Technology"),
			   											  new Department("SC", "Physical Security"),
			   											  new Department("HP", "Hospitality"));
	
	public static Long randomLong(Long lowerLimit, Long upperLimit) {
		return (lowerLimit + (long) (Math.random() * (upperLimit - lowerLimit)));
	}
	
	public static Long randomLong() {
		Long lowerLimit = 1000L;
		Long upperLimit = 9999L;
		return (lowerLimit + (long) (Math.random() * (upperLimit - lowerLimit)));
	}
	
	public static Double randomDouble() {
		Double lowerLimit = 10000.00;
		Double upperLimit = 100000.00;
		return (double) Math.round((lowerLimit + (Math.random() * (upperLimit - lowerLimit))));
	}
	
	public static List<String> listEmployeeNames() {
		return Arrays.asList("Aarthi", "Daksha", "Karthik", 
							 "Vihaan", "Uday Shankar", "Sanjeev", 
							 "Archana", "Mohan Rao",
							 "Yashoda", "Sundar", "Usha");
	}
	
	public static Employer randomEmployer() {
		Random random = new Random();
		List<Employer> names = Collections.unmodifiableList(Arrays.asList(Employer.values()));
		return names.get(random.nextInt(Employer.values().length));
	}
	
	
	public static String randomDepartmentName() {
		Random random = new Random();
		List<String> departmentNames = new ArrayList<String>();
		for (Department dept : depts) {
			departmentNames.add(dept.getDepartmentName());
		}
		return departmentNames.get(random.nextInt(5));
	}
	
	public static List<Department> listDepartments(){
		return depts;
	}
	
}
