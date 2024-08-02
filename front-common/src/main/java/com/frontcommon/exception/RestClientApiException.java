package com.frontcommon.exception;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;

import lombok.Getter;

/**
 * API通信時にハンドリングするクラス
 * 
 * @author Y.AKI
 * @version 1.0.0
 */
@Getter
public class RestClientApiException extends IOException {
  
	/** シリアルID */
	private static final long serialVersionUID = 1L;
  
	/** エラーコード */
  private HttpStatusCode httpStatusCode;

  /** httpHeaders情報 */
  private HttpHeaders httpHeaders;
  
  /**
   * コンストラクタ
   * 
   * @param httpStatusCode エラーコード
   * @param httpHeaders    httpHeaders情報
   */
  public RestClientApiException(HttpStatusCode httpStatusCode, HttpHeaders httpHeaders) {
    this.httpStatusCode = httpStatusCode;
    this.httpHeaders    = httpHeaders;
  }
  
  
}
