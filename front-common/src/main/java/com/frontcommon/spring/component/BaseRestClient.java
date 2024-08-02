package com.frontcommon.spring.component;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.boot.autoconfigure.web.client.RestClientSsl;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClient.RequestBodySpec;
import org.springframework.web.client.RestClient.ResponseSpec;

import com.frontcommon.exception.RestClientApiException;
import com.frontcommon.spring.handler.ResponseErrorHandlerImpl;

/**
 * RestClient管理クラス
 * 
 * @author Y.AKI
 * @version 1.0.0
 */
public abstract class BaseRestClient {
	
	/** 通信先情報 */
	private static final String BASE_URL = "http://localhost:8082";
	
	/** 通信先情報 */
	private RestClient.Builder restClientBuilder;
	/** 通信先情報 */
	private RestClientSsl ssl;
	
	/**
	 * コンストラクタ
	 * 
	 * @param restClientBuilder
	 * @param ssl
	 */
	public BaseRestClient(RestClient.Builder restClientBuilder, RestClientSsl ssl) {
		this.restClientBuilder = restClientBuilder;
		this.ssl = ssl;
	}
	
	/**
	 * RestClient生成クラス
	 * 
	 * @param isSsl true:SSL通信
	 * @return RestClient生成情報
	 */
	private RestClient restClientBuild(boolean isSsl) {
		RestClient restClient;
		if (isSsl) {
			// 仮実装
			restClient = restClientBuilder.apply(ssl.fromBundle("mybundle")).build();
		} else {
			restClient = restClientBuilder.build();
		}
		return restClient;
	}
	
	/**
	 * requestBody生成クラス
	 * 
	 * @param method 通信情報
	 * @param uri    通信先
	 * @return ResponseSpec作成情報
	 * @throws RestClientApiException
	 */
	protected ResponseSpec configureInformationAccess(HttpMethod method, String uri) throws RestClientApiException {
		return configureInformationAccess(method, uri, null);
	}
	
	/**
	 * requestBody生成クラス
	 * 
	 * @param method 通信情報
	 * @param uri    通信先
	 * @param body 送信情報
	 * @return ResponseSpec作成情報
	 * @throws RestClientApiException
	 */
	protected ResponseSpec configureInformationAccess(HttpMethod method, String uri, Object body)
	    throws RestClientApiException {
		RequestBodySpec requestBodySpec = restClientBuild(false).method(method).uri(BASE_URL + "/" + uri);
		if (HttpMethod.GET.equals(method)) {
			requestBodySpec.accept(MediaType.APPLICATION_JSON);
		} else {
			requestBodySpec.contentType(MediaType.APPLICATION_JSON);
			if (body != null) {
				requestBodySpec.body(body);
			}
		}
		return requestBodySpec.retrieve().onStatus(new ResponseErrorHandlerImpl());
	}
	
	/**
	 * Get通信を行うクラス
	 * 
	 * @param uri 通信先
	 * @return ResponseSpec作成情報
	 * @throws RestClientApiException
	 * @throws ArrayIndexOutOfBoundsException
	 * @throws UnsupportedEncodingException
	 * @throws IllegalArgumentException
	 */
	protected ResponseSpec get(String url) throws RestClientApiException, ArrayIndexOutOfBoundsException,
	    UnsupportedEncodingException, IllegalArgumentException {
		return get(url, null);
	}
	
	/**
	 * Get通信を行うクラス<br>
	 * URLパラメータを作成し、通信する
	 * 
	 * @param uri          通信先
	 * @param parameterMap 通信情報
	 * @return ResponseSpec作成情報
	 * @throws RestClientApiException
	 * @throws ArrayIndexOutOfBoundsException
	 * @throws UnsupportedEncodingException
	 * @throws IllegalArgumentException
	 */
	protected ResponseSpec get(String url, Map<String, String> parameterMap) throws RestClientApiException,
	    ArrayIndexOutOfBoundsException, UnsupportedEncodingException, IllegalArgumentException {
		String parame = "";
		if (parameterMap != null) {
			for (Entry<String, String> entry : parameterMap.entrySet()) {
				final Object value = entry.getValue();
				if (value == null) {
					continue;
				}
				if (value instanceof Date) {
					
				} else if (value.getClass().isArray()) {
					String _value = "";
					for (int i = 0; i < Array.getLength(value); i++) {
						_value += ("," + Array.get(value, i).toString());
					}
					parame += "&" + entry.getKey() + "=" + _value;
				} else {
					parame += "&" + entry.getKey() + "=" + entry.getValue();
				}
			}
			parame = parame.replaceFirst("&", "?");
		}
		url += parame;
		return configureInformationAccess(HttpMethod.GET, url);
	}
	
	/**
	 * Post通信を行うクラス<br>
	 * URLパラメータを作成し、通信する
	 * 
	 * @param uri  通信先
	 * @param body 通信情報
	 * @return ResponseSpec作成情報
	 * @throws RestClientApiException
	 * @throws ArrayIndexOutOfBoundsException
	 * @throws UnsupportedEncodingException
	 * @throws IllegalArgumentException
	 */
	protected ResponseSpec post(String url, Object body) throws RestClientApiException {
		return configureInformationAccess(HttpMethod.POST, url, body);
	}
	
	/**
	 * Put通信を行うクラス<br>
	 * URLパラメータを作成し、通信する
	 * 
	 * @param uri  通信先
	 * @param body 通信情報
	 * @return ResponseSpec作成情報
	 * @throws RestClientApiException
	 * @throws ArrayIndexOutOfBoundsException
	 * @throws UnsupportedEncodingException
	 * @throws IllegalArgumentException
	 */
	protected ResponseSpec put(String url, Object body) throws RestClientApiException {
		return configureInformationAccess(HttpMethod.PUT, url, body);
	}
	
	/**
	 * Delete通信を行うクラス<br>
	 * URLパラメータを作成し、通信する
	 * 
	 * @param uri  通信先
	 * @param body 通信情報
	 * @return ResponseSpec作成情報
	 * @throws RestClientApiException
	 * @throws ArrayIndexOutOfBoundsException
	 * @throws UnsupportedEncodingException
	 * @throws IllegalArgumentException
	 */
	protected ResponseSpec delete(String url, Object body) throws RestClientApiException {
		return configureInformationAccess(HttpMethod.DELETE, url, body);
	}
}
