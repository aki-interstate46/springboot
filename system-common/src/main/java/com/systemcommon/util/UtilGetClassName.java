package com.systemcommon.util;

import java.lang.invoke.MethodHandles.Lookup.ClassOption;

public class UtilGetClassName {
	public static String getClassName() {
		System.out.println(Thread.currentThread().getStackTrace()[0].getClassName());
		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName());
		System.out.println(Thread.currentThread().getStackTrace()[2].getClassName());
		System.out.println(Thread.currentThread().getStackTrace()[3].getClassName());
		return Thread.currentThread().getStackTrace()[1].getClassName();
	}
}
