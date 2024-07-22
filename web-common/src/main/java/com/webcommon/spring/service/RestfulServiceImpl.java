package com.webcommon.spring.service;

import org.springframework.web.HttpRequestMethodNotSupportedException;

import com.google.gson.Gson;
import com.systemcommon.util.GsonUtil;
import com.webcommon.response.JsonResponse;

public abstract class RestfulServiceImpl extends BaseWebService {
	
	protected JsonResponse response;
	
	private void init() {
		response = new JsonResponse();
	}
	
	public boolean commonValidation() {
		return false;
	}
	
	private String json() {
		if (response.getResult() == null) {
			response.setResult("SUCCESS");
		}
		Gson gson = new GsonUtil().customDateFormat();
		return gson.toJson(response);
	}
	
	public String get() throws Exception {
		this.init();
		if (this.commonValidation()) {

		}
		this.getProcessor();
		return json();
	}

	@Override
	public void getProcessor() throws Exception {
		throw new HttpRequestMethodNotSupportedException("#NOT SUPPORTED");
	}

	public String post() throws Exception {
		this.init();
		if (this.commonValidation()) {

		}
		this.postProcessor();
		return json();
	}

	@Override
	public void postProcessor() throws Exception {
		throw new HttpRequestMethodNotSupportedException("#NOT SUPPORTED");
	}

	public String put() throws Exception {
		this.init();
		if (this.commonValidation()) {

		}
		this.putProcessor();
		return json();
	}

	@Override
	public void putProcessor() throws Exception {
		throw new HttpRequestMethodNotSupportedException("#NOT SUPPORTED");
	}

	public String delete() throws Exception {
		this.init();
		if (this.commonValidation()) {

		}
		this.deleteProcessor();
		return json();
	}

	@Override
	public void deleteProcessor() throws Exception {
		throw new HttpRequestMethodNotSupportedException("#NOT SUPPORTED");
	}
}
