package com.karthik;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunnerClass {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		
		for(int i=0; i<10; i++) {
			Shape shape = (Shape) context.getBean("triangle");
			shape.draw();
		}
		
		Semester semester = (Semester) context.getBean(Semester.class);
		System.out.println(semester);
		
		Circle circle = (Circle) context.getBean("circle");
		circle.draw();
		
		Line line = (Line) context.getBean("line");
		line.draw();
		
		context.close();
	}
}
