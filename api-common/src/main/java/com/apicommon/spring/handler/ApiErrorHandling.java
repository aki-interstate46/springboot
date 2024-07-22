package com.apicommon.spring.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.systemcommon.enums.ApiResultInfo;
import com.systemcommon.util.GsonUtil;
import com.webcommon.response.JsonResponse;

@ControllerAdvice
public class ApiErrorHandling {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiErrorHandling.class);
    
    private String handlingCommon(Exception e) {
    	JsonResponse jsonResponse = new JsonResponse();
    	jsonResponse.setResult(ApiResultInfo.ERROR.name());
    	String resurt = new GsonUtil().customDateFormat().toJson(jsonResponse);
    	LOGGER.debug("#ERROR RESPONSE：{}" , resurt);
    	return resurt;
    }
    
    @ResponseBody
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleException(Exception e) {
        LOGGER.error("Exception", e);
        return handlingCommon(e);
    }
	
}
