package com.aop.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.aop.application.aspects.Audience;

@Configuration
//to enable AOP
@EnableAspectJAutoProxy
public class AspectConfig {

	@Bean
	public Audience audience(){
		return new Audience();
	}
}
