package com.systemcommon.util;

/**
 * クラス名取得処理
 * 
 * @author Y.AKI
 * @version 1.0.0
 */
public class UtilGetClassName {
	public static String getClassName() {
		return Thread.currentThread().getStackTrace()[1].getClassName();
	}
}
