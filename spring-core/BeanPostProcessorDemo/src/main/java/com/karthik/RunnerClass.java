package com.karthik;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunnerClass {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		
		for(int i=0; i<10; i++) {
			Shape shape = (Shape) context.getBean("triangle");
			shape.draw(i);
		}
		context.close();
	}
}
