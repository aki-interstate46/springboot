package com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.systemcommon.util.FQCNBeanNameGenerator;

/**
 * API起動クラス
 * 
 * @author Y.AKI
 * @version 1.0.0
 */
//@formatter:off
@SpringBootApplication
@ComponentScan(basePackages = {
  "com.api.spring"
  , "com.dbcommon.spring"
  , "com.apicommon.spring"
  , "com.webcommon.spring"
  , "com.systemcommon.spring"
} , nameGenerator = FQCNBeanNameGenerator.class)
//@formatter:on
public class ApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(ApiApplication.class, args);
  }

}
