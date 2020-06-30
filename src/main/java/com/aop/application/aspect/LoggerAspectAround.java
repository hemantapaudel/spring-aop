package com.aop.application.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggerAspectAround {

	
	@Pointcut("execution(public String com.aop.application.model.*.get*())")
	public void getAllGetters(){}
	
	
	@Around("getAllGetters()")
	public Object addLogerAdviceForAllMethods(ProceedingJoinPoint  joinPoint){
		
		Object returnValue =null;
		try {
			System.out.println("Before target Getter called");
			returnValue =  joinPoint.proceed();
			System.out.println("After target Getter called");
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
		return returnValue;
	}
}
