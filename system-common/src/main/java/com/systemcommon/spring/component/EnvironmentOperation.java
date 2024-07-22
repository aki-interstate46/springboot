package com.systemcommon.spring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

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
