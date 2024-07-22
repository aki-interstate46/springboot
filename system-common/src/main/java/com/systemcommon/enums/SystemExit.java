package com.systemcommon.enums;

public enum SystemExit {

	COMPLETED(0)
	, FAILED(1)
	;

	private int value;

	private SystemExit(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
}
