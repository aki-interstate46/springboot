package com.front.spring.service.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frontcommon.form.AccountForm;
import com.frontcommon.spring.component.AccountApiIntegration;
import com.webcommon.response.FrontSearchResponse;
import com.webcommon.response.JsonResponse;
import com.webcommon.spring.service.RestfulServiceImpl;

@Service
public class AccountRestService extends RestfulServiceImpl {
	
	@Autowired
	private AccountApiIntegration accountApi;

	@Override
	public void getProcessor() throws Exception {
		JsonResponse response = accountApi.get((AccountForm) this.form);
		this.response = response;
	}

	@Override
	public void postProcessor() throws Exception {
		accountApi.post((AccountForm) this.form);
	}

	@Override
	public void putProcessor() throws Exception {
		accountApi.put((AccountForm) this.form);
	}

	@Override
	public void deleteProcessor() throws Exception {
		accountApi.delete((AccountForm) this.form);
	}

	private void other(String method) {
		List<Object> sampleList = new ArrayList<>();
		AccountForm form = (AccountForm)this.form;
		for (int i = 0; i < 5; i++) {
			AccountForm sample = new AccountForm();
			sample.setAccountId(i + "-" + method + "-" + form.getAccountId());
			sample.setAccountName(i + "-" + method + "-name");
			sample.setAccountRead(i + "-" + method + "-read");
			sampleList.add(sample);
		}
		
		FrontSearchResponse resopnce = new FrontSearchResponse();
		resopnce.setList(sampleList);
		resopnce.setSize(sampleList.size());
		response.setResponse(resopnce);
	}
	
    public static class SampleOther {
		public int testField1 = 1;
		public String testField2 = "testField2";

		public String getMethod() {
			return "getMethod";
		}
    }

}
