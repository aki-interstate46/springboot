package com.systemcommon.spring.component;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * GsonUtil
 * 
 * @author Y.AKI
 * @version 1.0.0
 */
@Component
public class GsonUtil {
  
	/** 日付形式 */
  public static final String CUSTOM_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";
  
  public Gson defaultGson() {
    return new Gson();
  }
  
  public Gson customDateFormat() {
    return new GsonBuilder().setDateFormat(CUSTOM_DATE_FORMAT).create();
  }
  
}
