package com.karthik;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	@Pointcut("execution(public double com.karthik.Circle.getArea(..))")
	public void allCircleMethods(){}
	
	@Before("allCircleMethods())")
	public void beforeAdviceForAllMethods(JoinPoint joinPoint){
		System.out.println("Entering method: " + getMethodName(joinPoint));
	}
	
	@After("allCircleMethods())")
	public void afterAdviceForAllMethods(JoinPoint joinPoint){
		System.out.println("Exiting method: " + getMethodName(joinPoint));
	}
	
	@AfterReturning(pointcut="execution(double com.karthik.*.getArea(..))", returning="area")
	public void getAreaAdvice(double area){
		System.out.println("Calculated area is: " + area);
	}
	
	// Spring will call the appropriate advice depending on the exception that is thrown.
	@AfterThrowing(pointcut="execution(double com.karthik.*.getArea(..))", throwing="ex")
	public void getAreaIllegalArgumentExceptionAdvice(IllegalArgumentException ex){
		System.out.println("Invalid argument(s) passed: " + ex.getMessage());
	}
	
	@AfterThrowing(pointcut="execution(double com.karthik.*.getArea(..))", throwing="ex")
	public void getAreaExceptionAdvice(Exception ex){
		System.out.println("Unknown Exception occurred: " + ex.getMessage());
	}
	
	protected String getMethodName(JoinPoint joinPoint){
		return joinPoint.getSignature().toLongString();
	}
}
