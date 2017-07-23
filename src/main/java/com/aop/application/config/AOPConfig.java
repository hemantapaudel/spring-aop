package com.aop.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.aop.application.aspect.LoggerAspect;
import com.aop.application.aspect.LoggerAspectAround;
import com.aop.application.aspect.LoggerAspectWithArgs;
import com.aop.application.model.Circle;
import com.aop.application.model.Triangle;
import com.aop.application.service.ShapeService;

@Configuration
@EnableAspectJAutoProxy
public class AOPConfig {

	@Bean
	public Circle circle(){
		return new Circle();
	}
	
	@Bean
	public Triangle triangle(){
		return new Triangle();
	}
	
	@Bean
	ShapeService shapeService(){
		ShapeService shapeService = new ShapeService();
		shapeService.setCircle(circle());
		shapeService.setTriangle(triangle());
		return shapeService;
	}
	
	//@Bean
	LoggerAspect loggerAspect(){
		return new LoggerAspect();
	}
	
	//@Bean
	LoggerAspectWithArgs loggerAspectWithArgs(){
		return new LoggerAspectWithArgs();
	}
	
	@Bean
	LoggerAspectAround loggerAspectAround(){
		return new LoggerAspectAround();
	}
	
}
