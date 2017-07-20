package com.aop.application.aopapplication.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {

	@Pointcut("execution(** com.aop.application.aopapplication.concert.Performance.perform(..))")
	public void performance() {
	}

	
	  @Before("performance()") public void takeSeats() {
	  System.out.println("Taking seats"); }
	  
	  @Before(
	  "execution(** com.aop.application.aopapplication.concert.Performance.perform(..))"
	  ) public void silenceCellPhones() {
	  System.out.println("Silencing cell phones"); }
	  
	  @AfterReturning("performance()") public void applause() {
	  System.out.println("CLAP CLAP CLAP!!!"); }
	  
	  @AfterThrowing("performance()") public void demandRefund() {
	  System.out.println("Demanding a refund"); }
	 

	@Around("performance()")
	public void watchPerformance(ProceedingJoinPoint jp) {
		try {
			System.out.println("Taking seats");
			System.out.println("Silencing cell phones");
			jp.proceed();
			System.out.println("CLAP CLAP CLAP!!!");
		} catch (Throwable e) {
			System.out.println("Demanding a refund");
		}
	}

}
