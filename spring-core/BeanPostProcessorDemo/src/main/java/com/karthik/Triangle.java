package com.karthik;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Triangle implements Shape{

	public void draw(int i) {
		System.out.println("Drawing Triangle-" + String.valueOf(i));
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
