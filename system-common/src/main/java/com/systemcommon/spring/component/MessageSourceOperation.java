package com.systemcommon.spring.component;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class MessageSourceOperation {

	private MessageSource messageSource;

	@Autowired
	public void setmessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public String getMessage(String key) {
		return getMessage(key, new Object[] {}, Locale.getDefault());
	}

	public String getMessage(String key, Object[] args) {
		return getMessage(key, args, Locale.getDefault());
	}

	public String getMessage(String key, Object[] args, Locale locale) {
		return this.messageSource.getMessage(key, args, locale);
	}

}
