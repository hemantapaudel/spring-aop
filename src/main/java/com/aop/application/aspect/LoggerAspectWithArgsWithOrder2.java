package com.aop.application.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class LoggerAspectWithArgsWithOrder2 {
	
	
	@Pointcut("within(com.aop.application.model.Circle)")
	public void allCircleMethod(){}

	
	/**
	 * Q1. what happend if we throw exception from @Before Advice method" 
	 *  Answer : it will be failed without invoking original message
	 * 
	 */
	@Before("allCircleMethod() && args(name)")
	public void allCircleMethodWhichTakesStringArgs(JoinPoint joinPoint, String name){
		System.out.println("========allCircleMethodWhichTakesStringArgs=======");
		System.out.println("LoggerAspect called for "+joinPoint.getTarget().getClass() + " name = "+ name );
		System.out.println("LoggerAspect called for "+joinPoint.getClass() + " name = "+ name );
		//throw new RuntimeException("Throwing exception from Advice");
	}
	
}
