package com.karthik;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Triangle implements Shape{

	public void draw() {
		System.out.println("Drawing Triangle ");
	}
	
	public void init() {
		System.out.println("Created a triangle bean");
	}
	
	@PostConstruct
	public void postconstruct() {
		System.out.println("JSR-250 @PostConstruct - Not Coupled with Spring");
	}
	
	@PreDestroy
	public void predestroy() {
		System.out.println("JSR-250 @PreDestroy - Not Coupled with Spring");
	}

}
