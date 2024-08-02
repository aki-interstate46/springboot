package com.frontcommon.spring.handler;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import com.frontcommon.exception.RestClientApiException;

/**
 * APIErrorハンドリングクラス <br>
 * BaseRestClientクラスでAPI通信を行った際、エラーハンドリングを行う。
 * 
 * @author Y.AKI
 * @version 1.0.0
 */
public class ResponseErrorHandlerImpl implements ResponseErrorHandler {
  
  /**
   * エラー判定処理
   */
  @Override
  public boolean hasError(ClientHttpResponse response) throws IOException {
    if (response.getStatusCode() != HttpStatus.OK) {
      return true;
    }
    return false;
  }
  
  /**
   * エラー情報設定処理
   */
  @Override
  public void handleError(ClientHttpResponse response) throws IOException {
    throw new RestClientApiException(response.getStatusCode(), response.getHeaders());
  }
  
}
