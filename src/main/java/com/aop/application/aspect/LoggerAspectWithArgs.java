
package com.aop.application.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspectWithArgs {

	
	
	@Pointcut("within(com.aop.application.model.Circle)")
	public void allCircleMethod(){}
	
	
	@Before("allCircleMethod()")
	public void addLogerAdviceForAllMethods(JoinPoint joinPoint){
		joinPoint.getTarget();
		System.out.println("LoggerAspect called for "+joinPoint.getTarget());
	}
	
	
	
	@Before("args(String)")
	public void stringArgumentMethod(){
		System.out.println("a method take string argument called");
	}
	
	
}
