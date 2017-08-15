package com.aop.application.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect

public class LoggerAspect {

	//Applying Advice on all model classes getName methods
	@Pointcut("execution(public String com.aop.application.model.*.get*())")
	public void getAllGetters(){}
	
	@Before("getAllGetters()")
	public void loggerAdvice(){
		System.out.println("LoggerAspect called for getName method");
	}
	
	@Pointcut("within(com.aop.application.model.Circle)")
	public void allCircleMethod(){}
	
	
	@Before("allCircleMethod()")
	public void addLogerAdviceForAllMethods(){
		System.out.println("LoggerAspect called for allCircleMethod");
	}
	
	@Before("getAllGetters() && allCircleMethod()")
	public void addAdviceForCircleGetterMethod(){
		System.out.println("LoggerAspect called for Circle.get*");
	}
	
	
	
}
