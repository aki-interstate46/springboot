package com.jobcommon.spring.service;

import org.slf4j.LoggerFactory;

public abstract class JobServiceImpl implements JobService {
	public abstract void logic();

	private boolean jobCommon() {
		LoggerFactory.getLogger(this.getClass()).debug("#jobCommon");
		return true;
	}

	@Override
	public void processer() {
		LoggerFactory.getLogger(this.getClass()).debug("#processer");
		if (!jobCommon()) {
			return;
		}
		LoggerFactory.getLogger(this.getClass()).debug("#logic");
		logic();
	}
}
