package com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.systemcommon.util.FQCNBeanNameGenerator;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.api.spring"
		, "com.dbcommon.spring"
		, "com.apicommon.spring"
		, "com.webcommon.spring"
		, "com.systemcommon.spring"
		} , nameGenerator = FQCNBeanNameGenerator.class)
//@MapperScan(value = {"com.dbcommon.mybatis.springbootprojec
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
