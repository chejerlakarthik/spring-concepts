package com.karthik.programmatic.container;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.karthik.java.annotation.config.Greeting;

@Configuration
@ComponentScan(basePackages = "com.karthik.programmatic.container")
public class SpringConfiguration {
	
	@Bean
	public Greeting greeting() {
		return new Greeting("Good Morning!!");
	}

}
