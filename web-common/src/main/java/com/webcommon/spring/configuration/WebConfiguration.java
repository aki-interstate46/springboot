package com.webcommon.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.webcommon.spring.handler.RequestInterceptor;

/**
 * インターセプタ登録処理
 * 
 * @author Y.AKI
 * @version 1.0.0
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
	@Bean
	public RequestInterceptor requestInterceptor() {
		return new RequestInterceptor();
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestInterceptor());
	}
	
}
