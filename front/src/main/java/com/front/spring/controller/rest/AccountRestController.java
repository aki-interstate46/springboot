package com.front.spring.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.front.spring.service.rest.AccountRestService;
import com.frontcommon.form.AccountForm;
import com.frontcommon.spring.controller.BaseFrontControler;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/account/rest")
public class AccountRestController extends BaseFrontControler {
	
	private AccountRestService service;
	
	private static final String TABLE_NAME = "account";
	
	@ModelAttribute
	public AccountForm setUp(Model model) {
		this.init(TABLE_NAME);
		return new AccountForm();
	}
	
	@Autowired
	public void setAccountRestService(AccountRestService service) {
		this.service = service;
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String get(@Validated AccountForm form, BindingResult result, Model model, HttpServletRequest request) throws Exception {
		service.setForm(form).setBindingResult(result).setModel(model).setRequest(request);
		return service.get();
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String post(@Validated AccountForm form, BindingResult result, Model model, HttpServletRequest request) throws Exception {
		service.setForm(form).setBindingResult(result).setModel(model).setRequest(request);
		return service.post();
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String put(@Validated AccountForm form, BindingResult result, Model model, HttpServletRequest request) throws Exception {
		service.setForm(form).setBindingResult(result).setModel(model).setRequest(request);
		return service.put();
	}
	
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String delete(@Validated AccountForm form, BindingResult result, Model model, HttpServletRequest request) throws Exception {
		service.setForm(form).setBindingResult(result).setModel(model).setRequest(request);
		return service.delete();
	}
}
