package com.frontcommon.spring.component;

import java.util.Map;

import org.springframework.boot.autoconfigure.web.client.RestClientSsl;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient.Builder;

import com.webcommon.response.JsonResponse;

/**
 * RestClientImple管理クラス
 * 
 * @author Y.AKI
 * @version 1.0.0
 */
@Component
public class RestClientImple extends BaseRestClient {
	
	/**
	 * コンストラクタ
	 * 
	 * @param restClientBuilder
	 * @param ssl
	 */
  public RestClientImple(Builder arg0, RestClientSsl arg1) {
    super(arg0, arg1);
  }
	
	/**
	 * Get通信を行うクラス<br>
	 * 
	 * @param uri  通信先
	 * @param body 通信情報
	 * @return API返却結果
	 * @throws Exception
	 */
  public JsonResponse getBodyTypeJsonResponse(String url) throws Exception {
    return get(url).body(JsonResponse.class);
  }
	
	/**
	 * Get通信を行うクラス<br>
	 * URLパラメータを作成し、通信する
	 * 
	 * @param uri  通信先
	 * @param body 通信情報
	 * @return API返却結果
	 * @throws Exception
	 */
  public JsonResponse getBodyTypeJsonResponse(String url, Map<String, String> parameterMap) throws Exception {
    return get(url, parameterMap).body(JsonResponse.class);
  }
	
	/**
	 * Post通信を行うクラス<br>
	 * 
	 * @param uri  通信先
	 * @param body 通信情報
	 * @return API返却結果
	 * @throws Exception
	 */
  public JsonResponse postBodyTypeJsonResponse(String url, Object body) throws Exception {
    return post(url, body).body(JsonResponse.class);
  }
	
	/**
	 * Put通信を行うクラス<br>
	 * URLパラメータを作成し、通信する
	 * 
	 * @param uri  通信先
	 * @param body 通信情報
	 * @return API返却結果
	 * @throws Exception
	 */
  public JsonResponse putBodyTypeJsonResponse(String url, Object body) throws Exception {
    return put(url, body).body(JsonResponse.class);
  }
	
	/**
	 * Delete通信を行うクラス<br>
	 * URLパラメータを作成し、通信する
	 * 
	 * @param uri  通信先
	 * @param body 通信情報
	 * @return API返却結果
	 * @throws Exception
	 */
  public JsonResponse deleteBodyTypeJsonResponse(String url, Object body) throws Exception {
    return delete(url, body).body(JsonResponse.class);
  }
}
