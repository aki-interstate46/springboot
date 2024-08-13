package com.systemcommon.spring.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration(proxyBeanMethods = false)
public class AppConfig {
	
	@Bean
	@Scope("prototype")
	public Logger logger(InjectionPoint injectionPoint) {
    Logger logger;
    try {
      logger = LoggerFactory.getLogger(injectionPoint.getMethodParameter().getContainingClass());
		} catch (Exception e) {
	    logger = LoggerFactory.getLogger(injectionPoint.getField().getDeclaringClass());
		}
    return logger;
	}
	
}
