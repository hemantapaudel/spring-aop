package com.aop.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.aop.application.service.ShapeService;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context=	SpringApplication.run(Application.class, args);
		
		System.out.println("=====started===");
		
		ShapeService service = context.getBean(ShapeService.class);
		service.getCircle().setName("Dummy circle");
		System.out.println(service.getCircle().getName() );
		System.out.println(service.getTriangle().getName() );
		
	}
}
