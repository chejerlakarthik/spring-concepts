package com.karthik;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Greeter {
	
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringCoreDemoConfiguration.class);
		context.registerShutdownHook();
		
		Welcome welcome = (Welcome) context.getBean(Welcome.class);
		welcome.printMessage();
		
		context.close();
	}

}
