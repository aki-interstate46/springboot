package com.front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.systemcommon.util.FQCNBeanNameGenerator;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.front.spring"
		, "com.frontcommon.spring"
		, "com.webcommon.spring"
		, "com.systemcommon.spring"
		} , nameGenerator = FQCNBeanNameGenerator.class)
//@MapperScan(value = {"com.dbcommon.mybatis.springbootprojec
public class FrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrontApplication.class, args);
	}

}
