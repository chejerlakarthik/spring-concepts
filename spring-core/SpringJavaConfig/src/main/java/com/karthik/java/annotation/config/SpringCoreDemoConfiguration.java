/**
 * 
 */
package com.karthik.java.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author karthikchejerla
 *
 */
@Configuration
@ComponentScan(basePackages = "com.karthik")
public class SpringCoreDemoConfiguration {
	
	@Bean
	public Greeting greeting() {
		return new Greeting("Hello World!!");
	}
	
	@Bean
	public Welcome welcome() {
		return new Welcome(greeting());
	}

}
