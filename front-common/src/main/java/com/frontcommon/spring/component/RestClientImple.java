package com.frontcommon.spring.component;

import java.util.Map;

import org.springframework.boot.autoconfigure.web.client.RestClientSsl;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient.Builder;

import com.webcommon.response.JsonResponse;

@Component
public class RestClientImple extends BaseRestClient {

	public RestClientImple(Builder arg0, RestClientSsl arg1) {
		super(arg0, arg1);
	}
	
	public JsonResponse getBodyTypeJsonResponse(String url) throws Exception {
		return get(url).body(JsonResponse.class);
	}
	public JsonResponse getBodyTypeJsonResponse(String url, Map<String, String> parameterMap) throws Exception {
		return get(url, parameterMap).body(JsonResponse.class);
	}
	public JsonResponse postBodyTypeJsonResponse(String url, Object body) throws Exception {
		return post(url, body).body(JsonResponse.class);
	}
	public JsonResponse putBodyTypeJsonResponse(String url, Object body) throws Exception {
		return put(url, body).body(JsonResponse.class);
	}
	public JsonResponse deleteBodyTypeJsonResponse(String url, Object body) throws Exception {
		return delete(url, body).body(JsonResponse.class);
	}
}
