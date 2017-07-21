package com.aop.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.aop.application.concert.Performance;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		ApplicationContext context=	SpringApplication.run(AopApplication.class, args);
		
		
		Performance performance = context.getBean(Performance.class);
		performance.perform();
		
		
		performance.print(10);
	}
}
