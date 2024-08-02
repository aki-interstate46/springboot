package com.frontcommon.spring.component;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.frontcommon.form.AccountForm;
import com.webcommon.request.AccountRequest;
import com.webcommon.response.JsonResponse;

/**
 * アカウントAPI管理クラス
 * 
 * @author Y.AKI
 * @version 1.0.0
 */
@Component
public class AccountApiIntegration {
  
  @Autowired
  private RestClientImple restClient;
  
  /** URL情報 */
  private static final String URL = "account";
  
  /**
   * Get通信を行うクラス
   * 
   * @param form 送信情報
   * @return 返却情報
   * @throws Exception
   */
  public JsonResponse get(AccountForm form) throws Exception {
    Map<String, String> parameterMap = new HashMap<>();
    parameterMap.put("accountId", form.getAccountId());
    parameterMap.put("resourceId", form.getResourceId());
    parameterMap.put("accountName", form.getAccountName());
    parameterMap.put("accountRead", form.getAccountRead());
    return restClient.getBodyTypeJsonResponse(URL, parameterMap);
  }
  
  /**
   * Post通信を行うクラス
   * 
   * @param form 送信情報
   * @return 返却情報
   * @throws Exception
   */
  public JsonResponse post(AccountForm form) throws Exception {
    AccountRequest d = new AccountRequest();
    BeanUtils.copyProperties(form, d);
    return restClient.postBodyTypeJsonResponse(URL, d);
  }
  
  /**
   * Put通信を行うクラス
   * 
   * @param form 送信情報
   * @return 返却情報
   * @throws Exception
   */
  public JsonResponse put(AccountForm form) throws Exception {
    AccountRequest d = new AccountRequest();
    BeanUtils.copyProperties(form, d);
    return restClient.putBodyTypeJsonResponse(URL, d);
  }
  
  /**
   * Delete通信を行うクラス
   * 
   * @param form 送信情報
   * @return 返却情報
   * @throws Exception
   */
  public JsonResponse delete(AccountForm form) throws Exception {
    AccountRequest d = new AccountRequest();
    BeanUtils.copyProperties(form, d);
    return restClient.deleteBodyTypeJsonResponse(URL, d);
  }
}
