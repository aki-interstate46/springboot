package com.systemcommon.spring.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.systemcommon.util.UtilGetClassName;

@Component
public class SystemLog {
	
	private final Logger lOG = LoggerFactory.getLogger(UtilGetClassName.getClassName());
	
	@Autowired
	private EnvironmentOperationList eol;
	
	private boolean common() {
		return true;
	}
	
	public void debug() {
		if (this.common()) {
			lOG.debug(null);
		}
	}
	public void info(String msg, String args) {
		UtilGetClassName.getClassName();
		if (this.common()) {
			lOG.info(msg, args);
		}
	
		
	}
	public void warn(Exception e) {
		if (this.common()) {
			lOG.debug(null);
		}
	}
	public void error(Exception e) {
		if (this.common()) {
			lOG.error(null, e);
		}
	
		
	}
	
}
