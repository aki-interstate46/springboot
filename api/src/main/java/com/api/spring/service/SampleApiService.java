package com.api.spring.service;

import org.springframework.stereotype.Service;

import com.webcommon.spring.service.RestfulServiceImpl;

@Service
public class SampleApiService extends RestfulServiceImpl {

	@Override
	public String getProcessor() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return "test";
	}

}
