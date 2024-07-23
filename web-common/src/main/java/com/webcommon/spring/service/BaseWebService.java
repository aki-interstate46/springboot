package com.webcommon.spring.service;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.webcommon.form.BaseWebForm;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class BaseWebService {
	public abstract void getProcessor() throws Exception;
	public abstract void postProcessor() throws Exception;
	public abstract void putProcessor() throws Exception;
	public abstract void deleteProcessor() throws Exception;
	protected BaseWebForm form;

	protected BindingResult result;

	protected HttpServletRequest request;

	protected HttpServletResponse response;

	protected Model model;
	
	protected void webInitialize() {
		
	}
	
	public BaseWebService setForm(BaseWebForm form) {
		this.form = form;
		return this;
	}
	
	public BaseWebService setBindingResult(BindingResult result) {
		this.result = result;
		return this;
	}
	
	public BaseWebService setRequest(HttpServletRequest request) {
		this.request = request;
		return this;
	}
	
	public BaseWebService setResponse(HttpServletResponse response) {
		this.response = response;
		return this;
	}
	
	public BaseWebService setModel(Model model) {
		this.model = model;
		return this;
	}

}
