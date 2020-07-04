package com.aop.application.registry;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceLocatorConfig {

    @Bean
    FactoryBean<?> factoryBean(){
      ServiceLocatorFactoryBean serviceLocatorFactoryBean = new ServiceLocatorFactoryBean();
      serviceLocatorFactoryBean.setServiceLocatorInterface(PaymentServiceRegistry.class);
      return serviceLocatorFactoryBean;
  }

}



