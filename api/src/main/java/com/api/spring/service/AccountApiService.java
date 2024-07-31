package com.api.spring.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbcommon.mybatis.springbootproject01.entity.autogenerato.Account;
import com.dbcommon.mybatis.springbootproject01.entity.autogenerato.AccountExample;
import com.dbcommon.mybatis.springbootproject01.mapper.autogenerato.AccountMapper;
import com.webcommon.request.AccountRequest;
import com.webcommon.response.FrontSearchResponse;
import com.webcommon.spring.service.RestfulServiceImpl;

@Service
public class AccountApiService extends RestfulServiceImpl {

	private AccountMapper accountMapper;

	@Autowired
	public void setAccountMapper(AccountMapper accountMapper) {
		this.accountMapper = accountMapper;
	}

	@Override
	public void getProcessor() throws Exception {
		AccountRequest form = (AccountRequest) this.form;
				
		AccountExample example = new AccountExample();
		
		if (form.getAccountId() != null) {
			example
			  .createCriteria()
			    .andAccountIdEqualTo(form.getAccountId());
		}

		if (form.getResourceId() != null) {
			example
			  .createCriteria()
			    .andResourceIdEqualTo(form.getResourceId());
		}

		if (form.getAccountName() != null) {
			example
			  .createCriteria()
			    .andAccountNameEqualTo(form.getAccountName());
		}

		if (form.getAccountRead() != null) {
			example
			  .createCriteria()
			    .andAccountReadEqualTo(form.getAccountRead());
		}
		
		
		FrontSearchResponse response = new FrontSearchResponse();
		response.setSize(Long.bitCount(accountMapper.countByExample(example)));
		response.getList().addAll(accountMapper.selectByExample(example));
		this.response.setResponse(response);
	}

	@Override
	public void postProcessor() throws Exception {
		AccountRequest form = (AccountRequest) this.form;
		long i = accountMapper.countByExample(null);
		
		Account account = new Account();
		BeanUtils.copyProperties(form, account);
		account.setAccountId(UUID.randomUUID().toString());
		account.setMailaddress(i + "a@amail.com");
		account.setCreateDatetime(new Date());
		account.setUpdateDatetime(new Date());
		accountMapper.insert(account);
	}

	@Override
	public void putProcessor() throws Exception {
		AccountRequest form = (AccountRequest) this.form;
		Account account = new Account();
		account.setAccountId(form.getAccountId());
		Account _account = accountMapper.selectByPrimaryKey(account);

		BeanUtils.copyProperties(form, account);
		account.setCreateDatetime(_account.getCreateDatetime());
		account.setUpdateDatetime(new Date());
		accountMapper.updateByPrimaryKey(account);
	}

	@Override
	public void deleteProcessor() throws Exception {
		AccountRequest form = (AccountRequest) this.form;
		long i = accountMapper.countByExample(null);
		
		Account account = new Account();
		BeanUtils.copyProperties(form, account);
		accountMapper.deleteByPrimaryKey(account);
	}

}
