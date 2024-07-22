package com.apicommon.spring.restcontroller;

public abstract class BaseApiResrControler {
	
	public abstract String get() throws Exception;
	public abstract String put() throws Exception;
	public abstract String post() throws Exception;
	public abstract String delete() throws Exception;
}
