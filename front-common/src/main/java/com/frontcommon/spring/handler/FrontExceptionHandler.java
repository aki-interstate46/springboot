package com.frontcommon.spring.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestClientException;

import com.frontcommon.exception.RestClientApiException;
import com.systemcommon.enums.ApiResultInfo;
import com.systemcommon.spring.component.GsonUtil;
import com.webcommon.response.JsonResponse;

@ControllerAdvice
public class FrontExceptionHandler extends ResponseErrorHandlerImpl {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    
    private String handlingCommon(Exception e) {
    	return "error";
    }
    
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerException(Exception e) {
        return handlingCommon(e);
    }
    
    @ExceptionHandler({RestClientApiException.class, RestClientException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerRestClientException(RestClientApiException e) {
        LOGGER.error("Exception", e);
        return handlingCommon(e);
    }

}
