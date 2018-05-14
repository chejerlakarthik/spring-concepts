package com.karthik.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	@Pointcut("execution(public Double com.karthik.model.*.*(..))")
	public void allMethods() {
	}

	@Before("allMethods())")
	public void beforeAdviceForAllMethods(JoinPoint joinPoint) {
		System.out.println("Entering method: " + getMethodName(joinPoint));
	}

	@After("allMethods())")
	public void afterAdviceForAllMethods(JoinPoint joinPoint) {
		System.out.println("Exiting method: " + getMethodName(joinPoint));
	}

	@AfterReturning(pointcut = "execution(Double com.karthik.model.*.getArea(..))", returning = "area")
	public void getAreaAdvice(Double area) {
		System.out.println("Calculated area is: " + area);
	}

	// Spring will call appropriate advice depending on thrown exception
	@AfterThrowing(pointcut = "execution(Double com.karthik.model.*.getArea(..))", throwing = "ex")
	public void getAreaIllegalArgumentExceptionAdvice(IllegalArgumentException ex) {
		System.out.println("Invalid argument(s) passed: " + ex.getMessage());
	}

	@Around("@annotation(com.karthik.aspect.LogAround)")
	public Double getPerimeterAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		Double returnValue = 0.0;
		try {
			returnValue = (Double) proceedingJoinPoint.proceed();
			System.out.println("Perimeter of the shape is "+ returnValue);
		} catch (Throwable ex) {
			System.out.println("Around: Exception - " + ex.getMessage());
		}
		return returnValue;
	}

	/**
	 * Return the fully qualified method name to go into the logs.
	 * @param joinPoint
	 * @return
	 */
	protected String getMethodName(JoinPoint joinPoint) {
		return String.format("%s.%s()", joinPoint.getTarget().getClass().getName(), 
										joinPoint.getSignature().getName());
	}
}
