package com.apicommon.spring.restcontroller;

import org.springframework.http.MediaType;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseApiResrControlerImpl extends BaseApiResrControler {

	@Override
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String get() throws Exception {
		throw new HttpRequestMethodNotSupportedException("#NOT SUPPORTED"); 
	}

	@Override
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String put() throws Exception {
		throw new HttpRequestMethodNotSupportedException("#NOT SUPPORTED"); 
	}

	@Override
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String post() throws Exception {
		throw new HttpRequestMethodNotSupportedException("#NOT SUPPORTED"); 
	}

	@Override
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String delete() throws Exception {
		throw new HttpRequestMethodNotSupportedException("#NOT SUPPORTED"); 
	}


}
