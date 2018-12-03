package com.xjlin.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleDemo {
	public static void main(String[] args) {
		/*
		 * ResourceBundle在查找资源文件时,首先找指定的,如果找不到找操作系统语言环境的,如果还找不到用默认的
		 */
		ResourceBundle bundle = ResourceBundle.getBundle("resource",Locale.ENGLISH);
//		ResourceBundle bundle = ResourceBundle.getBundle("resource");
		String value = bundle.getString("username");
		System.out.println(value);
	}
}
