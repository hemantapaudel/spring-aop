package com.aop.application.aopapplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.aop.application.aopapplication.aspects.Audience;

@Configuration
//to enable AOP
@EnableAspectJAutoProxy
public class AspectConfig {

	@Bean
	public Audience audience(){
		return new Audience();
	}
}
