package com.karthik;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class SpringConfiguration {
	
	@Bean("circle")
	public Shape circle(){
		return new Circle(5.0);
	}
	
	@Bean("rectangle")
	public Shape rectangle(){
		return new Rectangle();
	}

	@Bean
	public LoggingAspect loggingAspect(){
		return new LoggingAspect();
	}
}
