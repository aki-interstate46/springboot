package com.frontcommon.spring.service;

import org.springframework.web.HttpRequestMethodNotSupportedException;

import com.google.gson.Gson;
import com.systemcommon.spring.component.GsonUtil;
import com.webcommon.response.JsonResponse;
import com.webcommon.spring.service.BaseWebService;

/**
 * フロント処理共通クラス
 * 
 * @author Y.AKI
 * @version 1.0.0
 */
public abstract class FrontServiceImpl extends BaseWebService {
  
	/** 返却情報 */
  protected JsonResponse response;

	/** 初期化処理 */
  private void init() {
    response = new JsonResponse();
  }
  
	/** 共通チェック */
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
  
  /** Get通信共通処理 */
  public String get() throws Exception {
    this.init();
    if (this.commonValidation()) {
      
    }
    this.getProcessor();
    return json();
  }
  
  /** Get通信エラー処理 */
  @Override
  public void getProcessor() throws Exception {
    throw new HttpRequestMethodNotSupportedException("#NOT SUPPORTED");
  }
  
  /** Post通信共通処理 */
  public String post() throws Exception {
    this.init();
    if (this.commonValidation()) {
      
    }
    this.postProcessor();
    return json();
  }
  
  /** Post通信エラー処理 */
  @Override
  public void postProcessor() throws Exception {
    throw new HttpRequestMethodNotSupportedException("#NOT SUPPORTED");
  }
  
  /** Put通信共通処理 */
  public String put() throws Exception {
    this.init();
    if (this.commonValidation()) {
      
    }
    this.putProcessor();
    return json();
  }
  
  /** Put通信エラー処理 */
  @Override
  public void putProcessor() throws Exception {
    throw new HttpRequestMethodNotSupportedException("#NOT SUPPORTED");
  }
  
  /** Delete通信共通処理 */
  public String delete() throws Exception {
    this.init();
    if (this.commonValidation()) {
      
    }
    this.deleteProcessor();
    return json();
  }
  
  /** Delete通信エラー処理 */
  @Override
  public void deleteProcessor() throws Exception {
    throw new HttpRequestMethodNotSupportedException("#NOT SUPPORTED");
  }
}
