package com.karthik.java.annotation.config;

import org.springframework.beans.factory.annotation.Autowired;

public class Welcome {
	
	private Greeting greeting;
	
	public Welcome() {}
	
	@Autowired
	public Welcome(Greeting greeting) {
		System.out.println("Injecting greeting");
		this.greeting = greeting;
	}
	
	public void printMessage() {
		greeting.getMessage();
	}

	public Greeting getGreeting() {
		return greeting;
	}

	public void setGreeting(Greeting greeting) {
		this.greeting = greeting;
	}
	
}
