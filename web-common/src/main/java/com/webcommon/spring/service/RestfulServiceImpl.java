package com.webcommon.spring.service;

public abstract class RestfulServiceImpl extends BaseWebService {
	
	public boolean commonValidation() {
		return false;
	}

	public abstract String getProcessor() throws Exception;
	public String get() throws Exception {
		if (this.commonValidation()) {
			
		}
		return this.getProcessor();
	}
}
