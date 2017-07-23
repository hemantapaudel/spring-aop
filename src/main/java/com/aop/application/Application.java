package com.aop.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.application.config.AOPConfig;
import com.aop.application.service.ShapeService;


//@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context=	 new  AnnotationConfigApplicationContext(AOPConfig.class);
		
		System.out.println("=====started===");
		ShapeService service = context.getBean(ShapeService.class);
		service.getCircle().setNameAndReturn("Dummy circle");
		
		
		System.out.println(service.getCircle().getName() );
		//System.out.println(service.getTriangle().getName() );
		
	}
}
