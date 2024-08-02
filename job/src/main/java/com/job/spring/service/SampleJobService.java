package com.job.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbcommon.mybatis.springbootproject01.mapper.autogenerato.AccountMapper;
import com.jobcommon.spring.service.JobServiceImpl;

@Service
public class SampleJobService extends JobServiceImpl {
  
  private AccountMapper account;
  
  @Autowired
  public void setAccountMapper(AccountMapper account) {
    this.account = account;
  }
  
  @Override
  public void logic() {
    System.out.println(account.countByExample(null));
  }
  
}
