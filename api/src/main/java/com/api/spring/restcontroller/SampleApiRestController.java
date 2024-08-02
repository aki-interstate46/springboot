package com.api.spring.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.spring.service.SampleApiService;
import com.apicommon.spring.restcontroller.BaseApiRestControlerImpl;

/**
* サンプルRESTAPIクラス
* 
* @author　Y.AKI
* @version　1.0.0
*/
@RestController
@RequestMapping(value = "/sample")
public class SampleApiRestController extends BaseApiRestControlerImpl {
	
	private SampleApiService service;
	
	@Autowired
	public void setSampleApiService(SampleApiService service) {
		this.service = service;
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
	public String get() throws Exception {
		return service.get();
	}
	
}
