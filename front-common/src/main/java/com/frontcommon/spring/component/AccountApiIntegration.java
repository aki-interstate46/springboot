package com.frontcommon.spring.component;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.frontcommon.form.AccountForm;
import com.systemcommon.spring.component.GsonUtil;
import com.webcommon.request.AccountRequest;
import com.webcommon.response.JsonResponse;

@Component
public class AccountApiIntegration {

	@Autowired
	private RestClientImple restClient;
	
	@Autowired
	private GsonUtil gson;
	
	private static final String URL = "account";
	
	public JsonResponse get(AccountForm form) throws Exception {
		Map<String, String> parameterMap = new HashMap<>();
		parameterMap.put("accountId", form.getAccountId());
		parameterMap.put("resourceId", form.getResourceId());
		parameterMap.put("accountName", form.getAccountName());
		parameterMap.put("accountRead", form.getAccountRead());
		return restClient.getBodyTypeJsonResponse(URL, parameterMap);
	}
	
	public JsonResponse post(AccountForm form) throws Exception {
		AccountRequest d = new AccountRequest();
		BeanUtils.copyProperties(form, d);
		return restClient.postBodyTypeJsonResponse(URL, d);
	}
	
	public JsonResponse put(AccountForm form) throws Exception {
		AccountRequest d = new AccountRequest();
		BeanUtils.copyProperties(form, d);
		return restClient.putBodyTypeJsonResponse(URL, d);
	}
	
	public JsonResponse delete(AccountForm form) throws Exception {
		AccountRequest d = new AccountRequest();
		BeanUtils.copyProperties(form, d);
		return restClient.deleteBodyTypeJsonResponse(URL, d);
	}
}
