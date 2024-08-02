package com.api.spring.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

/**
* アカウントRESTAPIクラス
* 
* @author　Y.AKI
* @version　1.0.0
*/
@RestController
@RequestMapping(value = "/account")
public class AccountApiRestController extends BaseApiRestControlerImpl {

  @Autowired
  private AccountApiService service;
  
  /**
   * 初期化
   * 
   * @return form
   */
  @ModelAttribute
  public AccountRequest setupForm() {
    return new AccountRequest();
  }
  
	/**
	 * Get通信
	 * 
	 * @param form    Formオブジェクト
	 * @param result  Validation結果
	 * @param request HttpServletRequestオブジェクト
	 * @return 返却情報
	 * @throws Exception
	 */
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public String get(AccountRequest form, BindingResult result, HttpServletRequest request) throws Exception {
    service.setForm(form);
    return service.get();
  }
  
	/**
	 * Post通信
	 * 
	 * @param form    Formオブジェクト
	 * @param result  Validation結果
	 * @param request HttpServletRequestオブジェクト
	 * @return 返却情報
	 * @throws Exception
	 */
  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public String post(@RequestBody AccountRequest form, BindingResult result, HttpServletRequest request)
      throws Exception {
    service.setForm(form);
    return service.post();
  }
  
	/**
	 * Put通信
	 * 
	 * @param form    Formオブジェクト
	 * @param result  Validation結果
	 * @param request HttpServletRequestオブジェクト
	 * @return 返却情報
	 * @throws Exception
	 */
  @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public String put(@RequestBody AccountRequest form, BindingResult result, HttpServletRequest request)
      throws Exception {
    service.setForm(form);
    return service.put();
  }
  
	/**
	 * Delete通信
	 * 
	 * @param form    Formオブジェクト
	 * @param result  Validation結果
	 * @param request HttpServletRequestオブジェクト
	 * @return 返却情報
	 * @throws Exception
	 */
  @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public String delete(@RequestBody AccountRequest form, BindingResult result, HttpServletRequest request)
      throws Exception {
    service.setForm(form);
    return service.delete();
  }
  
}
