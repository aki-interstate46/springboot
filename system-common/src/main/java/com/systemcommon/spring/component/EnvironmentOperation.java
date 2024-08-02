package com.systemcommon.spring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 * 環境情報取得処理
 * 
 * @author Y.AKI
 * @version 1.0.0
 */
public class EnvironmentOperation {
  
  private Environment enviroment;
  
  @Autowired
  public void setEnviroment(Environment enviroment) {
    this.enviroment = enviroment;
  }
  
  public boolean isContainsProperty(String key) {
    return this.enviroment.containsProperty(key);
  }
  
  public String getProperty(String key) {
    return this.enviroment.getProperty(key);
  }
  
}
