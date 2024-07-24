package com.frontcommon.spring.component;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLEncoder;
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

public abstract class BaseRestClient {
	private static final String BASE_URL = "http://localhost:8082";

	private RestClient.Builder restClientBuilder;
	private RestClientSsl ssl;

	public BaseRestClient(RestClient.Builder restClientBuilder, RestClientSsl ssl) {
		this.restClientBuilder = restClientBuilder;
		this.ssl = ssl;
	}

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

	protected ResponseSpec configureInformationAccess(HttpMethod method, String uri) throws RestClientApiException {
		return configureInformationAccess(method, uri, null);
	}

	protected ResponseSpec configureInformationAccess(HttpMethod method, String uri, String body) throws RestClientApiException {
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
//		try {
//		} catch (Exception e) {
//		      throw new RestClientException(requestBodySpec.retrieve().getStatusCode(), requestBodySpec.getHeaders()); 
//		}
	}

	protected ResponseSpec get(String url) throws RestClientApiException, ArrayIndexOutOfBoundsException, UnsupportedEncodingException, IllegalArgumentException {
		return get(url, null);
	}

	protected ResponseSpec get(String url, Map<String, String> parameterMap) throws RestClientApiException, ArrayIndexOutOfBoundsException, UnsupportedEncodingException, IllegalArgumentException {
		String parame = "";
		if (parameterMap != null) {
			for (Entry<String, String> entry : parameterMap.entrySet()) {
				final Object value = entry.getValue();
				if (value instanceof Date) {
					
				} else if (value.getClass().isArray()) {
					String _value = "";
					for (int i = 0; i < Array.getLength(value); i++) {
						_value += ("," + URLEncoder.encode(Array.get(value, i).toString(), "UTF-8"));
					}
					parame += "&" + entry.getKey() + "=" + _value;
				} else {
					parame += "&" + entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), "UTF-8");
				}
			}
			parame = parame.replaceFirst("&", "?");
		}
		url += parame;
		return configureInformationAccess(HttpMethod.GET, url);
	}

	protected ResponseSpec post(String url, String body) throws RestClientApiException {
		return configureInformationAccess(HttpMethod.POST, url, body);
	}

	protected ResponseSpec put(String url, String body) throws RestClientApiException {
		return configureInformationAccess(HttpMethod.PUT, url, body);
	}

	protected ResponseSpec delete(String url, String body) throws RestClientApiException {
		return configureInformationAccess(HttpMethod.DELETE, url, body);
	}
}
