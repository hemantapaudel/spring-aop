
package com.aop.application.config;


import com.aop.application.security.UserServiceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * this interceptor will only intercept user service
 */
@Component
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    @Autowired
    UserServiceInterceptor userServiceInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userServiceInterceptor)
                .addPathPatterns("/userservice/*");
    }
}

