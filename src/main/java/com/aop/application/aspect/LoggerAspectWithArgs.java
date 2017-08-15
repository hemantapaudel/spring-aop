
package com.aop.application.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class LoggerAspectWithArgs { 

	
	@Pointcut("within(com.aop.application.model.Circle)")
	public void allCircleMethod(){}
	
	
	@Before("args(name)")
	public void stringArgumentMethod(String name){
		System.out.println("=============stringArgumentMethod======");
		System.out.println("@Before : a method take string argument called = "+name);
	}
	
	
	/**
	@After("args(name)")
	public void stringArgumentMethodAfter(String name){
		System.out.println("@After : a method take string argument called = "+name);
	}
	@AfterReturning("args(name)")
	public void stringArgumentMethodAfterReturn(String name){
		System.out.println("@AfterReturning : a method take string argument called = "+name);
	}
	
	@AfterThrowing("args(name)")
	public void stringArgumentMethodAfterThrowing(String name){
		System.out.println("@AfterThrowing: a method take string argument called = "+name);
	}
	
	//capturing returned value
	@AfterReturning(pointcut ="args(name)", returning = "returnName")
	public void stringArgumentMethodAfterReturn(String name,String returnName){
		System.out.println("@AfterReturning : a method take string argument called =>> "+name + " return name=>>"+returnName);
	}*/
	
}
