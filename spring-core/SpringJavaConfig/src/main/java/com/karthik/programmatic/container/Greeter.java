package com.karthik.programmatic.container;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.karthik.java.annotation.config.Greeting;

public class Greeter {
	
	public static void main(String[] args) {
		// Instantiate the Spring bean container (AnnotationConfigApplicationContext)
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.registerShutdownHook();
		
		// Register one or more configuration classes
		context.register(SpringConfiguration.class);
		context.refresh(); // Reload the context
		
		// Ask Spring container for the greeting bean
		Greeting greeting = (Greeting) context.getBean("greeting");
		greeting.getMessage();
		
		context.close();
	}

}
