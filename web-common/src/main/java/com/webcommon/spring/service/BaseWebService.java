package com.webcommon.spring.service;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.webcommon.form.BaseWebForm;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * SampleResponse
 * 
 * @author Y.AKI
 * @version 1.0.0
 */
public abstract class BaseWebService {
	
	/**
	 * Get処理
	 * 
	 * @throws Exception
	 */
	public abstract void getProcessor() throws Exception;
	
	/**
	 * Post処理
	 * 
	 * @throws Exception
	 */
	public abstract void postProcessor() throws Exception;
	
	/**
	 * Put処理
	 * 
	 * @throws Exception
	 */
	public abstract void putProcessor() throws Exception;
	
	/**
	 * Delete処理
	 * 
	 * @throws Exception
	 */
	public abstract void deleteProcessor() throws Exception;
	
	/** Formオブジェクト */
	protected BaseWebForm form;
	
	/** Validation結果 */
	protected BindingResult result;
	
	/** HttpServletRequestオブジェクト */
	protected HttpServletRequest request;
	
	/** HttpServletResponseオブジェクト */
	protected HttpServletResponse response;
	
	/** Modelオブジェクト */
	protected Model model;
	
	/** 初期化処理 */
	protected void webInitialize() {
		
	}
	
	/** Formオブジェクトセット */
	public BaseWebService setForm(BaseWebForm form) {
		this.form = form;
		return this;
	}
	
	/** Validation結果セット */
	public BaseWebService setBindingResult(BindingResult result) {
		this.result = result;
		return this;
	}
	
	/** HttpServletRequestオブジェクトセット */
	public BaseWebService setRequest(HttpServletRequest request) {
		this.request = request;
		return this;
	}
	
	/** HttpServletResponseオブジェクトセット */
	public BaseWebService setResponse(HttpServletResponse response) {
		this.response = response;
		return this;
	}
	
	/** Modelオブジェクトセット */
	public BaseWebService setModel(Model model) {
		this.model = model;
		return this;
	}
	
}
