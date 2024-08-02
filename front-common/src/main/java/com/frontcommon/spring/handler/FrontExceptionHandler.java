package com.frontcommon.spring.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestClientException;

import com.frontcommon.exception.RestClientApiException;

/**
 * Frontハンドリングクラス
 * 
 * @author Y.AKI
 * @version 1.0.0
 */
@ControllerAdvice
public class FrontExceptionHandler {
  private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
  
  
  /**
   * エラー返却共通クラス
   * 
   * @param e エクセプション情報
   * @return
   */
  private String handlingCommon(Exception e) {
    return "error";
  }
  
  /**
	 * 指定していない場合のエラーをハンドリングするクラス
	 * 
   * @param e エクセプション情報
   * @return 画面
   */
  @ExceptionHandler({ Exception.class })
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String handlerException(Exception e) {
    return handlingCommon(e);
  }
  
  /**
   * RestApiハンドリングクラス
   * 
   * @param e エクセプション情報
   * @return 画面
   */
  @ExceptionHandler({ RestClientApiException.class, RestClientException.class })
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String handlerRestClientException(RestClientApiException e) {
    LOGGER.error("Exception", e);
    return handlingCommon(e);
  }
  
}
