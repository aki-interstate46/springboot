package com.frontcommon.exception;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;

public class RestClientApiException extends IOException {
	HttpStatusCode httpStatusCode;
	HttpHeaders httpHeaders;
	public RestClientApiException(HttpStatusCode httpStatusCode, HttpHeaders httpHeaders) {
		this.httpStatusCode = httpStatusCode;
		this.httpHeaders = httpHeaders;
	}
	private static final long serialVersionUID = 1L;

}
