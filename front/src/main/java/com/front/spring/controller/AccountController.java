package com.front.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.front.form.Sample;
import com.frontcommon.form.AccountForm;
import com.frontcommon.spring.controller.BaseFrontControler;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/account")
public class AccountController extends BaseFrontControler {
	
	private static final String PROCESS_NAME = "account";
	
	@ModelAttribute
	public AccountForm setUp(HttpServletRequest request) {
		this.init(PROCESS_NAME);
		return new AccountForm();
	}
	
	@GetMapping
	public String get(@Validated Sample form, BindingResult result, Model model, HttpServletRequest request) throws Exception {
		return PROCESS_NAME;
	}
	
}
