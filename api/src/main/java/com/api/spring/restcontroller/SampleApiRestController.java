package com.api.spring.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.spring.service.SampleApiService;
import com.apicommon.spring.restcontroller.BaseApiResrControlerImpl;

@RestController
@RequestMapping(value = "/sample")
public class SampleApiRestController extends BaseApiResrControlerImpl {
	
	private SampleApiService service;
	
	@Autowired
	public void setSampleApiService(SampleApiService service) {
		this.service = service;
	}

	@Override
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String get() throws Exception {
		return service.get();
	}
	
}
