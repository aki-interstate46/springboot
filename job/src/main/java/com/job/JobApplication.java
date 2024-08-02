package com.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.jobcommon.startup.JobRunner;
import com.systemcommon.util.FQCNBeanNameGenerator;

@SpringBootApplication
@ComponentScan(basePackages = {
  "com.job.spring"
  , "com.dbcommon.spring"
  , "com.jobcommon.spring"
  , "com.systemcommon.spring"
} , nameGenerator = FQCNBeanNameGenerator.class)
public class JobApplication extends JobRunner {
  
  public static void main(String[] args) {
    SpringApplication application = new SpringApplication(JobApplication.class);
    run(application, args);
  }
}
