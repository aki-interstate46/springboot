package com.systemcommon.enums;

/**
 * JOB返却用ENUM
 * 
 * @author Y.AKI
 * @version 1.0.0
 */
public enum SystemExit {
  
	/** 成功 */
  COMPLETED(0)
	/** 異常 */
  , FAILED(1);
  
  private int value;
  
  private SystemExit(int value) {
    this.value = value;
  }
  
  public int getValue() {
    return this.value;
  }
}
