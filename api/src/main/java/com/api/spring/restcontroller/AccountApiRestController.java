package com.api.spring.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.spring.service.AccountApiService;
import com.apicommon.spring.restcontroller.BaseApiRestControlerImpl;
import com.webcommon.request.AccountRequest;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/account")
public class AccountApiRestController extends BaseApiRestControlerImpl {
	
	private AccountApiService service;

    @ModelAttribute
    public AccountRequest setupForm(){
        return new AccountRequest();
    }
	
	@Autowired
	public void setAccountApiService(AccountApiService service) {
		this.service = service;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String get(AccountRequest form, BindingResult result, HttpServletRequest request) throws Exception {
		service.setForm(form);
		return service.get();
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String post(@RequestBody AccountRequest form, BindingResult result, HttpServletRequest request) throws Exception {
		service.setForm(form);
		return service.post();
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String put(@RequestBody AccountRequest form, BindingResult result, HttpServletRequest request) throws Exception {
		service.setForm(form);
		return service.put();
	}

	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String delete(@RequestBody AccountRequest form, BindingResult result, HttpServletRequest request) throws Exception {
		service.setForm(form);
		return service.delete();
	}
	
}
