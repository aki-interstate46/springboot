package com.front.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.front.form.Sample;
import com.front.spring.service.SampleService;
import com.frontcommon.spring.controller.BaseFrontControler;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/account")
public class AccountController extends BaseFrontControler {
	
	private SampleService service;
	
	private static final String TABLE_NAME = "account";
	
	@ModelAttribute
	public Sample setUp(Model model) {
		this.init(TABLE_NAME);
		return new Sample();
	}
	
	@Autowired
	public void setSampleService(SampleService service) {
		this.service = service;
	}
	
	@GetMapping
	public String get(@Validated Sample form, BindingResult result, Model model, HttpServletRequest request) throws Exception {
		return TABLE_NAME;
	}
	
	@PostMapping
	public String post(@Validated Sample form, BindingResult result, Model model, HttpServletRequest request) throws Exception {
		service.setForm(form).setBindingResult(result).setModel(model).setRequest(request);
		service.postProcessor();
		return TABLE_NAME;
	}
	
}
