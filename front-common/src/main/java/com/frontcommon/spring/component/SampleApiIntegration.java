package com.frontcommon.spring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webcommon.response.JsonResponse;

@Component
public class SampleApiIntegration {

	@Autowired
	private RestClientImple restClient;
	
	private static final String URL = "sample";
	
	public void get() throws Exception {
		JsonResponse ddd = restClient.getBodyTypeJsonResponse(URL);
		ddd = restClient.putBodyTypeJsonResponse(URL, null);
		ddd = restClient.postBodyTypeJsonResponse(URL, null);
		ddd = restClient.deleteBodyTypeJsonResponse(URL, null);
		System.out.println(ddd);
	}
}
