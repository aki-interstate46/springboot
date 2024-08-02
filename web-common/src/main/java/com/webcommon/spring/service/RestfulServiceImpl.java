package com.webcommon.spring.service;

import org.springframework.web.HttpRequestMethodNotSupportedException;

import com.google.gson.Gson;
import com.systemcommon.spring.component.GsonUtil;
import com.webcommon.response.JsonResponse;

public abstract class RestfulServiceImpl extends BaseWebService {
  
  protected JsonResponse response;

	/** 初期化処理 */
  private void init() {
    response = new JsonResponse();
  }

	/** 共通処理 */
  public boolean commonValidation() {
    return false;
  }

	/** 返却処理 */
  private String json() {
    if (response.getStatus() == null) {
      response.setStatus("SUCCESS");
    }
    Gson gson = new GsonUtil().customDateFormat();
    return gson.toJson(response);
  }

	/**
	 * Get通信共通処理
	 * 
	 * @throws Exception
	 */
  public String get() throws Exception {
    this.init();
    if (this.commonValidation()) {
      
    }
    this.getProcessor();
    return json();
  }

	/**
	 * Get処理
	 * 
	 * @throws Exception
	 */
  @Override
  public void getProcessor() throws Exception {
    throw new HttpRequestMethodNotSupportedException("#NOT SUPPORTED");
  }

	/**
	 * Post通信共通処理
	 * 
	 * @throws Exception
	 */
  public String post() throws Exception {
    this.init();
    if (this.commonValidation()) {
      
    }
    this.postProcessor();
    return json();
  }

	/**
	 * Post処理
	 * 
	 * @throws Exception
	 */
  @Override
  public void postProcessor() throws Exception {
    throw new HttpRequestMethodNotSupportedException("#NOT SUPPORTED");
  }

	/**
	 * Put処理
	 * 
	 * @throws Exception
	 */
  public String put() throws Exception {
    this.init();
    if (this.commonValidation()) {
      
    }
    this.putProcessor();
    return json();
  }

	/**
	 * Put通信共通処理
	 * 
	 * @throws Exception
	 */
  @Override
  public void putProcessor() throws Exception {
    throw new HttpRequestMethodNotSupportedException("#NOT SUPPORTED");
  }

	/**
	 * Delete処理
	 * 
	 * @throws Exception
	 */
  public String delete() throws Exception {
    this.init();
    if (this.commonValidation()) {
      
    }
    this.deleteProcessor();
    return json();
  }

	/**
	 * Delete処理
	 * 
	 * @throws Exception
	 */
  @Override
  public void deleteProcessor() throws Exception {
    throw new HttpRequestMethodNotSupportedException("#NOT SUPPORTED");
  }
}
