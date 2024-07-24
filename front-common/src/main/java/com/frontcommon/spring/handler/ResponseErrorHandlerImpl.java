package com.frontcommon.spring.handler;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import com.frontcommon.exception.RestClientApiException;


public class ResponseErrorHandlerImpl implements ResponseErrorHandler {

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		if (response.getStatusCode() != HttpStatus.OK) {
//			logger.debug("Status code: " + clienthttpresponse.getStatusCode());
//			logger.debug("Response" + clienthttpresponse.getStatusText());
//			logger.debug(clienthttpresponse.getBody());

			return true;
		}
		return false;
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		throw new RestClientApiException(response.getStatusCode(), response.getHeaders());
	}

}
